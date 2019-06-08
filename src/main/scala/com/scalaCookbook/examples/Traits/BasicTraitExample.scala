package com.scalaCookbook.examples.Traits

abstract class Animal {
  def speak (noise : String)
}

trait TailWagging {
  def startWaggingTail = println("Start wagging tail")
  def stopEaggingTail = println("Stop wagging tail")
}

trait FourLeggedAnimal {
  def run
}

trait TwoLeggedAnimal {
  def run
}
trait CivilizedThings {
  def goToOffice
  def bePolite
}

class Dog extends Animal with TailWagging with FourLeggedAnimal {
  def speak (noise: String) = println(s"I can make ${noise}")
  override def run = println("I can run faster, because I have 4 legs")
}

class Person extends Animal with TwoLeggedAnimal with CivilizedThings {
  def speak (noise : String) = println(s"I can make ${noise}")
  def run = println("I can only walk or atbest run slower")

  override def goToOffice: Unit = println("Please be polite")

  override def bePolite: Unit = println("Please be civilized")
}

object BasicTraitExample extends App {
  val d = new Dog
  d.run
  d.speak("woof!")
  d.startWaggingTail
  d.stopEaggingTail

  val m = new Person
  m.bePolite
  m.goToOffice
  m.run
  m.speak("Mum")
}
