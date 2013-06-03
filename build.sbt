name := "weKanban"

version := "1.0"

scalaVersion := "2.10.0"

scalacOptions ++= Seq("-unchecked", "-deprecation")

seq( webSettings :_*)

libraryDependencies += "org.scalaz" %% "scalaz-core" % "6.0.3"

libraryDependencies += "org.scalaz" %% "scalaz-http" % "6.0.3"

libraryDependencies += "org.eclipse.jetty" % "jetty-server" %  "8.0.1.v20110908" % "container"

libraryDependencies += "org.eclipse.jetty" % "jetty-servlet" % "8.0.1.v20110908" % "container"

libraryDependencies +=   "org.eclipse.jetty" % "jetty-webapp" % "8.0.1.v20110908" % "test"

libraryDependencies +=   "org.eclipse.jetty" % "jetty-webapp" % "8.0.1.v20110908" % "container"

libraryDependencies +=   "org.scala-tools.testing" % "specs" % "1.6.2" % "test"

libraryDependencies += "com.h2database" % "h2" % "1.2.137"

libraryDependencies += "org.squeryl" % "squeryl_2.10" % "0.9.5-6"

