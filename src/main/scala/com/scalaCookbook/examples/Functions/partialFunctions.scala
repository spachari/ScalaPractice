package com.scalaCookbook.examples.Functions

//Used to control the functions only to run for a particular set of inputs
//A partial function is a function that does not provide an answer for every possible input value it can be given.
// It provides an answer only for a subset of possible data, and defines the data it can handle.
// In Scala, a partial function can also be queried to determine if it can handle a particular value.
object partialFunctions extends App {

  //Example1
  def divide (i : Int) = 42 / i

  //This will blow if we execute it for 0

  //We can write a check to see if it will work for 0
  def divide1 = new PartialFunction[Int, Int] {
    def isDefinedAt(x: Int): Boolean = x != 0

    def apply(i: Int): Int = 42 / i
  }

  println(divide1.isDefinedAt(0)) //Will return true
  println(divide1.isDefinedAt(20)) //Will return false


  //We can use it like that
  def divideIfNotZero (x : Int) =
    {
      if (divide1.isDefinedAt(x) == true)
       divide1.apply(x)
      else
       println("Cannot divide by " + x)
    }
  println(divideIfNotZero(0))
  println(divideIfNotZero(34))

  //effectively write case classes with guards in them to check out input but we can still do all out checks
  val divide2: PartialFunction[Int, Int] = {
    case d: Int if d != 0 => 42 / d
  }


  println(divide2.isDefinedAt(0)) //Will return true
  println(divide2.isDefinedAt(20)) //Will return false


  //We can use it like that
  def divide2IfNotZero (x : Int) =
  {
    if (divide2.isDefinedAt(x) == true)
      divide2.apply(x)
    else
      println("Cannot divide by " + x)
  }
  println(divide2IfNotZero(0))
  println(divide2IfNotZero(34))

  //The syntax of PartialFunction is
  //trait PartialFunction[-A, +B] extends (A) => B
  //(A) => B ---- This function () will transform A to B

  val convertNumToStringOneToFive = new PartialFunction[Int, String] {
    val nums = Array("one", "two", "three", "four", "five")
    override def isDefinedAt(x: Int): Boolean = x >= 0 && x <= 5
    override def apply(x : Int) : String = nums(x - 1)
  }

  println(convertNumToStringOneToFive.isDefinedAt(10))
  println(convertNumToStringOneToFive.isDefinedAt(3))
  println(convertNumToStringOneToFive.apply(3))

  val convertNumToStringSixToTen = new PartialFunction[Int, String] {
    val nums = Array("Six", "Seven", "Eigth", "Nine", "Ten")

    override def isDefinedAt(x: Int): Boolean = x >= 6 && x <= 10

    override def apply(v1: Int): String = nums(v1)
  }

  //We can use orElse and andThen to chain PartialFunctions together. They come along with PartialFunctions trait
  val handle10 = convertNumToStringOneToFive orElse(convertNumToStringSixToTen)

  println(handle10(4))

  //PartialFunctions are very important to understand because it is used in a lot of under the hood calculations
  //collect function uses partial function
  val list = 0 to 3
  val output = list.collect(divide1)

  output.foreach(println) //Will ignore 0 because it did not meet the isDefinedAt and then execute it only for the rest of them

  //Similarly if we have a List of multiple elements, collect has the ability to use the isDefinedAt and then apply
  //the methods to each element. Partial functions can be used with collect
  val list1 = List(43, "String")
  val output1 = list1.collect{ case i : Int => i / 2 }
  output1.foreach(println)

  val isEven :PartialFunction[Int, String] = {
    case i if i % 2 == 0 => i + " is even"
  }

  val sample = 1 to 5

  sample.collect(isEven).foreach(println)

  val isOdd = new PartialFunction[Int, String] {
    override def isDefinedAt (x : Int) = x % 2 != 0

    override def apply(v1: Int): String = v1 + " is odd"
  }

  val sample2 = 1 to 10

  val handleTill10 = isEven orElse isOdd
  sample2.collect(handleTill10).foreach(println)
}
