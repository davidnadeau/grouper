package models

import play.api.libs.functional.syntax._
import play.api.libs.json._

case class Person(id: String, name: String)
object Person {
  implicit val personWrites: Writes[Person] =
    ((__  \ "id").write[String] and (__ \ "name").write[String])(unlift(Person.unapply))

  implicit val personReads: Reads[Person] =
    ((__ \ "id").read[String] and (__ \ "name").read[String])(Person.apply _)
}
