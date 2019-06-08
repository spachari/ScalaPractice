package com.shapeless.guide.chapter2



object ProductsAndCoProductsViaTypes {

  //products and co-products can also be created in scala by types
  type Rectancle2 = (Double, Double) //product
  type Circle2 = Double

  type Shape2 = Either[Rectancle2, Circle2] //co-product

  val rect : Shape2 = Left(2.0, 3.0)
  val circle : Shape2 = Right(4.0)
  //we can write methods like this too

  def area(shape : Shape2) = {
    shape match {
      case Left((w, h)) => w * h
      case Right(x) => math.Pi * x * x
    }
  }

  println(area(rect))
  println(area(circle))

}
