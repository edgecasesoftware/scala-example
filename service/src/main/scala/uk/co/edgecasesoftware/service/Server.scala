package uk.co.edgecasesoftware.service

import com.typesafe.scalalogging.LazyLogging
import pureconfig.loadConfig

object Server extends App with LazyLogging {

  override def main(args: Array[String]): Unit = {
    logger.info("Starting server")

    loadConfig[ServiceConfig](namespace = "uk.co.edgecasesoftware.service") match {
      case Right(config) => logger.info("Server Started")
      case Left(failures) => logger.error(s"Failed starting service: ${failures.toList.map(_.toString).mkString("\n")}")
    }
  }

}
