package com.scalaCookbook.examples.Functions



object Closures extends App {

  import com.scalaCookbook.examples.Methods.Foo1
  val foo = new Foo1

  var hello : String = "Hello"

  def printName(hello : String) : Unit = {
    println(hello)
  }

  foo.foo(printName)(hello)

  hello = "Hola"

  foo.foo(printName)(hello)

  var ages = 21
  var isValidAge : (Int) => Boolean = x => if (x >= 21) true else false

  //the object foo has access to the current caller's scope
  foo.printResult(isValidAge)(ages)

  var fruits = new scala.collection.mutable.ArrayBuffer[String]()
  def addStuff(item : String) : Unit = {
    fruits += item
    println(fruits.mkString(" , "))
  }

  foo.buyStuff(addStuff)("apple")
  foo.buyStuff(addStuff)("banana")
  foo.buyStuff(addStuff)("grapes")
}
