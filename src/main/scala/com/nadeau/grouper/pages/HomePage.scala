package com.nadeau.grouper.pages

import com.nadeau.grouper.App.{ViewGroupAsGuest, ViewGroupAsCreator, Pages}
import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.router.RouterCtl
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js

object HomePage {

  case class State(id: String, ctl: RouterCtl[Pages])

  def buttonGroup(state: State) = {
    <.div(
      <.button(
        "Create",
        ^.onClick ==> state.ctl.setEH(ViewGroupAsCreator(state.id))
      ),
      <.button(
        "Join",
        ^.onClick ==> state.ctl.setEH(ViewGroupAsGuest(state.id))
      )
    )
  }

  class Backend($: BackendScope[RouterCtl[Pages], State]) {

    def groupNameChange(e: ReactEventI) = {
      $.modState(_.copy(id = e.target.value))
    }

    def render(state: State) =
      <.div(
        <.div("Groupify"),
        <.input(
          ^.onChange ==> groupNameChange,
          ^.value := state.id
        ),
        buttonGroup(state)
      )
  }

  val component = ReactComponentB[RouterCtl[Pages]]("Home")
    .initialState_P(ctl => State("", ctl))
    .renderBackend[Backend]
    .build
}
