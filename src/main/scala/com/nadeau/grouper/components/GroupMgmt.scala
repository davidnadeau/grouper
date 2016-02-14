package com.nadeau.grouper.components

import com.nadeau.grouper.models.Group

import scalatags.JsDom.all._

object GroupMgmt {

  var groups = Group.spoofGroups(10)

  def renderGroupComponent = {
    div(
      renderGroupControls,
      renderGroupList
    ).render
  }

  def renderGroupControls = {
    div(
      input(
        `type` := "text",
        placeholder := "Group name"
      ),
      input(
        `type` := "button",
        value := "Create"
      )
    )
  }

  def renderGroupList = ul(
    for {
      group <- groups
    } yield li(group.name)
  )
}
