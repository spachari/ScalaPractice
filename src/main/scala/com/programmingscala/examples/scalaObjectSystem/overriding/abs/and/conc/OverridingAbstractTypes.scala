package com.programmingscala.examples.scalaObjectSystem.overriding.abs.and.conc

abstract class Human {
  type In
  type Out = String //Cannot be overridden
  val sex : String
}

class Man extends Human {
  type In = String //There is no override keyword in abstract types
  override val sex: String = "Male"
}


object OverridingAbstractTypes extends App {

  val man = new Man
  println(man.sex)


}
