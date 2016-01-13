import com.Person
import restapi.Country

class BootStrap {

    def init = { servletContext ->
        if (!Person.count()) {
            new Person(firstName: "Vijay", lastName: "Shukla", age: 25).save(flush: true)
            new Person(firstName: "Karan", lastName: "Aahuja", age: 30).save(flush: true)
        }
        if (!Country.count()) {
            new Country(countryName: "India", abreviation: "IN", continent: "Asia").save(flush: true)
            new Country(countryName: "USA", abreviation: "US", continent: "West").save(flush: true)
            new Country(countryName: "Japan", abreviation: "JP", continent: "Asia").save(flush: true)
            new Country(countryName: "Itly", abreviation: "IT", continent: "East").save(flush: true)
        }
//
//        JSON.registerObjectMarshaller(Country) {
//            return [
//                    id  : it.id,
//                    name: it.countryName,
//                    abbv: it.abreviation,
//                    cont: it.continent
//            ]
//        }
    }
    def destroy = {
    }
}
