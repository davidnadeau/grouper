package com.nadeau.grouper.components

import com.nadeau.grouper.GroupMgmt
import org.scalajs.dom

import scala.scalajs.js.annotation.JSExport
import scalatags.JsDom.all._
import org.scalajs.jquery.jQuery

object HomePage {

  val APP_TITLE = "Grouper"

  def render = {
    div(
      grouperTitle,
      joinCreateGroupControls
    ).render
  }

  def grouperTitle = {
    div(
      `class` := "appTitle",
      APP_TITLE
    )
  }


  def joinCreateGroupControls = {
    div(
      div(
        input(
          `type` := "text",
          `class` := "groupName",
          placeholder := "Group name"
        )
      ),
      div(
        createGroupButton,
        joinGroupButton
      )
    )
  }


  val createGroupButton = input(
    `type` := "button",
    value := "Create"
  ).render

  createGroupButton.onclick = (e: dom.Event) => {
    println("Create group " + getGroupName)
    clearGroupName
  }

  val joinGroupButton = input(
    `type` := "button",
    value := "Join"
  ).render

  joinGroupButton.onclick = (e: dom.Event) => {
    println("Join group " + getGroupName)
    clearGroupName
  }

  def getGroupName = jQuery(".groupName").`val`
  def clearGroupName = jQuery(".groupName").`val`("")
}
