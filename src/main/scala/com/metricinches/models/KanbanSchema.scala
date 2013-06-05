package com.metricinches.models

import org.squeryl._
import org.squeryl.adapters.H2Adapter
import java.sql.DriverManager
import org.squeryl.PrimitiveTypeMode._

object KanbanSchema extends Schema{
  val stories = table[Story]{"Stories"}

  def init = {
    import org.squeryl.SessionFactory
    Class.forName("org.h2.Driver")

    if(SessionFactory.concreteFactory.isEmpty){
      SessionFactory.concreteFactory = Some(() =>
        Session.create(
          DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", ""), new H2Adapter))
    }
  }

  def main(args: Array[String]){
    println("initializing weKanban Schema")
    init
    inTransaction{ drop ; create }
  }

  def tx[A]( a: => A): A = {
    init
    inTransaction(a)
  }
}




