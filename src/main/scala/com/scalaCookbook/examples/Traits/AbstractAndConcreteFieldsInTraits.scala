package com.scalaCookbook.examples.Traits

trait PizzaItems {
  var crustType : String
  var crustSize : Int
  def maxNumberOfToppings = 10
}

class Pizza extends PizzaItems {
  override var crustType = ""
  override var crustSize = 0

  override def maxNumberOfToppings: Int = 20

  def setPizzaCrustType(crustType : String) = {
    this.crustType = crustType
    this
  }

  def setPizzaCrustSize(crustSize : Int) = {
    this.crustSize = crustSize
    this
  }

  override def toString: String = s"The Pizza ordered is of size ${crustSize} and ${crustType} " +
    s"and it can have max${maxNumberOfToppings}" +
    s" toppings"

}

object AbstractAndConcreteFieldsInTraits extends App {
  val myPizza = new Pizza
  myPizza.setPizzaCrustSize(10)
  myPizza.setPizzaCrustType("Thick")

  println(myPizza)
}
