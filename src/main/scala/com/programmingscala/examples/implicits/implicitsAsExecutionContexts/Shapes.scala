package com.programmingscala.examples.implicits.implicitsAsExecutionContexts

case class Point(x : Double = 0.0, y : Double = 0.0)

//abstract
class Shape {

  def draw(f : String => Unit) = f(s"draw : = ${this.toString}")

}

case class Triangle (pointOne : Point, pointTwo : Point, pointThree : Point) extends Shape

case class Circle (center : Point, radius : Double) extends Shape

case class Rectangle(lowerLeft : Point, height : Double, width : Double)

object Test extends App {
  val s = (a : String) => println(a)

  val s1 = new Shape

  s1.draw(s)
}