package com.nadeau.grouper.components

import japgolly.scalajs.react._, vdom.prefix_<^._


object SearchablePersonList {

  val component = ReactComponentB[Unit]("Person List")
    .render(_ =>
      <.div(
        searchBox,
        list
      )
    ).buildU

  def searchBox = {
    <.div(
      <.input(
        ^.`type` := "text",
        ^.`class` := "searchPeople",
        ^.placeholder := "Person name"
      )
    )
  }

  def list = {
    <.ul(
      ^.`class` := "person-list",
      for { person <- List(1, 2, 3, 4, 5, 6) } yield <.li(person)
    )
  }

}
