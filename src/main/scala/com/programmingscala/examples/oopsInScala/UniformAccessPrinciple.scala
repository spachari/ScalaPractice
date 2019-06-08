package com.programmingscala.examples.oopsInScala


//Scala doesn’t follow the convention of the JavaBeans Specification that reader and writer methods for a field
// value are named getValue and setValue, respectively

//Instead, Scala chooses to follow the Uniform Access Principle.
//we could just declare a field in the class body with the default public visibility and then access it as a bare field
//without the need for getters and setters

class Name2(s : String) {
  var value = s
}


object UniformAccessPrinciple extends App {

//Scala doesn’t use Java-style getter and setter methods. Instead, it supports the Uniform Access Principle,
  // where the syntax for reading and writing a “bare” field looks the same as the syntax for calling methods
  // to read and write it, indirectly.

  //Check WHatHappensInsideAVar, we do exactly the same thing that we are doing there for reading and writing

  //so

  /*
  * class Names(s : String) {
  private var  _value : String = s //Invisible field protected by class

  def value : String = _value      //getter

  def value_=(newValue : String) : Unit = { //setter
    _value = newValue
  }

}
  * */

  //is the same as the above class
  //1. A field foo can be accessed (getter) via the same name
  //2. A field can be updated (setter) via foo_=


  val srini = new Name2("Srinivas")

  println(srini.value) //Reading

  srini.value_=("Srini") //Writing

  println(srini.value)

  //it is the same as

  srini.value = "Srinivas"

  println(srini.value)

}
