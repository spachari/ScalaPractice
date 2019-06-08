package com.scalaCookbook.examples.Collections

object CreatingMultiDimensionalArray extends App {

  val row = 2
  val col = 3
  //Creating a multiDimension array
  val multiArray = Array.ofDim[String](row, col)

  multiArray(0)(0) = "a"
  multiArray(0)(1) = "b"
  multiArray(0)(2) = "c"
  multiArray(1)(0) = "d"
  multiArray(1)(1) = "e"
  multiArray(1)(2) = "f"

  println(multiArray(0)(0))

  for (x <- 0 until row;
       y <- 0 until col)
  {
    println(s"(${x})(${y}) " + multiArray(x)(y))
  }

  //To create an array of multidimensions we can use
  val x1,y1,z1 = 10
  val multiDimArray = Array.ofDim[Int](x1,y1,z1)

  var a = 0
  //Setting values for the array
  for (x <- 0 until x1;
       y <- 0 until y1;
       z <- 0 until z1)
    {
      multiDimArray(x)(y)(z) = a
      a += 1
    }

  //Viewing them
  for (x <- 0 until x1;
       y <- 0 until y1;
       z <- 0 until z1)
    {
      println(s"(${x})(${y})(${z})" + multiDimArray(x)(y)(z))
    }

  //Creating a multi dimensional arrays

  var array = Array(Array(1,2,3),Array(1,2))

  array(0).foreach(println)

  array ++= Array(Array(1,2,3,4,5,6,7))

  array.foreach(println)

}
