package hubbub

class LameSecurityFilters {

    def filters = {

        secureActions(controller: 'post',
            action: '(addPost | deletePost)'){
            before = {
                if (params.logonId){
                    session.user = User.findByUserId(params.logonId)
                }

                if (!session.user){
                    redirect(controller: 'login', action: 'form')
                    return false
                }
            }

            after = { model ->
            }

            afterView = {
                log.debug "Finished running ${controllerName} - ${actionName}"
            }
        }

//        all(controller:'*', action:'*') {
//            before = {
//
//            }
//            after = { Map model ->
//
//            }
//            afterView = { Exception e ->
//
//            }
//        }
    }
}
