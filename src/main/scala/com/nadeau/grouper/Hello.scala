package com.nadeau.grouper

import com.nadeau.grouper.components.GroupMgmt

import scala.scalajs.js.JSApp
import org.scalajs.dom
import org.scalajs.dom.html
import scalatags.JsDom.all._
import dom.document


object Hello extends JSApp {
  def main(): Unit = {
    document.body.appendChild(GroupMgmt.renderGroupComponent)
  }
}
