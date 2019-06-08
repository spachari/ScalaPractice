package com.programmingscala.examples.forComprehensions

object NestedForLoopsInForComprehension extends App {

  /*
  val output = for {
    i <- 1
    j <- 2
  } yield s"${1} - {2}"
  */

  //this will throw an error. It is the same reason as below

  /*
  val list = List(1,2,3,4)
  list.flatmap(x => x)
   */

  //THis way we can do nested loops in scala
  val output = for {
    i <- 1 to 3
    j <- 1 to 3
  } yield s"i = ${i}; j = ${j}"

  output.foreach(println)


}
