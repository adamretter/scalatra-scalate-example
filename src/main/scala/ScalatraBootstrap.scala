import javax.servlet.ServletContext
import example.scalate.scalatra.ScalatraScalateExampleServlet
import org.scalatra.LifeCycle

class ScalatraBootstrap extends LifeCycle {
  override def init(context: ServletContext) {
    context mount (new ScalatraScalateExampleServlet, "/*")
  }
}
