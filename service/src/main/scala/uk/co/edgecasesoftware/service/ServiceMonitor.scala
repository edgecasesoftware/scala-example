package uk.co.edgecasesoftware.service

import akka.Done
import akka.actor.ActorSystem
import akka.stream.{ActorMaterializer, ActorMaterializerSettings}

import scala.concurrent.{ExecutionContext, Future}

case class HttpConfig(host:String, port:String)
case class ServiceConfig(systemName:String, http:HttpConfig)

class ServiceMonitor(serviceConfig: ServiceConfig)(implicit ec:ExecutionContext) {

  implicit val system: ActorSystem = ActorSystem(serviceConfig.systemName)
  implicit val materialier: ActorMaterializer = ActorMaterializer(ActorMaterializerSettings(system))

  def start() : Future[Done] = {
    implicit val userService: UserService = new UserService()
    val userHttpService = new UserHttpService(serviceConfig.http)
    userHttpService.start()
  }

}
