import akka.actor.Actor
import spray.can.Http
import scala.concurrent.duration._
import spray.http.{MediaTypes, HttpMethods, HttpRequest, Uri}
import spray.httpx.marshalling.Marshaller
import spray.util.SprayActorLogging
import HttpMethods._
import MediaTypes._

class MBService extends Actor with SprayActorLogging {

  import context.dispatcher // ExecutionContext for scheduler
  import spray.http._
  import spray.httpx.marshalling._

  def receive = {
    case _: Http.Connected => sender ! Http.Register(self)

    case HttpRequest(GET, Uri.Path("/"), _, _, _) => {
      sender ! oneMb
    }

    case HttpRequest(GET, Uri.Path("/stop"), _, _,_) => {
      sender ! HttpResponse(entity = "Bailing in a sec!")
      context.system.scheduler.scheduleOnce(1.second) { context.system.shutdown()}
    }
  }

  lazy val oneMb = HttpResponse(
    entity = HttpEntity(`application/octet-stream`,
      Array.fill(1024 * 1024)(100.toByte)
    )
  )

}
