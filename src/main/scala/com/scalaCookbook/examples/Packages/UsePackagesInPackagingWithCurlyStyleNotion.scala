package com.scalaCookbook.examples.Packages


class CreatePizza {


  import com.scalaCookbook.examples.Methods.Pizza1
  var pizza1 : Pizza1 = _
  def create = {
    val b = new Pizza1
    this.pizza1 = b
  }

  def order = {
    pizza1.crustType = "Cheese"
    pizza1.crustSize = 19
  }

  override def toString: String = s"Pizza crustsize is ${pizza1.crustSize} and piza crustType is ${pizza1.crustType}"

  def printThis = {
    create
    order
    println(this)}

  printThis
}


//Accessing the packages in Packaging With Curly Style Notion
object UsePackagesInPackagingWithCurlyStyleNotion extends App {
  println(new Foo)
  println(new orderentry.Foo)
  println(new customers.Foo)
  println(new customers.database.Foo)

  import com.scalaCookbook.examples.Methods.{Persons,Pizza1}
  println(new Persons)
  println(new Pizza1)

  import com.scalaCookbook.examples.Objects.Fruits
  println(new Fruits("apple"))

  val pizza = new CreatePizza
  pizza.create

}
