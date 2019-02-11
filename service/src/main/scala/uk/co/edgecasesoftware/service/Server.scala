package uk.co.edgecasesoftware.service

import com.typesafe.scalalogging.LazyLogging
import pureconfig.loadConfig

import scala.concurrent.ExecutionContext.Implicits.global

object Server extends App with LazyLogging {

  override def main(args: Array[String]): Unit = {

    loadConfig[ServiceConfig](namespace = "uk.co.edgecasesoftware.service") match {
      case Right(configuration) => {
        logger.info("Starting server")
        val serviceMonitor = new ServiceMonitor(configuration)
        serviceMonitor.start()
        logger.info("Server Started")
      }
      case Left(failures) => logger.error(s"Failed starting service: ${failures.toList.map(_.toString).mkString("\n")}")
    }
  }

}
