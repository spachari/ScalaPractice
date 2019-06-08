package com.scalaCookbook.examples.Methods

//Like Java Super class methods can be accessed via the keyword super

class FourLeggedAnimal {
  def walk = println("move slowly")
  def run = println("Move quickly")
}

class Dogs extends FourLeggedAnimal {
  def movingStyle  = {
    super.walk
    super.run
  }
}

object CallingMethodsOnSuperClass extends App {
  val d = new Dogs
  d.movingStyle
}
