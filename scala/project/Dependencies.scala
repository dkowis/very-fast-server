import sbt._
import Keys._

object Library {
  //versions
  val sprayVersion = "1.1-RC4"
  val akkaVersion = "2.1.4"
  val logbackVersion = "1.0.13"

  //app depends
  val akkaActor = "com.typesafe.akka" %% "akka-actor" % akkaVersion
  val akkaSlf4j = "com.typesafe.akka" %% "akka-slf4j" % akkaVersion
  val sprayCan = "io.spray" % "spray-can" % sprayVersion
  val sprayHttpx = "io.spray" % "spray-httpx" % sprayVersion
  val logbackClassic = "ch.qos.logback" % "logback-classic" % logbackVersion
}

object Dependencies {

  import Library._

  val speedserver = List(
    akkaActor,
    akkaSlf4j,
    sprayCan,
    sprayHttpx,
    logbackClassic
  )
}
