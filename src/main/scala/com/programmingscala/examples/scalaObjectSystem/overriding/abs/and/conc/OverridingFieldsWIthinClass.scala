package com.programmingscala.examples.scalaObjectSystem.overriding.abs.and.conc

class Animals {
  val name = "animal"
  var age = 20
}

//Only for val we need the override modifier.
//For var no need to declare anything

class Dogs extends Animals {
  override val name: String = "puppy"
   age = 9
}

object OverridingFieldsWIthinClass extends App {

  val pup = new Dogs
  println(pup.name)
  println(pup.age)

}
