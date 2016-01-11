package com

import grails.rest.Resource

@Resource(formats = ['json', 'xml'])
class Person {
    String firstName
    String lastName
    Long age

    static constraints = {
    }
}
