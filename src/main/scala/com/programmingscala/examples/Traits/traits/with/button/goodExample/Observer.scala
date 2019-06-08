package com.programmingscala.examples.Traits.traits.`with`.button.goodExample

trait PrintState[State] {
  def printState(s : State)
}

trait Observer[-State] {
  def receiveUpdate(s : State) : Unit
}

trait Subject[State] {
  private var observers = List[Observer[State]]()

  def addObserver(observer : Observer[State]) = {
    observers ::= observer
  }

  def notifyObservers(s : State) = {
    observers foreach( _.receiveUpdate(s))
  }

  //Often, the most convenient choice for the State type parameter is just the type of the class mixing in Subject.
  // Hence, when the notifyObservers method is called, the instance just passes itself, i.e., this.

}
