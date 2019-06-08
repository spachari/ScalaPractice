package com.scalaCookbook.examples

abstract class Pet (var name : String) {
  val greeting : String //When we declare the fields as abstract, scala does not create the field, it just creates the
  //getter. This is equal to def val greeting : String
  var age : Int //When we declare the fields as abstract, scala does not create the field, it just creates the
  //getter/setter
  def owner : String


  def sayHello = { println(greeting) }

  val iam = println("animal")

  override def toString: String = s"I am ${name} and say ${greeting}. My owner is ${owner}"

  var ownerid = 0
}

class Dog(name : String) extends Pet(name) {
  val greeting = "Woof!" //Because of this, we will need to provide the implemented fields as val or val
  var age = 20
  val owner = "Srinivas"

  override val iam = println("dog")

  ownerid = 100 //In this case we do not need to provide anything since variable ownerid is already created

}

object AbstractClassVarsandVals extends App {
  val d = new Dog("Fido") //If you see, iam variable is created in both classes
  println("Completed object creation ... ")
  println(d)
  d.sayHello
  println("I am a ...")
  d.iam
}
