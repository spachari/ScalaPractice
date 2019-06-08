package com.scalaCookbook.examples.Collections

object MergingSequences extends App {

  val x = scala.collection.mutable.ArrayBuffer(1,2,3)
  val y = Seq(4,5,6)

  //++= is used to merge a mutable sequence to a immutable sequence. We can use any sequence that implements TraversableOnce
  val z = x ++= y

  z.foreach(print)
  println()

  //++ used to merge two immutable Sequences
  val x1 = Array(1,2,3)
  val y1 = Array(4,5,6)

  val z1 = x1 ++ y1

  val a = Array(1,2,3,4,5,6)

  val b = Array(4,5,6,7,8)

  val c = a.intersect(b)

  c.foreach(print)
  println()

  val d = a.union(b)
  d.foreach(print)
  println()

  val e = a.diff(b)
  e.foreach(print)
  println()

  //Array.concat method
  val f = Array.concat(a,b)
  f.foreach(print)
  println()

  //Concating two lists
  val l = List(1,2,3)
  val m = List(4,5,6)
  val n = l ::: m
  n.foreach(print)
  println

  //Finding the elements that are in a but not b and b but not a
  val a1 = Array(1,2,3,11,4,12,4,5)
  val b1 = Array(6,7,4,5)

  val c1 = a1.diff(b1)
  c1.foreach(print)
  println
  //We can use -- to subtract two sets
  val d1 = b1.toSet -- a1.toSet
  d1.foreach(print)
  println


  val total = c1 ++ d1

  total.distinct.foreach(print)
  println

  //Merging two Sequential collectiosn with zip

  val husbands = List("Srinivas","Sada","Sidharth")
  val wives = List("Kirhtika","Reka","Richa")

  val couples = husbands zip wives

  for((husbands, wives) <- couples) {
    println(s"${husbands} and ${wives}")
  }

  val couplesMap = couples.toMap

  for (elem <- couplesMap) {
    println(elem)
  }

  val products = Array("breadsticks", "pizza", "soft drink")
  val prices = Array(4.00, 10.50, 2.55, 30.00)
  val amounts = products.zip(prices)

  amounts.foreach(println)


  val (k,h) = amounts.unzip
  //It is separated into two a tuple of individual arrays
  k.foreach(println)
  h.foreach(println)

}
