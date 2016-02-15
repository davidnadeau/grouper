package com.nadeau.grouper


import com.nadeau.grouper.components.{SearchablePersonList, HomePage}
import japgolly.scalajs.react.ReactDOM
import japgolly.scalajs.react.extra.router.{Redirect, RouterConfigDsl, BaseUrl, Router}
import org.scalajs.dom

import scala.scalajs.js.JSApp
import scala.scalajs.js.annotation.JSExport

object App extends JSApp {

  sealed trait Pages
  case object Home extends Pages
  case object Group extends Pages

  val routerConfig = RouterConfigDsl[Pages].buildConfig { dsl =>
    import dsl._

    (emptyRule
      | staticRoute(root, Home) ~> render(HomePage.component())
      | staticRoute(root, Group) ~> render(SearchablePersonList.component())
      )
      .notFound(redirectToPage(Home)(Redirect.Replace))
  }

  val baseUrl = BaseUrl(dom.window.location.href.takeWhile(_ != '#'))

  @JSExport
  override def main(): Unit = {
    val router = Router(baseUrl, routerConfig.logToConsole)()
    val mounted = ReactDOM.render(router, dom.document.getElementsByClassName("grouper")(0))
  }
}
