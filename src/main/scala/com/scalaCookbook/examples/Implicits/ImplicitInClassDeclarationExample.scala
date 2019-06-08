package com.scalaCookbook.examples.Implicits

//They are used to write rich wrapper classes in Scala
case class MyRectangle(width : Int, height : Int)



object RectangleImplicits {
  implicit class RectangleMaker(width : Int) {
    def x(height : Int) = new MyRectangle(width, height)
  }

  implicit class SimpleCalculations(a : Int) {
    def plus(b : Int) = a + b
    def minus(b : Int) = a - b
    def multiply(b : Int) = a * b
  }
}

object Test extends App {
  import RectangleImplicits._

  val output = 3 x(4)
  //The class RectangleMaker is automatically called with 3 and

  println(output)

  //Even here with 10 SimpleCalculations is already instantiated
  val output1 = 10 plus(5)

  println(output1)

  val output3 = 10 multiply(20)
  println(output3)


}
