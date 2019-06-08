package com.scalaCookbook.examples.Idioms

trait Animal {
  def makeSound()
}

class Dog extends Animal {
  override def makeSound(): Unit = println("woof!")
}

class NullAnimal extends Animal {
  override def makeSound(): Unit = {

  }
}

object NullObjectPattern extends App {
  val nonAnimal = new NullAnimal
  println(nonAnimal.makeSound())
}
