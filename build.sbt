name := "akka-json-override"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies ++= {
  Seq(
    "org.scalatest" %% "scalatest" % "2.2.1" % "test",
    "com.typesafe.akka" %% "akka-http-spray-json-experimental" % "2.0-M1"
  )
}