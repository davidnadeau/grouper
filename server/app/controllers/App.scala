package controllers

import models.{Group, Person}
import play.api.data.validation.ValidationError
import play.api.libs.json.{JsPath, JsError, Json}
import play.api.mvc._

object App extends Controller {

  def create(id: String) = Action(BodyParsers.parse.json) { request =>
    val result = request.body.validate[Person]
    result.fold(
      errors => handleErrors(errors),
      person => {
        val res = Group.create(id, person)
        Ok(Json.obj("status" -> "OK", "message" -> res))
      }
    )
  }

  def join(id: String) = Action(BodyParsers.parse.json) { request =>
    val result = request.body.validate[Person]
    result.fold(
      errors => handleErrors(errors),
      person => {
        val res = Group.join(id, person)
        Ok(Json.obj("status" -> "OK", "message" -> res))
      }
    )
  }


  def whoInit(id: String) = Action {
    val res = Group.whoInit(id)
    Ok(Json.obj("status" -> "OK", "message" -> Json.toJson(res)))
  }

  def groupify(id: String) = Action(BodyParsers.parse.json) { request =>
    val result = request.body.validate[Int]
    result.fold(
      errors => handleErrors(errors),
      groupSize => {
        val res = Group.groupify(id, groupSize)
        Ok(Json.obj("status" -> "OK", "message" -> res))
      }
    )
  }


  def getMyGroup(id: String) = Action(BodyParsers.parse.json) { request =>
    val result = request.body.validate[String]
    result.fold(
      errors => handleErrors(errors),
      personId => {
        val res = Group.getMySubGroup(id, personId)
        Ok(Json.obj("status" -> "OK", "message" -> Json.toJson(res)))
      }
    )
  }

  private def handleErrors(errors: Seq[(JsPath, Seq[ValidationError])]) =
    BadRequest(Json.obj("status" -> "fail", "message" -> JsError.toJson(errors)))
}