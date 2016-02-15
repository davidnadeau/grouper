package com.nadeau.grouper

import com.nadeau.grouper.models.Group

object GroupMgmt {
  var currentGroup: Group = Group.None

  def createGroup(name: String): Unit = {
    currentGroup = Group(name)
  }
  def joinGroup(name: String): Unit = {
    println("Joined group " + Group(name).name)
  }

}
