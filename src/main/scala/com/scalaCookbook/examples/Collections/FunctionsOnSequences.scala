package com.scalaCookbook.examples.Collections

object FunctionsOnSequences extends App {
  val x = List(15, 10, 5, 8, 20, 15)

  val y = x.groupBy(_ > 15) //Creates a map of two lists. One that matches the condition (key = true)
  // and one that does not matches the conditions (key = false)
  println(y)
  println(y(true))
  println(y(false))

  //partition, span and splitAt will create Tuple2 of sequences, sublists (same type as source) based on the predicates

  val y1 = x.partition(_ > 15) //Creates a list of lists. One that matches the conditios and one that does not
  println(y1._2)
  println(y1._1)

  val y2 = x.span(_ >= 10) //Creates a list of longest match of lists till the condition is met and the rest of the list
  println(y2._2)
  println(y2._1)

  val y3 = x.splitAt(4) //Splits the list at the given position
  println(y3._2)
  println(y3._1)

  val arr = (1 to 10).toList
  val y4 = arr.sliding(3) //creates a non-empty iterator with As shown, sliding works by passing a “sliding window”
  // over the original sequence, returning sequences of a length given by size.
  println("first time")
  y4.foreach(println)
  println("second time ... prints nothing")
  y4.foreach(println)

  val y5 = arr.sliding(3,3).toList
  y5.foreach(println)
  //sliding works by passing a “sliding window” over the original sequence, returning sequences of a length given by size.
  // The step parameter lets you skip over elements, as shown in the last two examples.


  //takes Tupes of two and zips them based on element
  val menAndWomen = List(("Srinivas", "Sada"), ("Kirthika", "Reka"), ("Sadhana", "Vicky"), ("Sadhiv", "Vignesh"))
  val  family = menAndWomen.unzip
  println(family)
  println(family._1)
  println(family._2)
  //zip is the opposite of unzip. Gets two list and matches based on the position
  val backToMembers = family._1 zip family._2
  println(backToMembers)

}
