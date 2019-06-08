package com.programmingscala.examples.memoization

object BasicExample extends App {

  val maps : Map[Int, Int] = Map.empty

  def costly_function(num : Int) = {
    if (maps.get(num) == None) {
      println(s"Computing ${num} ...")
      Thread.sleep(1000)
      val result = num * num
      maps ++: Map(num -> result)
      maps.foreach{ case (x,y) => println(x + " " + y)}
      result
    } else {
      maps.get(num)
    }
  }

  val first = costly_function(10)
  println(first)

  val second = costly_function(4)
  println(second)

  val third = costly_function(10)
  println(third)

  val fourth = costly_function(4)
  println(fourth)

  val map = Map(1 -> "a", 2 -> "b", 3 -> "c")
  map.foreach{ case (x,y) => println(x + " " + y)}

  Map(4 -> "d") ++ map

  map ++ Map(5 -> "e")

  Map(1 -> "a", 2 -> "b", 3 -> "c") ++ Map(5 -> "e")

  map.foreach{ case (x,y) => println(x + " " + y)}


}
