package com.scalaCookbook.examples.Methods

class Pizza1 {
  val toppings = new scala.collection.mutable.ArrayBuffer[String]

  var crustSize = 12
  var crustType = "Thin"
  var pizaName = "Margaritta"

  def addTopping (item : String) = {
    toppings += item
    this
  }

  def setCrustSize (i : Int) = {
    crustSize = i
    this
  }

  def setCrustType (i : String) = {
    crustType = i
    this
  }

  def setPizzaName (s : String) = {
    pizaName = s
    this
  }

  override def toString: String = s"The size of the Pizza is ${crustSize} and type is ${crustType}"
}

object FluentStyleProgrammingPizza extends App {
  val p = new Pizza1
  p.setCrustSize(10)
    .setCrustType("Thick")
    .setPizzaName("Vegetarian")
    .addTopping("Pine Apple")
    .addTopping("Olives")
    .addTopping("Onions")
    .addTopping("Peppers")

  println("Crust Type " + p.crustType)
  println("Crust Size " + p.crustSize)
  println("Pizza Name " + p.pizaName)
  println("Toppings " + p.toppings)
}
