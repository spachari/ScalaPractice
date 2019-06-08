package com.scalaCookbook.examples.Collections

object Streams extends App {


  //Only difference is it will be very lazy and it will not create one until it's output is needed for a calculation
  val stream = 1 #:: 2 #:: Stream.empty

  //Repl Output
  //scala> val stream = 1 #:: 2 #:: Stream.empty
  //stream: scala.collection.immutable.Stream[Int] = Stream(1, ?)

  val stream1 = Stream.range(1,100000)
  //Even this will be the same
  //scala> val stream1 = Stream.range(1,100000)
  //stream1: scala.collection.immutable.Stream[Int] = Stream(1, ?)

  //Only when something is needed it will be created, til that point

  println(stream1(100))

}
