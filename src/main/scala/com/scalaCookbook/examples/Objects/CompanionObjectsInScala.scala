package com.scalaCookbook.examples.Objects


//Companion objects are the equivalent of static keyword. Just have the same name for class and object
// and put them in the same file
//Define menbers that owuld appear static like in object

class Pizza (var crustType : String) {
  override def toString = s"Pizza's crust Type is ${crustType}"
}

object Pizza {
  val DEFAULT_CRUST_TYPE = "Thin"
  val DEFAULT_CRUST_SIZE = 10

  def getFoo = "Foo"
}

//Private values from class can be accessed via the object in Object
class Foo {
  private val foo = "Foo"
}

object Foo {
  def printFoo(foo : Foo) = println(s"I can access ${foo.foo}")
}



//Private values from objects can be accessed via the ObjectName. format
class Bar {
  override def toString: String = s"Bar is ${Bar.bar}"
}

object Bar {
  private val bar = "Bar"
}

object CompanionObjectsInScala extends App {
  //Anything that called directly from Pizza. is from the object
  println(Pizza.DEFAULT_CRUST_SIZE)
  println(Pizza.getFoo)

  //Anything that is called via an object val b = new Pizza("Thick") from Pizza. is from the object
  val b = new Pizza("Thick")
  println(b.toString)

  val foo = new Foo
  println(Foo.printFoo(foo))

  val bar = new Bar
  println(bar.toString)
}
