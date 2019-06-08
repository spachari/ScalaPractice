package com.programmingscala.examples.types

object CreatingObjectsFromTypes extends App {

  //Remember, type alias does not alias it's companian object
  //We still need to use new keyword to create an instance from a type alias
  //So if we have a type like this
   class Person( name : String) {
    def getName() = name
  }

  object Person {
    def apply(name : String) = new Person(name)
    def marks(i : Int) = 100
  }

  type PersonClassType = Person //Creating an alias for the case class


  //we cannot do these things on the case class
  val person = new PersonClassType("Srinivas")
  //println(person.name)
  println(person.getName())

  //We cannot create a type alias on the object. The below did not work
  //type PersonObjectType = Person.type
  //val personMark = new PersonObjectType
  //println(personMark.marks(100))

}
