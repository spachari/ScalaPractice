package com.programmingscala.examples.types.structural.types


/*


trait Observer[-State] {
  def receiveUpdate(state: State): Unit
}
trait Subject[State] {
  private var observers: List[Observer[State]] = Nil
  ...
}
A disadvantage of this  is any type that watches the state changes, should implement the Observer trait
 */

//In reality we just want the method to implement the def receiveUpdate(state: State): Unit method

trait Subject {

  import scala.language.reflectiveCalls

  type State

  //type Observer = { def receiveUpdate(state : State) : Unit }

  //Unfortunately, Scala won’t let a structural type refer to an abstract type or type parameter.
  // So, we can’t use State. We have to use a type that’s already known, like Any. That means that the receiver may need
  // to cast the instance to the correct type, a big drawback.

  type Observer = { def receiveUpdate(state : Any) : Unit }

  private val observers : List[Observer] = List[Observer]()

  def addObservers(observer : Observer) =  observer :: observers

  def notifyObservers(state : State) = observers.foreach(_.receiveUpdate(state))

  //Unfortunately scala wont let us use an abstract type or

}

//Let's use this

object Testing extends App {
  object observer {
    def receiveUpdate(state : Any) : Unit = println("Got one !" + state)
  }

  val subject = new Subject {
    override type State = Int

    protected var count = 1

    def increment = {
      count += 1
      notifyObservers(count)
    }
  }


  subject.increment
  subject.increment
  subject.addObservers(observer)
  subject.increment
  subject.increment



}



