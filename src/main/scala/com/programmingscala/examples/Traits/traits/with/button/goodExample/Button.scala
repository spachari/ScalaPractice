package com.programmingscala.examples.Traits.traits.`with`.button.goodExample

import com.programmingscala.examples.Traits.traits.`with`.button.badExemple.Widget

class Button(val label : String) extends Widget {

  def click() = {
    updateUI()
  }

  def updateUI() : Unit = {}

}
