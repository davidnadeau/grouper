package com.nadeau.grouper.pages

import com.nadeau.grouper.App._
import com.nadeau.grouper.components.SearchablePersonList
import com.nadeau.grouper.models.Person
import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

object GroupifyPage {
  case class Props(routeData: Groupify)

  class Backend($: BackendScope[Props, Unit]) {
    def render(props: Props) = <.div(
      "Groupify View" + props.routeData.id,
      SearchablePersonList(Person.spoofList)
    )
  }

  def apply(groupify: Groupify): ReactElement =
    component(Props(groupify))

  private val component = ReactComponentB[Props]("Groupify")
    .renderBackend[Backend]
    .build
}
