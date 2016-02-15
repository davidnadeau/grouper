package com.nadeau.grouper.components

import japgolly.scalajs.react._, vdom.prefix_<^._

import scala.scalajs.js

object HomePage {

  val component = ReactComponentB[Unit]("Home")
    .render(_ =>
      <.div(
        grouperTitle,
        joinCreateGroupControls
      )
    ).buildU

  def grouperTitle = {
    <.div(
      ^.`class` := "appTitle",
      "Groupify"
    )
  }

  def joinCreateGroupControls = {
    <.div(
      <.div(
        <.input(
          ^.`type` := "text",
          ^.`class` := "groupName",
          ^.placeholder := "Group name"
        )
      ),
      <.div(
        <.button(
          "Create",
          ^.onClick := createGroup
        ),
        <.button(
          "Join",
          ^.onClick := joinGroup
        )
      )
    )
  }

  def createGroup: js.Function = { e: ReactEvent =>
    println("GROUP CREATED")
  }

  def joinGroup: js.Function = { e: ReactEvent =>
    println("GROUP JOINED")
  }
}
