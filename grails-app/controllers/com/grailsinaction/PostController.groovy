package com.grailsinaction

class PostController {
//    def defaultAction = 'timeline'
    def postService
    def scaffold = true

    def timeline = {
        def user = User.findByUserId(params.id)
        [ user : user ]
    }

    def addPost = {
        try{
            def newPost = postService.createPost(params.id, params.content)
            flash.message = "Added new post: ${newPost.content}"
        } catch (PostException ex){
            flash.message = ex.message
        }
        redirect(action: 'timeline', id: params.id)
    }

    def index = {
        if (!params.id)
            params.id = "igor"
            redirect(action: 'timeline', params: params)
    }
}
