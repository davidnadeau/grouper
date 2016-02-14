package com.nadeau.grouper

import com.nadeau.grouper.models.Group

object GroupMgmt {
  def createGroup(name: String): Unit = {
    println("Group " + Group(name).name + " created")
  }
  def joinGroup(name: String): Unit = {
    println("Joined group " + Group(name).name)
  }

}
