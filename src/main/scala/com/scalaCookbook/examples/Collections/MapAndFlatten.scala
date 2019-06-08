package com.scalaCookbook.examples.Collections

object MapAndFlatten extends App {

  //map function is used to transform one collection to anther. It is the same as for/yield construct
  //It will also give the same type of collection it is passed to
  val fruits = Vector("apple", "banana", "grape")

  val fruitsLenght = fruits.map(_.length)
  println(fruitsLenght)

  //Very useful when you want to convert data into xml or otehr types
  val xmlList = fruits.map(fruit => <li>fruit</li>)

  xmlList.foreach(println)

  //When our algorithm gets bigger, we can always create a function and map it to the name of the function
  def getnextCharFunction (sequence : String) = {
    //val line = sequence.mkString(",")
    //val arr = line.split("")
    val c = for (c <- sequence) yield {
     val z = c
    }
    sequence
  }



  //Calling a miulti line function from map
  val output = fruits.map(getnextCharFunction)

  output.foreach(println)

  //Spliting a string into pieces. Split will create an array of strings. we can them use map on them
  val a = "THis will"

  val words = a.split(" ")

  a.foreach(println)

  val x = "hello world".split(" ")

  x.foreach(println)

  //Flatten - Used to flatten list of Lists
  val list = List(List(1,2), List(3,4), List(5))

  val flatList = list.flatten

  flatList.map(print)
  println()

  val adamsFriends = List("Adam", "Mick", "Macca", "Steve")
  val rogersFriends = List("Adam", "Peter", "Fred", "Steve")

  val totalFriends = List(adamsFriends,rogersFriends)
  val friendsOutput = totalFriends.flatten.distinct.sorted

  friendsOutput.foreach(println)

  //Flatten is very useful when we use Options

  val optionList = List(Some(1),None,Some("Srinivas"), None, Some('a'))

  val flatOptList = optionList.flatten

  flatOptList.foreach(println)

}
