package com

import grails.rest.render.AbstractRenderer
import grails.rest.render.RenderContext
import grails.web.mime.MimeType
import groovy.json.JsonBuilder
import restapi.Country

class CountryJSONRenderer extends AbstractRenderer<Country> {

    CountryJSONRenderer() {
        super(Country, [MimeType.JSON, MimeType.TEXT_JSON] as MimeType[])
    }

    void render(Country country, RenderContext context) {
        context.contentType = MimeType.JSON.name
        JsonBuilder builder = new JsonBuilder(id: country.id, name: country.countryName, abbv: country.abreviation, cont: country.continent)
        builder.writeTo(context.writer)
    }
}
