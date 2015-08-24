package example.scalate.scalatra

import org.json4s.{DefaultFormats, Formats}
import org.scalatra._
import org.scalatra.json._
import scalate.ScalateSupport
import spray.http.MediaTypes._

class ScalatraScalateExampleServlet extends ScalatraServlet
  with ScalateSupport
  with JacksonJsonSupport {

  protected implicit lazy val jsonFormats: Formats = DefaultFormats

  get("/") {
    contentType = `text/html`.value
    ssp("home", "title" -> "Scalatra Scalate Example")
  }
}