class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(view:"/index")
		"500"(view:'/error')
        "404"(controller: "errors", action: "notFound")

        "/documents/$docname**.pdf"(controller:"pdf", action:"render")


        "/users/$id"{
            controller = "post"
            action = "timeline"
        }

        "/users/$userId/feed/$format?"{
            controller = "post"
            action = "feed"
            constraints {
                format(inList: ['rss', 'atom'])
            }
        }

//        "/timeline/igor" {
//            controller = "post"
//            action = "timeline"
//            id = "igor"
//        }
        "/timeline/igor"(controller:"post",
        action:"timeline", id:"igor")

	}
}
