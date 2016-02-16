package com.nadeau.grouper.models

import com.nadeau.grouper.util.Cookies

case class Person(name: String)
object Person {
  val userToken = Cookies.findOrCreate("user_token")
}
