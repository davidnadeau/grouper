package com.nadeau.grouper.components

import japgolly.scalajs.react._, vdom.prefix_<^._

import scala.scalajs.js

object HomePage {

  case class State(groupName: String)

  def buttonGroup(state: State) = {
    <.div(
      <.button(
        "Create",
        ^.onClick := printGroup(state)
      ),
      <.button(
        "Join",
        ^.onClick := printGroup(state)
      )
    )
  }
  def printGroup(state: State): js.Function = { e: ReactEvent =>
    println(state.groupName)
  }

  class Backend($: BackendScope[Unit, State]) {

    def groupNameChange(e: ReactEventI) =
      $.modState(_.copy(groupName = e.target.value))

    def render(state: State) =
      <.div(
        <.div("Groupify"),
        <.input(
          ^.onChange ==> groupNameChange,
          ^.value := state.groupName
        ),
        buttonGroup(state)
      )
  }

  val component = ReactComponentB[Unit]("Home")
    .initialState(State(""))
    .renderBackend[Backend]
    .buildU
}
