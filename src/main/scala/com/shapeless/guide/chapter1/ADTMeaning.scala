package com.shapeless.guide.chapter1

//Basically ADTs are just a idiomatic way of mentioning "and" and "or".
sealed trait Shape
case class Rectangle(width : Double, height : Double) extends Shape
case class Circle(radius : Double) extends Shape

//here we can say the following
//1. A Shape is a Rectangle "or" a Circle
//2. A Rectangle has a width "and" a height
//3. A Circle has a "radius"

//This helps is to do the following

object ADTMeaning extends App {

  val circle = new Circle(2.1)
  val rectangle = new Rectangle(1.0, 2.0)

  //we can also do things like

  def calculateArea (shape : Shape) = shape match {
    case Circle(r) => math.Pi * r * r
    case Rectangle(width, height) => width * height
  }

  println(calculateArea(circle))
  println(calculateArea(rectangle))


}
