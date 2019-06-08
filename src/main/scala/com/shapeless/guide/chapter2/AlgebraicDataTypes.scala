package com.shapeless.guide.chapter2

//Algebraic Data types are a fancy way of representing data wiht "and" or "or"s.

sealed trait Shape
final case class Rectangle(length : Double, breadth : Double) extends Shape
final case class Circle(raduis : Double) extends Shape

//All ADTs are trying to convey are
//1. A Shape is a Rectangle "or" a Circle
//2. A Rectangle has a width "and" height
//3. A Circle has a radius

//In ADT terminology, "and" types are called products and "or" types are called "co-products"
//In Scala, we use products using a case class and co-products using a sealed traits

object AlgebraicDataTypes extends App {


  //It helps us write the following code
  def area(shape : Shape) = {
    shape match {
      case x : Rectangle => x.length * x.breadth
      case x : Circle => math.Pi * x.raduis * x.raduis
    }
  }

  val rectangle = new Rectangle(2.0, 3.0)
  val circle = new Circle(4.0)

  println(area(rectangle))
  println(area(circle))


}
