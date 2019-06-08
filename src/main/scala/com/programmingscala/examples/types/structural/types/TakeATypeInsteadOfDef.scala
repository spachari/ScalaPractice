package com.programmingscala.examples.types.structural.types



class Species
class Animal extends Species
class Tiger extends Animal
abstract class Bird1 (name : String) extends Species {
  val birdName = name
  val flySpeed : Int
}

class Sparrow(name : String) extends Bird1(name) {
  type thing = this.type
  val flySpeed = 30
}

class Eagle(name : String) extends Bird1(name) {
  val flySpeed = 60
}

class CanFly {
  def flySpeed(func : {type thing <: Bird1}) = {
    println(func)
  }
}

class CanFlyType[T <: {type thing <: Bird1}](t : T) {
  def flySpeed() = {
    println(t)
  }
}



object TakeATypeInsteadOfDef extends App {

  val sparrow1 = new Sparrow("Robbin")
  val sparrow : Sparrow = new Sparrow("Robbin")


  val att1 = new CanFly
  //val speedForSparrow = att1.flySpeed(sparrow)

  //This does not work
  val canFly = new CanFlyType(sparrow)


}
