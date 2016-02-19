package models

import scala.collection.mutable

case class Group(id: String, var people: List[Person], var subGroups: List[List[Person]] = List())

object Group {

  def whoInit(id: String): List[String] = {
    groups.get(id) match {
      case Some(x) => x.people.map(_.name).sorted
      case None => List()
    }
  }

  val groups = mutable.Map[String, Group]()

  def join(id: String, person: Person): String = {
    groups.get(id) match {
      case Some(x) => {
        if (x.people.contains(person))
          "User " + person.name + " already in group " + id
        else {
          x.people = person :: x.people
          "User " + person.name + " now in group " + id
        }
      }
      case None => s"Group $id not found"
    }

  }

  def create(id: String, person: Person): String = {
    groups.get(id) match {
      case Some(x) => s"Group $id already exists"
      case None => {
        groups.put(id, Group(id, List(person)))
        s"Group $id has been created"
      }
    }
  }

  def groupify(id: String, groupSize: Int): String = {
    groups.get(id) match {
      case Some(x) => {
        x.subGroups = x.people.grouped(groupSize).toList
        println(x.subGroups)
        s"Group $id has been groupifyed"
      }
      case None => s"Group $id doesn't exists"
    }
  }

  def getMySubGroup(id: String, personId: String): List[Person] = {
    groups.get(id) match {
      case Some(x) => {
        x.people.find(_.id == personId) match {
          case Some(y) => x.subGroups.filter(_.contains(y)).flatten
          case None => List()
        }
      }
      case None => List()
    }
  }
}
