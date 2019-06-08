package com.programmingscala.examples.patternmatching

object PatternMatchingOnIndexes extends App {

  val stationery = Map(("pencil box", 1.52),("rubber", 2.4),("ball point pen", 3.6))

  val stationaryWithIndex = stationery.zipWithIndex

  stationaryWithIndex.foreach(println)

  for (s <- stationaryWithIndex) {
    s match {
      case ((item, amount), index) => println(s"Price of ${item} is ${amount} and it's index is ${index}")
      case _ => println("Not sure about what we want")
    }
  }

}
