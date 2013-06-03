package com.metricinches.application

import scalaz._
import Scalaz._
import scalaz.http.Slinky._
import scalaz.http.servlet._
import scalaz.http.request.Request
import scalaz.http.response.{Response, OK, NotFound}


final class WeKanbanApplication extends StreamStreamServletApplication{
  val application = new ServletApplication[Stream, Stream]{
    def application(implicit servlet: HttpServlet,
                      servletRequest: HttpServletRequest,
                      request: Request[Stream]) = {
      def found(x: Iterator[Byte]) : Response[Stream] = OK << x.toStream
      HttpServlet.resource( found, NotFound.xhtml)
    }
  }
}
