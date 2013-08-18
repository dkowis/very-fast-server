name := "speedserver"

version := "1.0"

scalaVersion := "2.10.2"

resolvers ++= Seq("spray repo" at "http://repo.spray.io",
    "typesafe repo" at "http://repo.typesafe.com/typesafe/releases")

libraryDependencies ++= Dependencies.speedserver

mainClass in Compile := Some("Main")


//Adding scalac options so I can see things, Targeting JDK 1.6
scalacOptions ++= Seq(
    "-unchecked",
    "-deprecation",
    "-Xlint",
    "-language:_",
    "-target:jvm-1.6",
    "-encoding", "UTF-8"
  )

net.virtualvoid.sbt.graph.Plugin.graphSettings
