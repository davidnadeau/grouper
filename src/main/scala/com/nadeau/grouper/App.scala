package com.nadeau.grouper

import com.nadeau.grouper.App.Pages
import com.nadeau.grouper.pages._
import japgolly.scalajs.react.ReactDOM
import japgolly.scalajs.react.extra.router._
import org.scalajs.dom

import scala.scalajs.js.JSApp
import scala.scalajs.js.annotation.JSExport

object App extends JSApp {

  sealed trait Pages
  case object Home extends Pages
  case class ViewGroupAsCreator(id: String) extends Pages
  case class ViewGroupAsGuest(id: String) extends Pages
  case class Groupify(id: String) extends Pages

  val routerConfig = RouterConfigDsl[Pages].buildConfig { dsl =>
    import dsl._

    def homeRoute = staticRoute(root, Home) ~> renderR(HomePage(_))
    def viewGroupAsCreatorRoute =
      dynamicRouteCT("#group/creator" / string("[a-zA-Z0-9]+").caseClass[ViewGroupAsCreator]) ~> dynRenderR((page, ctl) => ViewGroupAsCreatorPage(page, ctl))
    def viewGroupAsGuestRoute =
      dynamicRouteCT("#group/guest" / string("[a-zA-Z0-9]+").caseClass[ViewGroupAsGuest]) ~> dynRenderR((page, ctl) => ViewGroupAsGuestPage(page, ctl))
    def groupifyRoute =
      dynamicRouteCT("#groupify" / string("[a-zA-Z0-9]+").caseClass[Groupify]) ~> dynRender(GroupifyPage(_))

    ( homeRoute
    | viewGroupAsCreatorRoute
    | viewGroupAsGuestRoute
    | groupifyRoute
    ).notFound(redirectToPage(Home)(Redirect.Replace))
  }

  val baseUrl = BaseUrl(dom.window.location.href.takeWhile(_ != '#'))

  @JSExport
  override def main(): Unit = {
    val router = Router(baseUrl, routerConfig.logToConsole)()
    val mounted = ReactDOM.render(router, dom.document.getElementsByClassName("grouper")(0))
  }
}
