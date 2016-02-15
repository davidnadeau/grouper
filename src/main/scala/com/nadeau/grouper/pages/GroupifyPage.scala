package com.nadeau.grouper.pages

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

object GroupifyPage {

  case class State()

  class Backend($: BackendScope[Unit, State]) {
    def render(state: State) = <.div()
  }

  val component = ReactComponentB[Unit]("Groupify")
    .initialState(State())
    .renderBackend[Backend]
    .buildU
}
