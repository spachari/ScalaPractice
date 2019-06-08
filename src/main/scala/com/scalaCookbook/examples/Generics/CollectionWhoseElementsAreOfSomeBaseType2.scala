package com.scalaCookbook.examples.Generics

import scala.collection.mutable.ArrayBuffer

trait SentientBeing {
  def name : String
}

trait AnimalWithLegs extends SentientBeing
trait TwoLeggedAnimal extends AnimalWithLegs
trait FourLeggedAnimal extends AnimalWithLegs

class Dogs1 (var n : String) extends FourLeggedAnimal
{
  def name : String = n
}

class Man (var n : String) extends TwoLeggedAnimal
{
  def name : String = n
}

class Snake (var n : String) extends SentientBeing
{
  override def name: String = n
}


object CollectionWhoseElementsAreOfSomeBaseType2 extends App {

  def getNameOfSentientBeings[A <: SentientBeing](a : A) = {
    a.name
  }

  //Creating a collection of humans
  class Humans[A <: TwoLeggedAnimal] extends ArrayBuffer[A]
  //Create two elements
  val srini = new Man("Srinivas")
  val sid = new Man("Sidharth")

  val humans : Humans[TwoLeggedAnimal] = new Humans()
  humans += srini
  humans += sid

  //Creating a collection of SentientBeings
  class SentientBeings[A <: SentientBeing] extends ArrayBuffer[A]

  val snake = new Snake("Doodles")

  val livingOrganism : SentientBeings[SentientBeing] = new SentientBeings()
  livingOrganism += srini
  livingOrganism += sid
  livingOrganism += snake

  for (c <- livingOrganism)
    {
      val p = getNameOfSentientBeings(c)
      println(p)
    }


  //we can only use this on men but not snakes
  def getNameOfHumans[A <: Man](a : A) = {
    a.name
  }

  getNameOfHumans(srini)
  getNameOfHumans(sid)
  // we will get run time error
  // getNameOfHumans(snake)

}
