package com.scalaCookbook.examples.Generics

import scala.io.Source

object TimerFunction extends App {

  //This can run a block of code only when it is called and returns whatever the called function returns
  def timer[A](blockOfCode: => A) = {
    val startTime = System.nanoTime
    val result = blockOfCode
    val stopTime = System.nanoTime
    val delta = stopTime - startTime
    (result, delta/1000000d)
  }

  val (result, time) = timer(print("Hello"))

  println(s"The reuslt of the timer is ${result.getClass} and it took ${time}")

  def readFile = Source.fromFile("/Users/spachari/Desktop/Spark-learning/SparkScala/SparkScalaCode/book.txt").getLines()

  val (result1,time1) = timer(readFile)

  println(s"The reuslt of the timer is ${result1.getClass} and it took ${time1}")

}
