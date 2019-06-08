package com.programmingscala.examples.Traits.traits.`with`.button.goodExample

class ButtonCountObserver extends Observer[Button] {
  var count = 1
  override def receiveUpdate(s: Button): Unit = count += 1
}

object Test extends App {
  val button = new ObservableButton("Click Me!")

  val bco1 = new ButtonCountObserver
  val bco2 = new ButtonCountObserver

  button addObserver(bco1)
  button addObserver(bco2)

  (1 to 5) foreach ( _ => button.click()) //Calling a method with type () => Unit

  assert(bco1.count == 5)
  assert(bco2.count == 5)

  //Another way to create Button is like this
  //Creating Observable button in the fly
  val button2 = new Button("Click Me") with Subject[Button] {
    override def click(): Unit = {
      super.click()
      notifyObservers(this)
    }
  }

  //When declaring a class that only mixes in traits and doesn’t extend another class, you must use the extends keyword
  // anyway for the first trait listed and the with keyword for the rest of the traits. However, when instantiating a class
  // and mixing in traits with the declaration, use the with keyword with all the traits.

    val bco3 = new ButtonCountObserver
    val bco4 = new ButtonCountObserver

  button2 addObserver(bco3)
  button2 addObserver(bco4)

  (1 to 5) foreach(_ => button2.click())

  assert(bco3.count == 5)
  assert(bco4.count == 5)

}

