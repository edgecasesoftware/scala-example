package uk.co.edgecasesoftware.service

import akka.http.scaladsl.server.Route
import akka.http.scaladsl.server.Directives._
import io.circe.{Decoder, Encoder}
import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}

import io.circe.syntax._

trait UserRoute {

  implicit val userService:UserService
  implicit val userDecoder: Decoder[User] = deriveDecoder
  implicit val userEncoder: Encoder[User] = deriveEncoder

    val userRoutes:Route = {
      path("users") {
        post {
          val userList = userService.getUsers.asJson
          complete(userList.toString())
        } ~ get {
          val userList = userService.getUsers.asJson
          complete(userList.toString())
        } ~ delete {
          val userList = userService.getUsers.asJson
          complete(userList.toString())
        }
      }
    }

}
