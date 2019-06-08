package com.scalaCookbook.examples.Collections

import scala.collection.immutable.ListMap
import scala.collection.mutable

object SortingAMap extends App {

  val grades = Map("Kim" -> 95, "Melinda" -> 80, "Melissa" -> 70, "Amanda" -> 100, "Roger" -> 30)

  //Sorting a map will be done by the following steps
  // 1. Convert it into a Seq
  // 2. sort with SortWtih or Sortby
  // 3. Convert it back to a ListMap or LinkedhashMap

  //Using sortBy
  val gradesSortByNamesListMap = ListMap(grades.toSeq.sortBy(_._1) :_*)

  gradesSortByNamesListMap.foreach(println)

  val gradesSortByNamesLinked = mutable.LinkedHashMap(grades.toSeq.sortBy(_._1): _*)

  gradesSortByNamesLinked.foreach(println)

  val gradesSortByMarks = ListMap(grades.toSeq.sortBy(_._2) :_*)

  gradesSortByMarks.foreach(println)

  //Using sortWith
  val gradesSortByNamesDesc = ListMap(grades.toSeq.sortWith(_._2 < _._2): _*)

  gradesSortByNamesDesc.foreach(println)



  //About the : _* we are just telling ListMap that this is a type of a lot of items
  val x = grades.toSeq.sortBy(_._2)

  val listMap = ListMap(x : _*)

  //Let's take another example of it's usage

  def printAll(string: String*) = {
    string.foreach(println)
  }

  val fruits = Array("apple","banana","grape","watermelon")


  //In order to use this

  //printAll(fruits) //will not work, because printAll takes a list of strings not string
  printAll(fruits : _*)   //THis is the correct way to pass an array of strings to a function that expects multiple strings

  //Finding the largest value in a map

  val grades1 = Map("Al" -> 80, "Kim" -> 95, "Teri" -> 85, "Julia" -> 90)

  //Using iterators
  val maxName = grades1.keysIterator.max
  println(maxName)

  val maxMarks = grades1.valuesIterator.max
  println(maxMarks)

  //Using Keys and reduceLeft
  val maxName1 = grades1.keys.reduceLeft((x,y) => if (x > y) x else y )
  println(maxName1)

  val maxmarks1 = grades1.values.reduceLeft((x,y) => if (x > y) x else y)
  println(maxmarks1)
}
