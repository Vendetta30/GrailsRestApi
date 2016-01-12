package restapi

import grails.rest.RestfulController

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CountryController extends RestfulController {

//    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    static responseFormats = ["xml", "json"]

    CountryController() {
        super(Country)
    }

    def index(Integer max) {
        println("Index has been hitted")
        params.max = Math.min(max ?: 10, 100)
        respond Country.list(params), model: [countryCount: Country.count()]
    }

    def show(Country country) {
        println("Show has been hitted")
        respond country
    }

    def create() {
        println("Create has been hitted")
        respond new Country(params)
    }

    @Transactional
    def save(Country country) {
        println("Save has been hitted")
        if (country == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (country.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond country.errors, view: 'create'
            return
        }

        country.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'country.label', default: 'Country'), country.id])
                redirect country
            }
            '*' { respond country, [status: CREATED] }
        }
    }

    def edit(Country country) {
        println("Edit has been hitted")
        respond country
    }

    @Transactional
    def update(Country country) {
        println("Update has been hitted")
        if (country == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (country.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond country.errors, view: 'edit'
            return
        }

        country.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'country.label', default: 'Country'), country.id])
                redirect country
            }
            '*' { respond country, [status: OK] }
        }
    }

    @Transactional
    def delete(Country country) {
        println("Delete has been hitted")

        if (country == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        country.delete flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'country.label', default: 'Country'), country.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        println("Not Found has been hitted")
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'country.label', default: 'Country'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
