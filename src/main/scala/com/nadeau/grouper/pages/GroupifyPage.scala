package com.nadeau.grouper.pages

import com.nadeau.grouper.App.Groupify
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

object GroupifyPage {

  val component = ReactComponentB[Groupify]("Groupify Page")
    .render_P(p => <.div("Groupify Page " + p.id))
    .build
}
