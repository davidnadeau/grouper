package com.nadeau.grouper.models

case class Group(id: String)
object Group {
  def create(group: Group) = { println("User " + Person.userToken + " has created group " + group.id) }
  def join(group: Group) = { println("User " + Person.userToken + " has joined group " + group.id) }
}
