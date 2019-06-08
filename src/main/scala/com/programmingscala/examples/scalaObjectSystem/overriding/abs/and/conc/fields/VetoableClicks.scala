package com.programmingscala.examples.scalaObjectSystem.overriding.abs.and.conc.fields

import com.programmingscala.examples.Traits.traits.`with`.button.stackabletraits.Clickable

trait VetoableClicks extends Clickable{

  val maxAllowed = 1
  private var count = 0

  abstract override def click(): Unit = {
    if (count <= maxAllowed)
      {
        count += 1
        super.click()
      }
  }

}
