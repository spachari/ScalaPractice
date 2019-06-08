package com.scalaCookbook.examples.Methods

trait Human {
  def Hello = "Human trait"
}

trait Father extends Human {
  override def Hello = "Father trait"
}

trait Mother extends Human {
  override def Hello = "Mother trait"
}

class Son extends Father with Mother with Human {
  def printHello = "Son trait"
  def printFatherHello = super[Father].Hello
  def printMotherHello = super[Mother].Hello
  def printHumanHello = super[Human].Hello
}




object ControlingWhichParentTraitToCallFrom extends App {
  val srini = new Son
  println(srini.printFatherHello)
    println(srini.printHello)
    println(srini.printMotherHello)
    println(srini.printHumanHello)

}
