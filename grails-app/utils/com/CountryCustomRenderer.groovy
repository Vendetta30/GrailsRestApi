package com

import grails.rest.render.AbstractRenderer
import grails.rest.render.RenderContext
import grails.web.mime.MimeType
import groovy.json.JsonBuilder
import restapi.Country

class CountryCustomRenderer extends AbstractRenderer<Country> {
    CountryCustomRenderer() {
        super(Country, [MimeType.JSON, MimeType.TEXT_JSON] as MimeType[])
    }

    @Override
    public void render(Country country, RenderContext context) {
        context.contentType = MimeType.JSON.name
        def json = new JsonBuilder(context.writer)

        json.country(cName: country.countryName, abv: country.abreviation, cont: country.continent)
    }
}

