package com.scalaCookbook.examples.Collections

import scala.collection.mutable

object Maps extends App {
  //Creating an immutable Map
  val map = Map("Al" -> "Alabama", "Ak" -> "Alaska")

  //In Predef, we have the following types
  //type[A, +B] = immutable.Map[A, B]
  //val Map = immutable.Map

  //Creating a mutableMap
  val mmap = scala.collection.mutable.Map("Al" -> "Alabama")
  mmap += ("Ak" -> "Alaska")

  println(mmap)

  //A map can also be mentioned as a Tuple
  val states = Map(("Al","Alabama"),("Ak" -> "Alaska"))

  println(states)

  //Giving an alternate name for a Mutable Map like this mutable.{Map => MMap}
  import scala.collection.mutable.{Map => MMap}

  val m = MMap("Al" -> "Alaska")
  m += ("Ca" -> "California")

  for ((k,v) <- m)
    {
      println(s"(k,v) => $k  $v")
    }

  //Sorted Map - will sort the keys in the map
  import scala.collection.immutable.SortedMap

  println("Sorted Map")
  val sortedMap = SortedMap("Srinivas" -> 1
  ,"Kirthika" -> 2
  ,"Alaska" -> 3
  ,"Sadhiv" -> 4
  ,"Sadhiv" -> 5)

  //The output will be as it is inserted into the map
  sortedMap.foreach{ case(k,v) => println (k,v ) }

  println("List Map -- LIFO")
  val listMap = mutable.ListMap[String, Int]()
  listMap += ("Srinivas" -> 1)
  listMap += ("Kirthika" -> 2)
  listMap += ("Alaska" -> 2)

  listMap.foreach{ case(k,v) => println(k + "  " + v)}


  println("linked hash Map -- FIFO")
  val linkedHashMap = mutable.LinkedHashMap[String, Int]()
  linkedHashMap += ("Srinivas" -> 1)
  linkedHashMap += ("Kirthika" -> 2)
  linkedHashMap += ("Alaska" -> 2)

  linkedHashMap.foreach{ case(k,v) => println(k + "  " + v)}
}
