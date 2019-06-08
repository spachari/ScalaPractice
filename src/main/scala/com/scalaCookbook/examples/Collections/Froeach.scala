package com.scalaCookbook.examples.Collections

object Foreach extends App {

  //Any function that returns nothing can be used in the foreach method
  val x = List(1,2,3,4,5,6)

  x.foreach(println)

  val printEven = (x : Int) => if (x % 2 == 0) println(x + " --- ")

  x.foreach(printEven)

  //Example 2
  def printChar(c : Char) = println(c)

  //You can use foreach eventhough the function takes a 1 argument
  "HAL".foreach(c => printChar(c))

  //Example 3
  var longWord = new StringBuilder

  "This is a Long String".split(" ").foreach{
    e => if (e.length >= 3) longWord.append(s" $e")
    else println("Cannot append " + e)
  }

  longWord.foreach(println)

  val m = Map("Srinivas" -> "Daddy", "Kirthika" -> "Mummy", "Sadhana" -> "Sister", "Sadhiv" -> "Brother")

  m.foreach(x => println(x._1 + " is "+ x._2))

  m.foreach{ case (person, role) => println(person + " is " + role)}

}
