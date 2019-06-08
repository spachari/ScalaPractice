package com.programmingscala.examples.Traits.traits.`with`.button.stackabletraits

import com.programmingscala.examples.Traits.traits.`with`.button.badExemple.Widget

class Button(name : String) extends Widget with Clickable {
  override protected def updateUI(): Unit = {

  }
}
