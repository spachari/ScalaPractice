package com.scalaCookbook.examples.Functions

object SplatOperatorUsages extends App {

  //Usage 1: We can pass multiple elements in a method, without using any collection
  val list = List("apple", "banana", "grapes")

  def printApples(fruits : String*) = {
    fruits.foreach(println)
  }

  printApples(list :_*)

  //Usage 2: In a map function where we will strip open a collection

  val mul2 : (Int) => (Int) = (x : Int) => x * 2

  //Using this in map
  val list1 = List(1,2,3,4)

  val output = List(list1.map(mul2) :_*) //Note : Since we are splatting it, we will need to put a collection on top of the operator

  output.foreach(println)

  //Different usages of map
  list.map(x => x * 2)

  list1.map(_.*(2))

  list1.map{case (x) => x * 2}

  List(list1.map(mul2) :_*)
}
