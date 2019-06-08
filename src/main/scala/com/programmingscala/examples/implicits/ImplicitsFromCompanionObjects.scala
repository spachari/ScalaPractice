package com.programmingscala.examples.implicits


//Here in Foos case the one in object will be used
class Foo(s : String)

object Foo {
  implicit def fromString(s : String) = {
    println("Using implicit conversions ... ")
    new Foo(s)
  }
}

object implicits {

  //In this case the implicit in the outer level will be used
  class Foo1(s: String)

  implicit def overridingConversion(s: String) = {
    println("using overriding conversion")
    new Foo1(s"Boo + ${s}")
  }

  object Foo1 {
    implicit def fromString(s: String) = {
      println("Using implicit conversions ... ")
      new Foo1(s)
    }
  }

}

object ImplicitsFromCompanionObjects extends App {

  import implicits._

  def m(s : String) = m1(s)
  def m1(foo : Foo) = println(foo)

  def s(s : String) = s1(s)
  def s1(foo : Foo1) = println(foo)

  println(m("srinivas"))
  println(s("srinivas"))




}
