package com.programmingscala.examples.Traits.traits.`with`.button.stackabletraits

trait VetoableClicks extends Clickable {
  //A trait that checks if the maximum allowed number of clicks is met.
  //If it is not met we can click or nothing will happen

  val maxAllowed = 1

  private var count = 0

  abstract override def click(): Unit = {
    if (count > maxAllowed)
      {
        super.click()
        count += 1
      }
  }
}
