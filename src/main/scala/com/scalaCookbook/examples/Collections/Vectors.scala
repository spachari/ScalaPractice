package com.scalaCookbook.examples.Collections

object Vectors extends App {

  //Vectors are the go-to when we want to use a collection that has index sequence for a immutable collection, it takes constant time to iterate
  //Creating a vector of 100000 numbers
  var v = Vector[Int]()
  val range = Range(1,10000000)
  for (c <- 1 to 10000000)
    {
      v = v :+ c
    }

  //Both will take constant time for retrieval
  println(v(9898989))
  println(v(9))

  //Note: This did not even work in  List

  //Adding two vectors
  val a = Vector(1,2,3)
  val b = Vector(4,5,6)
  val c = a ++ b
  c.foreach(println)

  //Adding element to a Vector
  var g = Vector('a','b','c','d')
  g :+ 'e'

  for (c <- g)
    {
      print (c + " - ")
    }
  println()
  //Update an element in Vector

  val d = g.updated(0,'z')
  for (c <- d)
  {
    print (c + " - ")
  }
  println()

}
