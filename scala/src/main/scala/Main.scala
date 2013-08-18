import akka.actor.{ActorSystem, Props}
import akka.io.IO
import spray.can.Http

object Main extends App {
  implicit val system = ActorSystem()

  //the handler actor replies to incoming HttpRquests
  val handler = system.actorOf(Props[MBService], name = "mbService")

  IO(Http) ! Http.Bind(handler, interface = "localhost", port = 8000)
}