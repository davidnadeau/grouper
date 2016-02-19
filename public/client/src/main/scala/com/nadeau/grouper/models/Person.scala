package com.nadeau.grouper.models

import com.nadeau.grouper.util.Cookies

import scala.scalajs.js._

case class Person(id: String, name: String)

object Person {
  val currentUser = Person(Cookies.findOrCreate("user_token"), "")

  def spoofList = List(
    Person("1", "Vitalik Buterin"),
    Person("2", "David Nadeau"),
    Person("3", "Elon Musk")
  )
}
