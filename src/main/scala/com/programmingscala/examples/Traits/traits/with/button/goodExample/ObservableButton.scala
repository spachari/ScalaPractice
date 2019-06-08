package com.programmingscala.examples.Traits.traits.`with`.button.goodExample

class ObservableButton(name : String) extends
  Button(name) //class that hass the clicking property
  with Subject[Button] //trait that has the notification to all observers. This is how traits are useful
{
  //A subclass of Button that mixes in observability (from Subject).
  //Extends Button and mixes in Subject and uses Button as the Subject type parameter,
  // named State in the declaration of Subject.


  override def click(): Unit = {
    super.click()
    notifyObservers(this) //Remember, is a Button too because it extends Button(name)

  }

}
