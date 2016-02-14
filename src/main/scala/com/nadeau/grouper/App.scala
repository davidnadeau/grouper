package com.nadeau.grouper

import com.nadeau.grouper.components.HomePage

import scala.scalajs.js.JSApp
import org.scalajs.jquery.jQuery

object App extends JSApp {
  def main() = {
    jQuery(setupUI)
  }

  def setupUI = {
    jQuery("body").append(HomePage.render)
  }

}
