package com.example.routes

import com.example.models.User
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.userRouting(){
    route("api/users"){
        get{
            call.respond("Wow")
        }
        post{

            val params = call.receiveParameters()
            val login : String? = params["login"]
            val password : String? = params["password"]

            var requestforclient : String = "Авторизация отклонена!"
            var iterator = 0
            for (i in users) {
                if (password == users[iterator].password && login == users[iterator].login){
                    requestforclient = "Авторизация пройдена!"
                }
                iterator++
            }
            call.respondText("login:$login \npassword:$password \n$requestforclient")
        }

    }
}

fun Application.registerUsersRouts(){
    routing {
        userRouting()
    }
}

var users = mutableListOf<User>(
    User("Andru","AndruPassword"),
    User("Sergei","SergeiPassword"),
    User("Ilya","IlyaPassword"),
)


