package com.design.patterns.cake.pattern

trait Able {
  def getname() : String
}

class FooAble1 extends Able {
    def getname() : String =
      {
        "Here is a foo"
      }
}

trait BarAble1 extends Able {

    def getname() : String  = "Here is a bar"

}

trait PrintAble {
  val able : Able
  //val printable : PrintAble
  //val pp : printable.type
  import able._
  def print() = {
    println(getname())
    val s = getname()
    s
  }

}

case class Animal (name : String)

class Dog extends PrintAble {
  override val able = new FooAble1
}

object RealWorldCode extends App {

  val dog = new Dog
  println(dog.print())

}
