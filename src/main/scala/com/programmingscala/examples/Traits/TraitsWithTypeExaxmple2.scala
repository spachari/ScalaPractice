package com.programmingscala.examples.Traits


//Like a class we can use parameterised types with traits too
trait DonutShoppingCartDao[A] {

  def add (donut : A) : Long
  def update (donut : A) : Boolean
  def search(donut : A) : A
  def delete(donut : A) : Boolean

}

class DonutShoppingCart[A] extends DonutShoppingCartDao[A] {
  override def add(donut: A) = {
    1
  }

  override def update(donut: A) = true

  override def search(donut: A) = donut

  override def delete(donut: A) = true
}

object TraitsWithTypeExaxmple2 extends App {

  val myDonuts = new DonutShoppingCart[String]()

  println(myDonuts.add("Vanilla Donut"))
  println(myDonuts.update("Vanilla Donut"))
  println(myDonuts.search("Vanilla Donut"))
  println(myDonuts.delete("Vanilla Donut"))

}
