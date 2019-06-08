package com.programmingscala.examples.types.structural.types

abstract class SuperPowerMen {
  val superPower : String
}

class SuperMan(name : String) extends SuperPowerMen {
  override val superPower: String = "Flying"
}

class Spiderman(name : String) extends SuperPowerMen {
  override val superPower: String = "Climb Wals"
}

class Men(name : String)

class Powers[T <: {val superPower : String}](t : T) {
  println(t.superPower)
}

object TakeAValInsteadOfDef extends App {

  val superMan = new SuperMan("Clark Kent")
  val superManPower = new Powers[SuperMan](superMan)
  println(superManPower)

}
