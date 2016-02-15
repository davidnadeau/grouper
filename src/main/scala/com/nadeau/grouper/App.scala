package com.nadeau.grouper


import com.nadeau.grouper.components.{SearchablePersonList, HomePage}
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

  @JSExport
  override def main(): Unit = {
    val baseUrl = BaseUrl.fromWindowOrigin + "/"
    val router = Router(baseUrl, routerConfig)
    router() render dom.document.body
  }
}
