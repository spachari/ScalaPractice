package com.scalaCookbook.examples.Collections

object ReducesAndFolds extends App {
  val arr = Array(12, 6, 15, 2, 20, 9)

  //Sum of the lists
  val output = arr.reduceLeft((x,y) => x + y)

  println(output)

  //THis can also be written by
  val greatest1 = arr.reduceLeft(_ + _)
  println(greatest1)

  //Explaining the reduceLeft functions
  val greatest = arr.reduceLeft((x,y) => if (x > y) x else y)
  println(greatest)

  def findGreater (x : Int, y : Int) = {
    val greater = if (x > y) x else y
    println(s"Checking ${x} and ${y}, the greatest is ${greater}")
    greater
  }

  val outputWithExplanation = arr.reduceLeft(findGreater)
  /*
  output is
  Checking 12 and 6, the greatest is 12
  Checking 12 and 15, the greatest is 15
  Checking 15 and 2, the greatest is 15
  Checking 15 and 20, the greatest is 20
  Checking 20 and 9, the greatest is 20
   */

  //This tells you that reduceLeft implements 1st two elements and get the output and then uses it against the 3rd element and so on

  val minimum = arr.reduceLeft(_ min _)

  val max = arr.reduceLeft(_ max _)

  println(minimum)
  println(max)

  val peeps = Vector("al", "hannah", "emily", "christina", "aleka")

  def getGreaterLength (s1 : String, s2 : String) = {
    if (s1.length >= s2.length) s1 else s2
  }

  val maxLengthName = peeps.reduceLeft(getGreaterLength)
  println(maxLengthName)

  println("Looking at folds .... ")
  //Folds are exactly the same as Reduces but it will give us an option to add a seed value
  //They take a seed value and compare them with all elements of the list
  val myGreatest = arr.foldLeft(100)(findGreater)

  val sumOfListPlus100 = arr.foldLeft(100)(_ + _)
  println(sumOfListPlus100)


  //The reason why we have two different functions is because some times it matters which order we operate from
  //For example
  def divide (x : Double, y : Double) = {
    val output = x / y
    println(s"dividing ${x} with ${y}")
    output
  }

  val doubleArray = Array(1.0, 2.0, 3.0, 4.0)
  val outputReduceLeft = doubleArray.reduceLeft(divide)
  val outputReduceRight = doubleArray.reduceRight(divide)

  println(outputReduceLeft)
  println(outputReduceRight)

  //ScanLeft and Scan Right - gives you a sequence instead of individual elements

  def summation (x : Int, y : Int) = {
    val output = x + y
    println(s"x = ${x} and y = ${y}  and output is ${output}")
    output
  }

  val scanSum = arr.scanLeft(0)(summation)

  /* Output is
  x = 0 and y = 12  and output is 12
  x = 12 and y = 6  and output is 18
  x = 18 and y = 15  and output is 33
  x = 33 and y = 2  and output is 35
  x = 35 and y = 20  and output is 55
  x = 55 and y = 9  and output is 64
   */

  scanSum.foreach(println)

  def findMax(x : Int, y : Int) = {
    Thread.sleep(10000)
    val output = if (x > y) x else y
    println(s"x = ${x} and y = ${y} and output = ${output}")
    output
  }

  val array1 = Range(1,30).toList

  array1.reduce(findMax)

}
