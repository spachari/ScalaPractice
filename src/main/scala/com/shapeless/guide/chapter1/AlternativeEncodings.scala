package com.shapeless.guide.chapter1

//There is one more way of doing the same Shape example


object AlternativeEncodings extends App {
  type Rectangle2 = (Double, Double)
  type Circle2 = Double
  type Shape2 = Either[Rectangle2, Circle2]

  val rect2 : Shape2 = Left((1.0, 2.0))
  val circle2 : Shape2 = Right(1.5)

  def area2(shape : Shape2) = {
    shape match {
      case Left((x, y)) => x * y
      case Right(x) => math.Pi * x * x
    }
  }

  //In theory, Shape2 is more generic than Shape because any (Double, Double) will work on area2 method
  //Shapeless is all about removing the solidness between case classes and generalising them


  println(area2(rect2))

  println(area2(circle2))

}
