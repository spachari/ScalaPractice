package com.scalaCookbook.examples.Collections

trait Animal
trait FurryAnimal extends Animal

case class Dog(name : String) extends FurryAnimal
case class Fish(name : String) extends Animal

object DeclaringATypeWhenCreatingACollection extends App {

  val l = List(1, 23D, 400L)

  //This can also be created as this
  val num = List[Number](1, 23D, 400L)
  val anyValDoubles = List[AnyVal](1, 23D, 400L)
  val anyDoubles = List[Any](1, 23D, 400L)

  val animals = List[Animal]( Fish("Goldie"), Dog("Ricky"))
  val dogs = List[Dog]( Dog("Rocky"),  Dog("Rambo"))

  for (elem <- dogs) {
    println(elem.name)
  }

}
