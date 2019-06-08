package com.scala.FPS.bestpractices

import java.awt.Color

trait Animal

abstract class AnimalWithTail(tailColor: Color)
  extends Animal

trait DogTailServices {
  this: AnimalWithTail =>
  def wagTail = println("wagging tail")
  def lowerTail = println("lowering tail")
  def raiseTail = println("raising tail")
}

trait DogMouthServices {
  this: AnimalWithTail =>
  def bark = println("bark!")
  def lick = println("licking")
}

object IrishSetter extends AnimalWithTail(Color.red) with DogTailServices with DogMouthServices




object GoldFish extends AnimalThatSwim(name = "boomy")
  with FishServices

//Step 1: Define what your class is, i.e GoldFish is an animal

//Step 2: More specifically GoldFish is a animal that can swim with a name
abstract class AnimalThatSwim(name : String) extends Animal

//Step 2: Define what behaviours it has or service it can provide,

trait FishServices {
  //implementers must be of type AnimalThatSwim i.e. Self type
  //The reason we do this is because we know, we only want objects that implement FishServices also to implement it with
  //AnimalThatSwim and NOT AnimalWithTail
  this: AnimalThatSwim =>
  def swimAgainstTide = println("Fish is sad")
  def swimWithTide = println("Fish is happy")
}


object Test3 extends App {
  val fish = GoldFish

  println(fish.swimAgainstTide)

  val dog = IrishSetter

  println(dog.bark)

}