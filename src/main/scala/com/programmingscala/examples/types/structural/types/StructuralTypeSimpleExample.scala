package com.programmingscala.examples.types.structural.types


/* In these methods we only use a name for a method quack, we should make it more generic
*
* class Duck[A <: {def quack(value : String) : String}](a : A) extends CanQuack { //This will ensure that we can create a class that has duck method only

  def quacker(duck: {def quack(value: String): String}, s : String) = {
    duck.quack(s)
  }

  def quacks(s : String) = {
    a.quack(s)
  }
}
*
* */

trait Quacking {
  type Duck

  type Quack = Duck => Duck

  type Foo = String => Unit

  def printOutput(s : Quack)(i : Int) = {
    s
  }

  def printFoo(f : Foo)(s:String) = {
    println(s)
  }
}


object StructuralTypeSimpleExample extends App {

  val quack : Int => Int = (i : Int) => i + 10

  val foo : String => Unit = (s : String) => println(s)

  val s = new Quacking {
    override type Duck = Int

    override type Quack = Int => Int

    override type Foo = String => Unit

  }

  s.printOutput(quack)(10)
  s.printFoo(foo)("tru")

}
