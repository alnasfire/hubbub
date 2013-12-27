import grails.util.Environment
import com.grailsinaction.Profile
import com.grailsinaction.User

class BootStrap {

    def init = { servletContext ->
        switch(Environment.current){
            case Environment.DEVELOPMENT:
                createAdminUserIfRequired()
                break;

            case Environment.PRODUCTION:
                println "No spesial configuration required"
                break;
    }
    }

    def destroy = {
    }

    void createAdminUserIfRequired(){
        if(!User.findByUserId("admin")){
            println "Fresh Database. Creating ADMIN user."
            def profile = new Profile(email: "admin@yourhost.com")
            def user = new User(userId: "admin", password: "secret", profile: profile).save()
        } else {
            println "Existing admin user, skipping creation."
        }
    }
}
