package com.metricinches.models
import KanbanSchema._
import org.squeryl._
import org.squeryl.PrimitiveTypeMode._
import org.squeryl.annotations._

/**
 * Created with IntelliJ IDEA.
 * User: datak_000
 * Date: 6/2/13
 * Time: 10:30 PM
 * To change this template use File | Settings | File Templates.
 */
class Story(val number: String, val title: String, val phase: String){
  private[this] def validate = {
    if( number.isEmpty || title.isEmpty){
      throw new ValidationException("Both number and title are required.")
    }

    if(!stories.where(a => a.number === number).isEmpty){
      throw new ValidationException("The story number is not unique.")
    }
  }

  def save(): Either[Throwable, String] = {
    tx {
      try {
        validate
        stories.insert(this)
        Right("Story was successfully created.")
      } catch {
        case exception: Throwable => Left(exception)
      }
    }
  }
}

object Story{
  def apply(number:String, title: String) =
    new Story(number, title, "ready")
}

class ValidationException( message: String) extends RuntimeException(message)


