import grails.rest.render.json.JsonCollectionRenderer
import restapi.Country

// Place your Spring DSL code here
beans = {
    countryJsonRenderer(JsonCollectionRenderer, Country) {
        excludes = ['abreviation']
    }
}
