package example.scalate

import java.io.{PrintWriter, StringWriter}

import resource._

package object scalatra {
  type Id = Int
  type LoaderId = String

  trait Extractor[S, T] {
    def unapply(s: S): Option[T]
  }

  def throwableToString(t: Throwable): Option[String] = {
    managed(new StringWriter).map { sw =>
      managed(new PrintWriter(sw)).map { pw =>
        t.printStackTrace(pw)
        sw.toString
      }.opt
    }.opt.flatten
  }
}
