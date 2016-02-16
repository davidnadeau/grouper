package com.nadeau.grouper.pages

import com.nadeau.grouper.App._
import com.nadeau.grouper.models._
import japgolly.scalajs.react._, vdom.prefix_<^._
import japgolly.scalajs.react.extra.router.RouterCtl

object HomePage {

  case class State(id: String, ctl: RouterCtl[Pages])

  def buttonGroup(state: State) = {
    def handleClick(action: Group => Unit, redirectPage: Pages): Callback = {
      action(Group(state.id))
      state.ctl.set(redirectPage)
    }

    <.div(
      <.button(
        "Create",
        ^.onClick --> handleClick(Group.create, ViewGroupAsCreator(state.id))
      ),
      <.button(
        "Join",
        ^.onClick --> handleClick(Group.join, ViewGroupAsGuest(state.id))
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
          ^.placeholder := "Group Id",
          ^.value := state.id,
          ^.onChange ==> groupNameChange
        ),
        buttonGroup(state)
      )
  }

  def apply(ctl: RouterCtl[Pages]): ReactElement =
    component(ctl)

  private val component = ReactComponentB[RouterCtl[Pages]]("Home")
    .initialState_P(ctl => State("", ctl))
    .renderBackend[Backend]
    .build
}
