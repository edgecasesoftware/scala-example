import Dependencies._

lazy val root = (project in file("."))
  .settings (
    name := "service",
    version := "0.1",
    scalaVersion := "2.12.8"
  )
  .settings (
    libraryDependencies ++= scalaTest ++ logging ++ configHandler ++ akka
  )