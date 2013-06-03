package com.metricinches.models

import org.squeryl._
/**
 * Created with IntelliJ IDEA.
 * User: datak_000
 * Date: 6/2/13
 * Time: 10:27 PM
 * To change this template use File | Settings | File Templates.
 */
object KanbanSchema extends Schema{
  val stories = table[Story]{"Stories"}
}


