package com.scalaCookbook.examples.Collections

object CreatingARange extends App {

  //Creating a Range of List
  val l = List.range(1,10)

  //Creating a Range of Array
  val a = Array.range(1,10)

  //Creating a Range of Vector
  val v = Vector.range(1,10)

  //Mostly we can use the to____ methods to create ranges

  val arr = (1 to 10).toArray

  //The available methods for a range are
  //toArray   toBuffer   toIndexedSeq   toIterable   toIterator   toList   toMap   toParArray
  // toSeq   toSet   toStream   toString   toTraversable   toVector

  val vec = (1 to 10).toVector

  val seq = (1 to 10).toSeq

  val q = (1 to 10).by(2).toList

  q.foreach(println)


  //create a list of alphabets
  val alphabets = ('a' to 'g').by(2).toList

  alphabets.foreach(println)

  //Mapping a range
  val doubleVectors = (1 to 10).toVector.map(x => x * 1.00)

  doubleVectors.foreach(println)

  val tuple = (1 to 10).map(x => (x, x + 1))

  tuple.foreach(println)

  val myMap = tuple.toMap

  myMap.foreach(x => println(s"key = ${x._1} and values = ${x._2}"))

}
