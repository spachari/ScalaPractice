package com.programmingscala.examples.types.dzone.article

object SimpleExampleOfTraitFunction1 extends App {

  class Animal
  class Dog extends Animal
  class Cat extends Animal
  class BullDog extends Dog

  trait Function1[-T, +R] extends AnyRef {
    def apply(v1 : T) : R
  }

  val bullDoggy = new BullDog

  //Let's test the return types, because R is covariant, it can return any type of Animal
  val doSomething1: (BullDog => Animal) = (bullDoggy) => new Cat
  val doSomething2: (BullDog => Animal) = (bullDoggy) => new Dog
  val doSomething3: (BullDog => Animal) = (bullDoggy) => new BullDog
  val doSomething4: (BullDog => Animal) = (bullDoggy) => new Animal


  val catty = new Cat
  val doggy = new Dog
  val animal = new Animal

  //Let's test the ingenstion types, T is contravariant
  val doSomething5: (BullDog => Animal) = (bullDoggy) => new Cat

  val doSomething7: (BullDog => Animal) = (doggy : Dog) => new Animal
  val doSomething8: (BullDog => Animal) = (animal : Animal) => new Animal

  //val doSomething6: (BullDog => Animal) = (catty : Cat) => new Animal //wont work because


}
