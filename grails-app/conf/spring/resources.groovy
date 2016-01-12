import com.Person
import grails.rest.render.json.JsonCollectionRenderer
import grails.rest.render.xml.XmlCollectionRenderer
import restapi.Country

// Place your Spring DSL code here
beans = {
    countryJsonRenderer(JsonCollectionRenderer, Country) {
        excludes = ['abreviation']
    }

    personJsonRenderer(XmlCollectionRenderer, Person){
        excludes = ["age"]
    }
}
