package com.nadeau.grouper.pages

import com.nadeau.grouper.App._
import japgolly.scalajs.react._
import japgolly.scalajs.react.extra.router.RouterCtl
import japgolly.scalajs.react.vdom.prefix_<^._

object ViewGroupAsCreatorPage {
  case class Props(ctl: RouterCtl[Pages], viewGroupAsCreator: ViewGroupAsCreator)

  class Backend($: BackendScope[Props, Unit]) {
    def render(props: Props) = <.div("Creator View " + props.viewGroupAsCreator.id)
  }

  def apply(viewGroupAsCreator: ViewGroupAsCreator, ctl: RouterCtl[Pages]): ReactElement =
    component(Props(ctl, viewGroupAsCreator))

  val component = ReactComponentB[Props]("ViewGroupAsCreator")
    .renderBackend[Backend]
    .build
}
