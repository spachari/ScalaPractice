package com.programmingscala.examples.scalaObjectSystem.overriding.abs.and.conc.methods

import com.programmingscala.examples.Traits.traits.`with`.button.stackabletraits.Clickable

class Button (val label : String) extends Widget with Clickable {
  def draw(): Unit = println(s"Drawing ${this}")

  protected def updateUI(): Unit = println(s"${this} clicked, updating UI")

  override def toString: String = s"(button: label=${label}, ${super.toString})"
}

object Test extends App {
  val b = new Button("Submit")

  b.draw()
}