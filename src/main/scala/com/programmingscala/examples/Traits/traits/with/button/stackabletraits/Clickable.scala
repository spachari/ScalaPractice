package com.programmingscala.examples.Traits.traits.`with`.button.stackabletraits

trait Clickable {
  def click() : Unit = updateUI()
  protected def updateUI()
}
