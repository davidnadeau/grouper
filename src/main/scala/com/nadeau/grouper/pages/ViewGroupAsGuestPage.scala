package com.nadeau.grouper.pages

import com.nadeau.grouper.App.ViewGroupAsGuest
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

object ViewGroupAsGuestPage {

  val component = ReactComponentB[ViewGroupAsGuest]("ViewGroupAsCreator Page")
    .render_P(p => <.div("Guest Page " + p.id))
    .build
}
