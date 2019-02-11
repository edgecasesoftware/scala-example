package uk.co.edgecasesoftware.service

import akka.Done
import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Route
import akka.stream.ActorMaterializer
import com.typesafe.scalalogging.LazyLogging

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}

class UserHttpService(config:HttpConfig)(

  implicit val userService: UserService,
  implicit val actorSystem:ActorSystem,
  implicit val actorMaterializer:ActorMaterializer,
  implicit val ec:ExecutionContext

) extends LazyLogging with UserRoute {

  lazy val routes: Route = userRoutes

  def start(): Future[Done] = {
    val bindingFuture = Http().bindAndHandle(routes, config.host, config.port.toInt)

    bindingFuture.onComplete {
      case Success(serverBinding) =>
        logger.info(s"Server bound to ${serverBinding.localAddress} ")

      case Failure(ex) =>
        logger.error(s"Failed to bind to ${config.host}:${config.port}!", ex)
        actorSystem.terminate()
    }

    bindingFuture.map(_ => Done)
  }

}
