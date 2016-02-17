package com.nadeau.grouper.components

import com.nadeau.grouper.models.Person
import japgolly.scalajs.react._, vdom.prefix_<^._

object SearchablePersonList {

  case class Props(list: List[Person])
  case class State(name: String)

  class Backend($: BackendScope[Props, State]) {
    def nameSearchChange(e: ReactEventI) = {
      $.modState(_.copy(name = e.target.value))
    }

    def render(props: Props, state: State) = <.div(
      <.input(
        ^.placeholder := "Person name",
        ^.value := state.name,
        ^.onChange ==> nameSearchChange
      ),
      <.ul(
        for {
          item <- props.list.filter(_.name.toLowerCase.contains(state.name.toLowerCase))
        } yield <.li(item.name)
      )
    )
  }

  def apply(list: List[Person]): ReactElement =
    component(Props(list))

  private val component = ReactComponentB[Props]("Person List")
      .initialState(State(""))
    .renderBackend[Backend]
    .build

}
