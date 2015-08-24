package example.scalate.scalatra

import akka.actor.ActorSystem
import org.eclipse.jetty.server.Server
import org.eclipse.jetty.servlet.DefaultServlet
import org.eclipse.jetty.webapp.WebAppContext
import org.scalatra.servlet.ScalatraListener

object Boot {
  def main(args: Array[String]) {
    new ScalatraScalateExample().startup()
  }
}

class ScalatraScalateExample {
  private implicit val system = ActorSystem("scalatra-scalate-example")
  private val settings = Settings(system)

  private var server: Option[Server] = None

  /**
   * Startup the Watch Folder Service
   */
  def startup() {
    this.server = Some(launchJetty(settings.Port, system))
  }

  private def launchJetty(port: Int, actorSystem: ActorSystem) : Server = {
    val server = new Server(port)
    val context = new WebAppContext()

    context.setContextPath("/")
    context.setResourceBase("src/main/webapp")  //TODO(AR) what should this be in production vs dev?
    context.addEventListener(new ScalatraListener)
    context.addServlet(classOf[DefaultServlet], "/")

    context.setAttribute(ScalatraScalateExample.CONTEXT_ACTOR_SYSTEM_ATTR, actorSystem)

    server.setHandler(context)

    server.start
    server.join

    server
  }

  private def shutdownJetty(server: Server) {
    server.stop
  }

  /**
   * Shutdown the Watch Folder Service
   *
   * @param blocking When true, the method only returns once
   *                 shutdown is complete
   */
  def shutdown(blocking: Boolean = false) {
    server.map(shutdownJetty)

    system.shutdown()
    if(blocking) {
      system.awaitTermination()
    }
  }
}

object ScalatraScalateExample {
  val CONTEXT_ACTOR_SYSTEM_ATTR = "context.watch-folder-service.actor-system"
}