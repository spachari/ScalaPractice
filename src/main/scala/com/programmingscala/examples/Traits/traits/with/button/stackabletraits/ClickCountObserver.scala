package com.programmingscala.examples.Traits.traits.`with`.button.stackabletraits

import com.programmingscala.examples.Traits.traits.`with`.button.goodExample.Observer

class ClickCountObserver extends Observer[Clickable] {
  var count = 0
  override def receiveUpdate(s: Clickable): Unit = count += 1
}

object Test extends App {

  val button = new Button("Click Me!") with ObservableClicks

  val bco1 = new ClickCountObserver
  val bco2 = new ClickCountObserver

  button addObserver bco1
  button addObserver bco2

  (1 to 5) foreach (_ => button.click())

  assert(bco1.count == 5, s"bco1.count ${bco1.count} != 5")
  assert(bco2.count == 5, s"bco2.count ${bco2.count} != 5")
  println("Success!")

}