package com.programmingscala.examples.types.selftype.annotations


abstract class SubjectObserver {
  type S <: Subject
  type O <: Observer

  trait Subject {
    private val observers = List[O]()

    def addObserver(observer: O) = observers :: observers
    //def notifyObservers = observers.foreach(_.receiveUpdate(this))//
    //The above line will not work. this will refer only the object Subject, but actual receiveUpdate
    //takes a S which is only something less than Subject


  }

  trait Observer {
    def receiveUpdate(subject : S)
  }

}

object WontCompileWithThisInAbstractclass extends App {



}
