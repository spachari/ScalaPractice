package com.programmingscala.examples.scalaObjectSystem.overriding.abs.and.conc

abstract class LivingThing {
  def isLivingThis()
}

trait MakeNoise {
  def sound()
}

class Animal {
  def eat : Unit = { println("Eat anything") }
}

class Dog extends Animal  with MakeNoise {
  //In scala we need the override keyword when a sub class overrides a superclass method (jave does not)
  override def eat : Unit = { println("Eat biscuits") }

  //overrides is optional when a subclass method extends a trait or a
  def sound() = { println ("bow wow")}
}

class Amoeba extends LivingThing  with MakeNoise {
  //override keyword is optional when a sub class overrides an abstract method (jave does not)
  def isLivingThis() : Unit = { println("I am living ") }

  //overrides is optional when a subclass method extends a trait or a
  def sound() = { println ("bow wow")}
}

//Good points about override keyword

//It catches errors when you create a method with different signature to the one that the super class has
//You cannot accidentally create a method with the same name. Wihtout the override keyword, compiler will catch it.
//It will remind you to think what should and should not be overridden

//Bad points about the overide keyword

//Catching typos is really not necessary. A misspelled override means compiler will fail
//If in the future, the parent class decides to change an abstract member to permanent member,
// the child class member's program compiler will not point out.
//But the child class method will fail at run time.

//But we should never override a permanent class member.

object OverridingMembersOfClassesAndTraits extends App {

}
