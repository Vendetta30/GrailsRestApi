class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?" {
            constraints {
                // apply constraints here
            }
        }

        "/"(view: "/index")
        "500"(view: '/error')
        "404"(view: '/notFound')

        "/persons"(resources: "person")

        //Add this for Controller Rest
//        "/countries"(resources: "country")
        "/countries"(controller: "country", action: "index", method: "GET")
//        "/countries/create"(controller: "country", action: "create", method: "GET")
        "/countries"(controller: "country", action: "save", method: "POST")
        "/countries/$id"(controller: "country", action: "show", method: "GET")
        "/countries/$id"(controller: "country", action: "update", method: "PUT")
//        "/countries/$id/edit"(controller: "country", action: "edit", method: "PUT")
        "/countries/$id"(controller: "country", action: "patch", method: "PATCH")
        "/countries/$id"(controller: "country", action: "delete", method: "DELETE")
    }
}
