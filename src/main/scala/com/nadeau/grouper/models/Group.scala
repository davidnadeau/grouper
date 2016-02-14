package com.nadeau.grouper.models

import scala.util.Random

case class Group(name: String)
object Group {
  var people = List[Person]()

  def join(person: Person) = people = person :: people
  def leave(person: Person) = people = people.filter(_ != person)
  def getNames() = people.map(_.name).sorted
  def groupify(n: Int) = util.Random.shuffle(people).grouped(n).toList

  def spoofGroup = Group("Group - " + Random.alphanumeric.take(12).mkString)
  def spoofGroups(n: Int) = List.fill(n)(spoofGroup)
}



