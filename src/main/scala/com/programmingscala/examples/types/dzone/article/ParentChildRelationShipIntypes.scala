package com.programmingscala.examples.types.dzone.article

case class AllThings (val name : String)
{
  def isLiving(x : String) = if (x == "yes") true else false
}

class Animals(val animalName : String) extends AllThings(animalName)
{
  def eat = println("I can eat")
}

object ParentChildRelationShipIntypes extends App {

  val dog : Animals = new Animals("dog")

  //A child class can access parent class methods because of is a relationship
  dog.eat
  println(dog.animalName)

  //Parent class can only access their own methods
  val thing : AllThings = AllThings("train")
  println(thing.isLiving("no"))

}
