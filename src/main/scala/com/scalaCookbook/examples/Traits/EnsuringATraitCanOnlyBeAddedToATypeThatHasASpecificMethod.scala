package com.scalaCookbook.examples.Traits

//This approach is known as structural type
//This is saying, the class that implements this trait has to use this method
trait WrapCore1 {
  this : { def ejectWrapCore(password: String): Boolean } =>
}

class Starship{

}

//THis class has to implement this method if it wants to use this trait
class Enterprise1 extends Starship with WrapCore1 {
  def ejectWrapCore(password: String): Boolean = {
    if (password == "password") {
      println("ejecting core")
      true
    }
    else false
  }
}


trait MyAnimal {
  this : { def speak(name : String)
           def checkPassword(password : String) : Boolean
  } =>
}

class FourLeggedAnimals (var name : String)

class Dog1 (name : String) extends FourLeggedAnimals(name) with MyAnimal {
  def speak(name : String) = println(s"My name is ${name}")
  def checkPassword(password : String) : Boolean = {
    if (password == "password")
      {
        println("He got it right")
        true
      }
    else
      false
  }
}

object EnsuringATraitCanOnlyBeAddedToATypeThatHasASpecificMethod extends App {
  val d = new Dog1("Srinivas")
  d.speak("Srinivas")
  d.checkPassword("password")
}
