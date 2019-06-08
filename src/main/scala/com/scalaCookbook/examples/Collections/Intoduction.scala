package com.scalaCookbook.examples.Collections

object Intoduction extends App {

  //Three terms to get us up to speed
  //1. Predicate - A function or anomyous function that takes one or more parameters and gives a Boolean
  //Example
  def isEven (x: Int) = if (x % 2 == 0) true else false

  //2. Anonymous functions is nothing but a function literal
  val anoIsEven = (x : Int) => if (x % 2 == 0) true else false
  //In the above example, this part is  function literal (x : Int) => if (x % 2 == 0) true else false
  //even this part is (x : Int) => (x % 2 == 0), this can then be consisely written as (x : Int) => (_ % 2 == 0)


  //3. Implied loops
  val list = 1 to 10
  list.filter(x => x % 2 == 0)
  //There is a loop within this filter function that iterates through all the items in list

  val output = for {
    c <- list
    if (c % 2 == 0)
  } yield c

  output.foreach(println)

  //Collection methods like filter, foreach, map, reduceLeft, and many more have loops built into their algorithms.
  // As a result, you’ll write far fewer loops when writing Scala code than with another language like Java.
}
