package com.nadeau.grouper.pages

import com.nadeau.grouper.App.ViewGroupAsCreator
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

object ViewGroupAsCreatorPage {

  val component = ReactComponentB[ViewGroupAsCreator]("ViewGroupAsCreator Page")
      .render_P(p => <.div("Creator Page " + p.id))
      .build
}
