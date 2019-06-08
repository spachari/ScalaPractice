package com.scalaCookbook.examples.Collections

import scala.collection.mutable.ListBuffer

object Lists extends App {

  //Different ways to create a list (mutable)
  //Remember we need to use list only when we need to use head, tail operations, because it is implemented as a Linked list.
  //Best use Vector for longer implementations
  val list = 1 :: 2 :: 3 :: Nil

  val list1 = List(1,2,3)

  val listDOuble = List(1, 400D, 400L)

  val listNumber : List[Number] = List(1, 1.0, 400D, 33L)

  val listRange = List.range(1,20)

  val listFill = List.fill(3)("foo")

  for(c <- listFill)
    println(c)

  val listTabulate = List.tabulate(4)(x => x * 5)

  listTabulate.foreach(println)

  val listFromListBuffer = scala.collection.mutable.ListBuffer(1,2,3,4).toList

  "foo".toList

  val list4 = List(1,2,3,4)

  val list5 = 5 :: list4

  val list6 = 6 :: list5

  val list7 = 8 +: list6

  val list9 = list7 :+ 9

  list9.foreach(println)


  //Creating a ListBuffer (mutable)

  val fruits : ListBuffer[String] = ListBuffer()


  fruits += "apple"
  fruits += "Banana"
  fruits += "grape"

  for (f <- fruits)
    {
      println(f)
    }

  fruits -= "grape"
  fruits -= "banana"

  for (f <- fruits)
  {
    println(f)
  }

  val veges = List("potato","tomato","carrot")

  val total = fruits ++ veges

  for (f <- total)
  {
    println(f)
  }
  val finalL = total.toList

  //Deleting from a immutable list if by creating a filter and assiging the resutls to a new list

  val list10 = List.range(1,10)

  val list11 = list10.filter(x => x % 2 == 0)

  list11.foreach(println)

  //Deleting from a mutable list

  val listMutable = scala.collection.mutable.ListBuffer(1,2,3,4,5,6,7,8,9,9,10)

  listMutable -= 1

  listMutable -= 2

  listMutable --= Seq(3,4,5)

  listMutable.remove(0)

  listMutable.remove(1,2)

  listMutable.foreach(println)

  listMutable.remove(1,2)

  listMutable.foreach(println)


  //Merging two lists

  val list1to5 = List.range(1,5)
  val list5to10 = List.range(5,10)

  val finalOutput = list1to5 ++ list5to10

  val finalOutput1 = list1to5 ::: list5to10


}
