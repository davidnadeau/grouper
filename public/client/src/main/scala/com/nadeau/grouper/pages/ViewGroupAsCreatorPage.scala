package com.nadeau.grouper.pages

import com.nadeau.grouper.App._
import com.nadeau.grouper.components.{TaskList, SearchablePersonList}
import com.nadeau.grouper.models.Person
import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.router.RouterCtl
import japgolly.scalajs.react.vdom.prefix_<^._

object ViewGroupAsCreatorPage {

  case class Props(ctl: RouterCtl[Pages], routeData: ViewGroupAsCreator)
  case class State(groupSize: Int)

  class Backend($: BackendScope[Props, State]) {

    def groupSizeChange(e: ReactEventI) = $.modState(_.copy(groupSize = e.target.value.toInt))

    def render(props: Props, state: State) = <.div(
      "Creator View " + props.routeData.id,
      <.div(
        <.input(
          ^.`type` := "number",
          ^.placeholder := "Group Id",
          ^.value := state.groupSize,
          ^.onChange ==> groupSizeChange
        ),
        groupifyButton(props, state)
      ),
      TaskList()
    )
  }

  def groupifyButton(props: Props, state: State) = {
    def handleGroupifyClick(state: State, props: Props, redirectPage: Pages): Callback = {
      // groupify(state.groupSize)
      props.ctl.set(redirectPage)
    }

    <.button(
      "Groupify",
      ^.onClick --> handleGroupifyClick(state, props, Groupify(props.routeData.id))
    )
  }

  def apply(viewGroupAsCreator: ViewGroupAsCreator, ctl: RouterCtl[Pages]): ReactElement =
    component(Props(ctl, viewGroupAsCreator))

  val component = ReactComponentB[Props]("ViewGroupAsCreator")
    .initialState(State(2))
    .renderBackend[Backend]
    .build
}
