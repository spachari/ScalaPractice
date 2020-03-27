package com.programmingscala.examples.types.variance.in.inheritance

abstract class Person {
  val name : String
}

class GrandParent (val name : String) extends Person {
  def livingTimes = s"$name lived in the 60s"
}

class Parent (name : String) extends GrandParent(name) {
  def mobileNumber(mobileNumber : String) = s"$name's mobile number was ${mobileNumber}"
}

class Child (name : String) extends Parent(name) {
  def smartPhoneApp(list : List[String]) = s"$name used ${list.mkString(" ,")} apps"
}


object Test {

  val f : Parent => Parent = (p : Parent) => new Parent("Srinivas")

  //Why should function parameters be contra-variant
  //Note that it's ok to pass a GrandParent to f because Parent will obviously have all methods that grand parent has

  //Why should function return type be co-variant

  val output : Parent = f(new Parent("Srinivas"))

}
