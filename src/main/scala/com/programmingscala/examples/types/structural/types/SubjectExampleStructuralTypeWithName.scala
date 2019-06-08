package com.programmingscala.examples.types.structural.types

trait SubjectFunc {
  type State

  type Observer = State => Unit

  private var observers : List[Observer] = Nil

  def addObserver(observer: Observer) =  observer :: observers

  def notifyObservers(state : State) : Unit = observers.foreach(x => x(state))
}


object SubjectExampleStructuralTypeWithName extends App {

  val observer : Int => Unit = (state: Int) => println(state)

  val test = new SubjectFunc {
    override type State = Int

  }


}
