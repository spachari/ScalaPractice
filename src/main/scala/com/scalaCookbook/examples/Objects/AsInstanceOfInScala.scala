package com.scalaCookbook.examples.Objects

import scala.language.implicitConversions

case class Fruits (name : String)

class ReadFile {

  var arrayBuffer = new scala.collection.mutable.ArrayBuffer[Fruits]



  def readFile = {
   val lines =  scala.io.Source.fromFile("/Users/spachari/scala-learning/Fruits.dat").getLines()

    //lines.foreach(println)

    val convertStringtoFruit = lines flatMap {
      case "1" | "2" | "9" | "0" => None
      case s : String => Some(new Fruits(s))
    }


    println("Printing  filtered")
    convertStringtoFruit.foreach(println)
  }

  def printArray = arrayBuffer.foreach(println)

  //println("Printing the array")
  //printArray

  //Will not work
  def checkInput (a : Any) = {
    if (a.asInstanceOf[Int] == true)
      println("Input is an Int")
    else if (a.asInstanceOf[Double] == true)
      println("Input is an Double")
    else if (a.asInstanceOf[String] == true)
      println("Input is an String")
    else if (a.asInstanceOf[Fruits] == true)
      println("Input is an Fruits")
  }

  def checkInputPattern (a : Any) = a match {
    case a : Int => println("Input is an Int")
    case a : Double => println("Input is an Double")
    case a : Fruits => println("Input is an Fruits")
    case _ =>
  }
}

object AsInstanceOfInScala extends App {
  val v = new ReadFile
  v.readFile


  implicit def toStr(i : Int) : String =
    {
      println("Using implicit function")
      val b = i.toString
      return b
    }

  implicit def toInt(i : Double) : Int =
  {
    println("Using implicit def")
    val b = i.toInt
    b
  }

  val myInt : Int = 1.7

  val int = 10
  //println(int.asInstanceOf[Double]) //Used to cast a variable to a class
  val double = 10.0
  println(double.asInstanceOf[Int])
 //println(int.asInstanceOf[String]) not working

  //We can write
  //val recognizer = cm.lookup("recognizer").asInstanceOf[Recognizer]

  //This is equivalent to in java
  //Recognizer recognizer = (Recognizer)cm.lookup("recognizer")

  //The asInstanceOf method is available in Any class, so it can be used everywhere

  val i = 10.0
  //println(v.checkInput(i)) does not work
  println(v.checkInputPattern(i))

  val a = new Fruits("Apple")
  println(a.getClass)

}
