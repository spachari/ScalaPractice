package com.scalatests.examples.sharing.tests

import org.scalatest.FlatSpec

trait MakeSound {
  def sound() : Unit
}

trait Animal {
  this : MakeSound =>
  def isLivingThing()
}

class Dog  extends Animal with MakeSound {
  def isLivingThing(): Unit = println(s"Yes ${this.getClass.getCanonicalName} is a living thing")

  def sound(): Unit = println(s"Bow wow")
}

object Tests extends App {
  val t = new Dog
  t.isLivingThing()
  t.sound()
}

trait Stackbehaviours { this : FlatSpec =>
  //This just means that when we create an object of Stackbehaviours you need to extend FlatSpec as well




}
