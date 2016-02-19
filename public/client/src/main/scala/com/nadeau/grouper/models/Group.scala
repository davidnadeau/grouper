package com.nadeau.grouper.models

import org.scalajs.dom
import dom.ext.Ajax
import scala.concurrent.ExecutionContext
import ExecutionContext.Implicits.global

case class Group(id: String)

object Group {
  def create(group: Group) = {
    Ajax.post(
      url = "/group/" + group.id,
      data = upickle.write(Person.currentUser),
      headers = Map("Content-Type" -> "application/json")
    ).foreach(x => println(x.responseText))
  }

  def join(group: Group) = {
    Ajax.put(
      url = "/group/" + group.id,
      data = upickle.write(Person.currentUser),
      headers = Map("Content-Type" -> "application/json")
    ).foreach(x => println(x.responseText))
  }

}
