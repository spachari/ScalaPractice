package com.scalaCookbook.examples.Generics

import scala.collection.mutable.ArrayBuffer

//All immutable collections are Covariant.
//Example
//class List[+T]
//class Vector[+A]
//trait Seq[+A]

trait AnimalC {
  def speak
}

class DogC(var name : String) extends AnimalC {
  override def speak: Unit = { println("Dog says woof") }
}

class SuperDogC(name : String) extends DogC(name) {
  override def speak: Unit = { println("SuperDog says speak") }
}



object ImmutableCollectionsAreCovariant extends App {


  //Couple of dogs
  val shaggy = new DogC("Shaggy")
  val scooby = new DogC("Scooby")

  //Couple of superDogs
  val superdog = new SuperDogC("superdog")
  val spierdog = new SuperDogC("spiderdog")


  val allDogsArray = ArrayBuffer(scooby, shaggy, superdog, spierdog)
  val dogsArray = ArrayBuffer(shaggy, scooby)
  val superdogsArray = ArrayBuffer(superdog, spierdog)

  //This is a immutable collection, so we can only pass dogs
  def makeDogsSpeak(dogs : ArrayBuffer[DogC]) = {
    dogs.map(_.speak)
  }

  //fine to call these
  makeDogsSpeak(allDogsArray)
  //This will not work
  //makeDogsSpeak(superdogsArray)

  val allDogsSeq = Seq(scooby, shaggy, superdog, spierdog)
  val dogsSeq = Seq(shaggy, scooby)
  val superdogsSeq = Seq(superdog, spierdog)

  //This is a immutable collection, so we can pass dogs and superdogs
  def makeAllDogsSpeak(dogs : Seq[DogC]) = {
    dogs.map(_.speak)
  }

  //This is the meaning of co-variance. we can call the method with collection of it's elements and
  // with collection of it's child elements
  //Because Seq is immutable and defined with a covariant parameter type,
  // makeDogsSpeak can now accept collections of both Dog and SuperDog.


  makeAllDogsSpeak(allDogsSeq)
  makeAllDogsSpeak(dogsSeq)
  makeAllDogsSpeak(superdogsSeq)

  //We can explain this with another class
  class CovariantContainer[+A] (val elem : DogC)

  val cont = new CovariantContainer(shaggy)

  def takeCovariantContainersInDogs(dog : CovariantContainer[DogC]) = {
    dog.elem.speak
  }

  //We can pass both dog and superdog
  takeCovariantContainersInDogs(new CovariantContainer[DogC](shaggy))
  takeCovariantContainersInDogs(new CovariantContainer[SuperDogC](superdog))

  //Because the Container element is immutable and its mutable type parameter is marked as covariant,
  // all of this code works successfully.
  // Note that if you change the Container’s type parameter from +A to A, the last line of code won’t compile.

  //If we create an invariant container, we can only pass it's type
  class InvariantContainer[A](val elem : DogC)

  def takeInvariantContainersInDogs(dog : InvariantContainer[DogC]) = {
    dog.elem.speak
  }

  //we can only pass dog and not superDog
  takeInvariantContainersInDogs(new InvariantContainer[DogC](shaggy))

  //This will not work
  //takeInvariantContainersInDogs(new InvariantContainer[SuperDogC](superdog))

}
