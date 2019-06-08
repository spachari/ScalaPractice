package com.scala.FPS

object Timer extends App {


  //We are passing any block of code here, not just an object
  def timer[A](blockOfCode: => A) = {
    val startTime = System.nanoTime()
    val result = blockOfCode    //This statement is executed each time it is called inside the function
    val endTime = System.nanoTime()
    val timeToExecute = endTime - startTime
    (result, timeToExecute/1000000d)
  }

  def openFile(s : String) = {
    val fileLines = scala.io.Source.fromFile(s).getLines().toList
    fileLines.length
  }

  //val result = timer(openFile("/Users/spachari/Desktop/Spark-learning/ml-10M100K/ratings.dat")) // we are passing lines of code directly

  //println(result._1 + " " + result._2)

  println(timer(println("hello")))


  def test[A](codeBlock: => A) = {
    println("before 1st codeblock")
    val a = codeBlock
    println(a)
    Thread.sleep(10)

    println("before 2nd codeblock")
    val b = codeBlock
    println(b)
    Thread.sleep(10)

    println("before 3rd codeblock")
    val c = codeBlock
    println(c)
    Thread.sleep(10)

  }

  def testbyname(a : => Int) = { //We can pass an Int also by name
    println(a)
    println(a)
  }

  def testByVal(f : (Int,Int) => Int, a : Int, b : => Int) = {
    f(a, b)
  }

  testbyname(10)

  test(println("Hello"))

  timer {  //directly using a block of code
    val list = List(1,2,3,4)
    val a = list.length
    println(a)
    a
  }

  //Simple difference between call-byname and call-by-value
  //blockOfCode: => A - call by name
  //f : (Int) => Int - Int

  //Simple difference between call-byname and call-by-value in a variable
  //i : => Int
  //i : Int


}
