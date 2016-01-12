import com.CountryCustomRenderer
import com.CountryJSONRenderer
import com.Person
import grails.rest.render.json.JsonCollectionRenderer
import grails.rest.render.xml.XmlCollectionRenderer
import restapi.Country

// Place your Spring DSL code here
beans = {
//    countryJsonRenderer(XmlCollectionRenderer, Country) {
//        excludes = ['abreviation']
//    }
//
//    personJsonRenderer(JsonCollectionRenderer, Person) {
//        excludes = ["age"]
//    }

//    customCountryRenderer = CountryCustomRenderer       //JSON


    countryJsonRenderer = CountryJSONRenderer
}
