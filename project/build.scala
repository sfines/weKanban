import sbt._
import Keys._

object H2TaskManager{
  var process: Option[Process] = None
  lazy val H2 = config("h2") extend (Compile)

  val startH2 = TaskKey[Unit]("start", "Starts the H2 Server")
  val startH2Task = startH2 in H2 <<= (fullClasspath in Compile) map {
    cp =>
      startDatabase{
        cp.map(_.data)
          .map(_.getAbsolutePath())
          .filter(_.contains("h2database"))
      }
  }

  def startDatabase(paths: Seq[String]) = {
    process match{
      case None =>
        val cp = paths.mkString(System.getProperty("path.separator"))
        val command = "java -cp "+cp+ " org.h2.tools.Server"
        println("Starting Database with command: "+command)
        process = Some(Process(command).run())
        println("Database Started")
      case Some(_) =>
        println("Database Already Started")
    }
  }

  val stopH2 = TaskKey[Unit]("stop", "Stops the H2 Server")
  val stopH2Task = stopH2 in H2 := {
    process match {
      case None => println("Database already stopped")
      case Some(_) =>
        println("Stopping Database")
        process.foreach(_.destroy())
        process = None
        println("Database Stopped")
    }
  }
}

object MainBuild extends Build{
  import H2TaskManager._
  lazy val wekanban = Project( "wekanban", file(".")).settings(startH2Task, stopH2Task)
}