import sbt._

object Dependencies {

  object Version {

    val logging = "3.9.2"
    val pureConfig = "0.8.0"
    val scalaTest = "3.0.5"
    val akkaHttp = "10.1.7"
    val akka = "2.5.20"
    val slf4j = "1.7.5"
    val logbackClassic = "1.2.3"
    val circe = "0.9.3"

  }

  lazy val configHandler = Seq(
    "com.github.pureconfig"  %% "pureconfig" % Version.pureConfig
  )

  lazy val scalaTest = Seq(
    "org.scalatest" %% "scalatest" % Version.scalaTest % "test"
  )

  lazy val logging = Seq(
    "com.typesafe.scala-logging" %% "scala-logging" % Version.logging,
    "ch.qos.logback" % "logback-classic" % Version.logbackClassic
  )

  val akka = Seq(
    "com.typesafe.akka" %% "akka-http-testkit" % Version.akkaHttp,
    "com.typesafe.akka" %% "akka-http" % Version.akkaHttp,
    "com.typesafe.akka" %% "akka-stream" % Version.akka
  )

  val circe = Seq(
    "io.circe"  %% "circe-core"     % Version.circe,
    "io.circe"  %% "circe-generic"  % Version.circe,
    "io.circe"  %% "circe-parser"   % Version.circe,
  )
}
