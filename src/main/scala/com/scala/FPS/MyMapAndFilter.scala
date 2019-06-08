package com.scala.FPS


object MyMapAndFilter extends App {

  def doubleOnInt(i : Int) : Int = i * 2


  def myMap[A,B](f : (A) => B, list : List[A]) : List[B] = {
    for (i <- list) yield f(i)
  }

  println(myMap(doubleOnInt, List(1,2,3)))

  def evensonInt(i : Int) : Boolean = if (i % 2 == 0) true else false
  def evensonDouble(i : Double) : Boolean = if (i % 2 == 0) true else false

  println(List(1,2,3).filter(evensonInt))

  def myFilter[A](p: (A) => Boolean, list : List[A]) : List[A] = {
    val result = for (i <- list) yield if (p(i) == true) Some(i) else None
    val output = result.flatten
    output
  }

  println(myFilter(evensonInt, List(1,2,3,4)))
  val doubleList : List[Double] = List(1.0, 2.0, 3.0, 4.0)

  println(myFilter(evensonDouble, doubleList))

}
