package com.nadeau.grouper.pages

import com.nadeau.grouper.App._
import com.nadeau.grouper.components.SearchablePersonList
import com.nadeau.grouper.models.Person
import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.router.RouterCtl
import japgolly.scalajs.react.vdom.prefix_<^._

object ViewGroupAsGuestPage {

  case class Props(ctl: RouterCtl[Pages], routeData: ViewGroupAsGuest)

  class Backend($: BackendScope[Props, Unit]) {
    def render(props: Props) = <.div(
      "Guest View " + props.routeData.id,
      SearchablePersonList(Person.spoofList)
    )
  }

  def apply(viewGroupAsGuest: ViewGroupAsGuest, ctl: RouterCtl[Pages]): ReactElement =
    component(Props(ctl, viewGroupAsGuest))

  private val component = ReactComponentB[Props]("ViewGroupAsGuest")
    .renderBackend[Backend]
    .build
}
