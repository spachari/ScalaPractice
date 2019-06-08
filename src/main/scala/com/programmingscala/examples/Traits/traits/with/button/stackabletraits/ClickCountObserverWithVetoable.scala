package com.programmingscala.examples.Traits.traits.`with`.button.stackabletraits

import com.programmingscala.examples.Traits.traits.`with`.button.goodExample.Observer

class ClickCountObserverWithVetoable extends Observer[Clickable]{
  var count = 0
  override def receiveUpdate(s: Clickable): Unit = {
    count += 1
  }
}

object Test1 extends App {
  val button = new Button("Click Me!") with Clickable with VetoableClicks {
    override val maxAllowed: Int = 2

  }

  val bco1 = new ClickCountObserverWithVetoable
  val bco2 = new ClickCountObserverWithVetoable

  //button addObserver bco1
  //button addObserver bco2

  (1 to 5) foreach (_ => button.click())

  assert(bco1.count == 2, s"bco1.count ${bco1.count} != 2") 
  assert(bco2.count == 2, s"bco2.count ${bco2.count} != 2")
  println("Success!")
}
