package com.programmingscala.examples.Traits.traits.`with`.button.stackabletraits

import com.programmingscala.examples.Traits.traits.`with`.button.goodExample.Subject

trait ObservableClicks extends Clickable with Subject[Clickable]{
  abstract override def click(): Unit = {
    super.click()
    notifyObservers(this)

    //Look closely at this method. It calls super.click(), but what is super in this case? At this point, it could
    // only appear to be Clickable, which declares but does not define the click method, or it could be Subject, which
    // doesn’t have a click method. So, super can’t be bound to a real instance, at least not yet. This is why abstract is
    // required here.

    //In fact, super will be bound when this trait is mixed into a concrete instance that defines the click method,
    // such as Button. The abstract keyword tells the compiler (and the reader) that click is not yet fully implemented,
    // even though ObservableClicks.click has a body.

    //The abstract keyword is only required on a method in a trait when the method has a body,
    // but it invokes another method in super that doesn’t have a concrete implementation in parents of the trait.
  }

}
