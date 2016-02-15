package com.nadeau.grouper.pages

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import scala.scalajs.js

object HomePage {

  case class State(id: String)

  def buttonGroup(state: State) = {
    <.div(
      <.button(
        "Create",
        ^.onClick := createGroup(state)
      ),
      <.button(
        "Join",
        ^.onClick := joinGroup(state)
      )
    )
  }
  def createGroup(state: State): js.Function = { e: ReactEvent =>
  }
  def joinGroup(state: State): js.Function = { e: ReactEvent =>
    println(state.id)
  }

  class Backend($: BackendScope[Unit, State]) {

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

  val component = ReactComponentB[Unit]("Home")
    .initialState(State(""))
    .renderBackend[Backend]
    .buildU
}
