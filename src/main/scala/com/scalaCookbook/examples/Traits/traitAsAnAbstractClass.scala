package com.scalaCookbook.examples.Traits

//Traits are best used as a abstract class in that we do not need to imlement a abstract method of a super class
//

trait Pet {
  def speak { println("yo")}
  def comeToMe
}

trait Dogs extends Pet {
  override def comeToMe: Unit = { println("I will come to my owner") }
}

trait Cat extends Pet {
  override def speak: Unit = { println("meow") }
  override def comeToMe: Unit = println("This is not going to happen")
}

trait FlyingPet extends Pet {
  override def speak: Unit = { println("squeak")}
}

class Parrot extends FlyingPet {
  override def comeToMe: Unit = { println("I can only come by flying") }
}

class CuteWhiteCat extends Cat {
}

object traitAsAnAbstractClass extends App {
  val c = new CuteWhiteCat
  c.comeToMe
  c.speak

  val p = new Parrot
  p.comeToMe
  p.speak
}
