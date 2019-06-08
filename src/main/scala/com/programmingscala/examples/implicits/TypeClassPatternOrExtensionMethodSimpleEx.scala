package com.programmingscala.examples.implicits

object MyExtensions {
  implicit def richInt(i: Int) = new {
    def square = i * i
    def helloInt = "hello " + i
  }

  implicit class RichInt(val s : Int) {
    def hello (s : Int) = "This is a very royal " + s
  }
}


//All thse are extension methods for Integer
object TypeClassPatternOrExtensionMethodSimpleEx extends App {

  import MyExtensions._

  val two = 2
  println(two.square)
  println(two.helloInt)

  println(two.hello(2))
}
