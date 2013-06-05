package com.metricinches.application
import scalaz._
import Scalaz._
import scalaz.http._
import response._
import request._
import servlet._
import HttpServlet._
import Slinky._
import com.metricinches.views.CreateStory
import scalaz.http.response.xhtml._

final class WeKanbanApplication extends StreamStreamServletApplication{
  import Request._
  import Response._

  implicit val charset = UTF8

  val application = new ServletApplication[Stream, Stream]{
    def application(implicit servlet: HttpServlet,
                      servletRequest: HttpServletRequest,
                      request: Request[Stream]) = {
      def found(x: Iterator[Byte]) : Response[Stream] = OK << x.toStream
      handle | HttpServlet.resource( found, NotFound.xhtml)
    }

  }

  def param(name:String)(implicit request:Request[Stream]) =
    (request ! name).getOrElse(List[Char]()).mkString("")

  def handle(implicit request: Request[Stream], servletRequest: HttpServletRequest): Option[Response[Stream]] = {
      request match {
        case MethodParts(GET, "card" :: "create" :: Nil ) =>
          Some(OK(ContentType, "text/html") << transitional << CreateStory(param("message")))
        case _ => None
      }
  }
}
