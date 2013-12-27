package com.grailsinaction

class Tag {

    String name
    String user

    static constraints = {
        name(blank: false)
    }

    static hasMany = [ posts : Post]

    static belongsTo = [ User, Post]
}
