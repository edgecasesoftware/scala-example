import sbt._

object Dependencies {

  object Version {

    val logging = "3.9.2"
    val pureConfig = "0.8.0"
    val scalaTest = "3.0.5"
    val akka = "10.1.7"
    val slf4j = "1.7.5"

  }

  lazy val configHandler = Seq(
    "com.github.pureconfig"  %% "pureconfig" % Version.pureConfig
  )

  lazy val scalaTest = Seq(
    "org.scalatest" %% "scalatest" % Version.scalaTest % "test"
  )

  lazy val logging = Seq(
    "com.typesafe.scala-logging" %% "scala-logging" % Version.logging,
    "org.slf4j" % "slf4j-api" % Version.slf4j,
    "org.slf4j" % "slf4j-log4j12" % Version.slf4j
  )

  val akka = Seq(
    "com.typesafe.akka" %% "akka-http-testkit" % Version.akka,
    "com.typesafe.akka" %% "akka-http" % Version.akka
  )

}