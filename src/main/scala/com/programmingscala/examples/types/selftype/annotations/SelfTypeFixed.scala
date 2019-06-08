package com.programmingscala.examples.types.selftype.annotations


//Self-type annotations serve two purposes
//1. First, they let you specify additional type expectations for this, in this example, we can mention
// this is of type S rather than Subject.
//2. Second, they can be sued to create type alias for this.

abstract class SubjectObserver1 {
  type S <: Subject1
  type O <: Observer1

  trait Subject1 {

    self : S =>
    //Declared a self type annotation that is self
    //This means, we can assume that a Subject will really be S that is a subType of Subject.
    //In effect, it means that it will be an instance of whatever concrete type that will mix in
    //Subject

    private val observers = List[O]()

    def addObservers(observer : Observer1) = observer :: observers

    def notifyObservers() = observers.foreach(_.receiverUpdate(self))

  }

  trait Observer1 {
    def receiverUpdate(subject : S)
  }

}

object SelfTypeFixed {

}
