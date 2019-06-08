package com.scalaCookbook.examples.Generics

//All mutable collections are invariant.
//Example
//class Array[A]
//class ArrayBuffer[A]
//class ListBuffer[A]


trait Animal {
  def speak
}

class Dog1(name : String) extends Animal {
  def speak = { println("woof") }

  override def toString: String = s"My name is ${name}"
}

class SuperDog (name : String) extends Dog1(name) {
  def useMySuperPower = { println("Using my super power") }
}

class MutableCollectionsAreInvariant extends App {
  //All mutable collections are invariant
  //It means it can take elements (with which the collection is created)

  val dog = new Dog1("fido")
  val shaggy = new SuperDog("super dog")
  val wonderDog = new SuperDog("wonder dog")

  val dogs = new scala.collection.mutable.ArrayBuffer[Dog1]()
  dogs += dog



  //dogs += shaggy
  //dogs += wonderDog



  //Let's create a method that takes dogs methods
  import scala.collection.mutable._
  def makeDogsSpeak(dogs : ArrayBuffer[Dog1]) = {
    dogs.foreach(_.speak)
  }

  //This will work
  makeDogsSpeak(dogs)

  val superDogs = new scala.collection.mutable.ArrayBuffer[SuperDog]()
  superDogs += shaggy
  superDogs += wonderDog

  //This will not work
  //makeDogsSpeak(superDogs)


  //THe reason is beacause
  // 1. ArrayBuffer is mutable
  // 2. makeDogsSpeak is defined to accept a parameter of type ArrayBuffer[Dog1]
  // 3. We are attempting to pass shaggy which is of type ArrayBuffer[SuperDog]
  // 4. if the compiler allowed this, makeDogsSpeak could replace SuperDog elements with plain old Dog1 elements

  //SO all mutable collections are invariant. It means it can take elements (with which the collection is created)
  //Example
  //class Array[A]
  //class ArrayBuffer[A]
  //class ListBuffer[A]


}
