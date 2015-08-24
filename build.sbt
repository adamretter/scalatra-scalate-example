enablePlugins(JavaAppPackaging)

name := "scalatra-scalate-example"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies ++= {
  val scalatraV = "2.4.0-RC2-2"
  val sprayV = "1.3.3"
  val akkaV = "2.3.12"

  Seq(
    "org.eclipse.jetty" % "jetty-webapp" % "9.3.2.v20150730",
    "org.scalatra" %% "scalatra" %  scalatraV,
    "org.scalatra" %% "scalatra-scalate" %  scalatraV,
    "org.scalatra" %% "scalatra-json" %  scalatraV,
    "org.json4s"   %% "json4s-jackson" % "3.3.0.RC1",
    "com.typesafe.akka" %% "akka-actor" % akkaV,
    "com.typesafe.akka" %% "akka-slf4j" % akkaV,
    "com.github.scala-incubator.io" %% "scala-io-file" % "0.4.3-1",
    "org.clapper" %% "grizzled-slf4j" % "1.0.2",
    "com.typesafe.slick" %% "slick" % "3.0.1",
    "io.spray" %% "spray-client" % sprayV,
    "io.spray" %% "spray-client" % sprayV,
    "com.jsuereth" %% "scala-arm" % "1.4",
    "me.lessis" %% "courier" % "0.1.3",
    "javax.mail" % "mail" % "1.4.7",

    "ch.qos.logback" % "logback-classic" % "1.0.13" % "runtime",
    "com.h2database" % "h2" % "1.4.187" % "runtime",
    "com.zaxxer" % "HikariCP" % "2.3.9" % "runtime"
  )
}
