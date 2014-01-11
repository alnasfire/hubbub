package com.grailsinaction

class PhotoUploadCommand {
    byte[] photo
    String userId

    static constraints = {
        photo(maxSize: 32768)
    }
}

class ImageController {
    def upload = { PhotoUploadCommand puc ->
        def user = User.findByUserId(puc.userId)
        user.profile.photo = puc.photo
        redirect(action: 'view', id:  puc.userId)
    }

    def renderImage = {
        def user = User.findByUserId(params.id)
        if (user?.profile?.photo){
            response.setContentLength(user.profile.photo.length)
            response.outputStream.write(user.profile.photo)
        }else{
            response.sendError(404)
        }
    }

    def form = {
        [userList : User.list()]
    }

    def view = {
        redirect(uri: '/user/profile/'+params.id)
    }
}
