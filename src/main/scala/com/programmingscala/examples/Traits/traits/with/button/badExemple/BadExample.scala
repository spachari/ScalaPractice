package com.programmingscala.examples.Traits.traits.`with`.button.badExemple

class ButtonWithCallBacks (val label : String, val callBacks: List[() => Unit]) extends Widget {

  def click () : Unit = {
    updateUI()
    callBacks foreach(f => f()) //using a function of type () => Unit. f is the local variable and f() is using the function
  }

  def updateUI() = ???

}

//We should strive for separation of concerns in our types, as embodied in the Single Responsibility
// Principle, which says that every type should “do one thing” and not mix multiple responsibilities.

//We would like to separate the button-specific logic from the callback logic, such that each part becomes
// simpler, more modular, easier to test and modify, and more reusable. The callback logic is a good candidate for a mixin.

object ButtonWithCallBacks {
  def apply (label : String, callBacks : List[() => Unit]) = new ButtonWithCallBacks(label, callBacks)

  def apply (label : String) = new ButtonWithCallBacks(label, Nil)
}

object BadExample extends App {

}
