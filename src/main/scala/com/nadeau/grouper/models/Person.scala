package com.nadeau.grouper.models

import scala.util.Random

case class Person(name: String)

object Person {
  def spoofPerson = Person("Person - " + Random.alphanumeric.take(12).mkString)
  def spoofPeople(n: Int) = List.fill(n)(spoofPerson)
}
