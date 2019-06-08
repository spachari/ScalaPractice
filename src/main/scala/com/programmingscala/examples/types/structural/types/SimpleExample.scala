package com.programmingscala.examples.types.structural.types

case class BigDuck() {
  def quack(value : String) = {
    println("In case class ...")
    value.toUpperCase
  }
}

object BigDuck {
  def quack(value : String) = {
    println("In object ...")
    value.toUpperCase
  }
}

object SmallDuck {
  def quack(value : String) = {
    value.toLowerCase
  }
}

object IamNotReallyADuck {
  def quack(value : String) = {
    "prrrp"
  }
}

trait CanQuack {
  def quacker(duck : { def quack(value : String) : String}, s : String) : String
}

class Bird extends CanQuack {
  override def quacker(duck: {def quack(value: String): String}, s : String): String = { //This will ensure that we can only call quacker with
    duck.quack(s)                                                                        //an object that has quack method
  }

  def quackers[A <: {def quack(value : String) : String}](a : A) = {
    a.quack("quack")
  }
}

class Duck[A <: {def quack(value : String) : String}](a : A) extends CanQuack
{ //This will ensure that we can create a class that has duck method only

  def quacker(duck: {def quack(value: String): String}, s : String) = {
    duck.quack(s)
  }

  def quacks(s : String) = {
    a.quack(s)
  }
}

class PrintName[A <: {val name : String}](a : A) { //Structural type on a val

  def printName = println(a.name)

}

case class Person(s : String) {
  val name = s
}



object SimpleExample extends App {

  val bird = new Bird().quacker(BigDuck, "Quack")
  println(bird)

  val brds = new Bird().quackers(BigDuck)
  println(brds)

  val duck = new Duck[BigDuck](new BigDuck)
  println(duck.quacker(new BigDuck, "quack"))

  val person = new PrintName(new Person("Srinivas"))

  person.printName

  //it can be an anomyous class also

  case class Foo(s : String) {
    val name = s
  }
  val name = new PrintName(new Foo("Srinivas") {
    override val name: String = "Srinivas"
  })

}
