package com.scalaCookbook.examples.Collections

object ForYieldCombination extends App {

  val fruits = Traversable("apple","banana","grape")

  //Iterate through a collection
  for (c <- fruits) {
    val s = c.toUpperCase
    println(s)
  }

  //Iterate through the positions of a list
  val fruits1 = List("apple","banana","grape")

  for (c <- 0 until fruits.size)
    {
      println(s"Element $c is ${fruits1(c).toUpperCase()}")
    }

  //Using zip With Index

  println("Using zipWithIndex ... ")

  for ((index, fruits) <- fruits1.zipWithIndex)
    {
      println(s"Element ${index} is ${fruits}")
    }

  for ((index, fruits) <- fruits1.view.zipWithIndex)
  {
    println(s"Element ${index} is ${fruits}")
  }

  //Using zip with a stream
  for ((index, fruit) <- fruits1.zip(Stream from 100)) {
    println(s"Element ${index} is item ${fruit}")
  }


  //For doing something N times use to (Range)

  for (i <- 1 to 10)
    {
      println(s"${i} * 2 = ${i * 2}")
    }

  //for/yield is used to assign the output of a collection a new collection
  val capsFruits = for (c <- fruits) yield {
    c.toUpperCase
  }

  capsFruits.foreach(println)


  val days = Array("Sunday", "Monday", "Tuesday", "Wednesday","Thursday", "Friday", "Saturday")

  //zip with index
  for ((day,count) <- days.view.zipWithIndex)
    {
      println(s"${day} is ${count}'th of the week")
    }


  //Using Stream
  for ((day, count) <- days.zip(Stream from 1))
    {
      println(s"${day} is ${count}'th of the week")
    }

  //zipping two list with
  val list1 = List("Play footbal", "watch tele", "work overtime","blah blah"," go to temple", "drink with friends", "rest")
  for ((day, activity) <- days.zip(list1))
    {
      println(s"On ${day} we ${activity}")
    }

  //The thing we need to remember is, when it traverses through a collection, after it finishes processing a collection, it will mutate the
  //variable. It is used by scala when we read files. It is best for reading and removing the item after reading it
   val i = Iterator(1,2,3)
  println("printing first time")
  i.foreach(println)
  println("printing second time")
  i.foreach(println)


  //power of for/yield example
  val idList = List(1,2,3,4)
  val nameList = List("Mick","Scooby","Rocky","Elle")

  case class Dogs (id: Int, name : String)

  //print only the names that contain M
  val dogList = for ((id, name) <- idList.zip(nameList)) yield
    {
      val s = new Dogs(id, name)
      s
    }

  dogList.foreach(x => println(s"${x.id} is ${x.name}"))


  println("using guards in dogList ... ")
  //Using guards in the for comprehension
  val h = for (c <- dogList
               if c.name.contains("Mick")) {
    println(s"${c.id} is ${c.name}")
  }

  //Note: A for comprehension always returns the same type of collection that was passed to it
  println(days)

  val dayswithIndex = for (c <- days.zipWithIndex)
    {
      val s = c
      s
    }

}

