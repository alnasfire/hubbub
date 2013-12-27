package com.grailsinaction

class User {
    String userId
    String password
    String homepage
    Date dateCreated
    Profile profile

    static constraints = {
        dateCreated()
        userId(size: 3..20, unique: true)
        password(size: 6..8,
                validator: {passwd, user ->
                    return passwd != user.userId
                })
        homepage(url: true, nullable: true)
        profile(nullable: true)
    }

    static mapping = {
        profile lazy: false
        posts sort: 'dateCreated'
    }

    static hasMany = [ posts : Post, tags : Tag, following : User ]
}