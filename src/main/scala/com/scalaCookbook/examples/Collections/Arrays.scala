package com.scalaCookbook.examples.Collections

object Arrays extends App {

  //Different ways to create an Array
  val array = Array(1,2,3,4)

  val array1  = Array[Number](1,2,3,30,40D,80L)

  val fruits = new Array[String](3)

  fruits(0) = "apple"
  fruits(1) = "banana"
  fruits(2) = "carrot"

  //Default value for an array is _

  val fruuits1 : Array[String] = new Array[String](2)

  fruuits1(0) = "srinivas"

  val array2 = Array(1,2,3)

  val array3 = Array(1,10,2)

  val array4 = Array.fill(3)("foo")

  val array5 = scala.collection.mutable.ArrayBuffer(1,2,3,4).toArray

  val arra6 = List(1,2,3).toArray

  "Hello".toArray

  //Arrays are mutable in the sense that we can change the elements of the array but not the size of a val array
  val arrayTest = Array(1,2,3)
  arrayTest(0) = 100
  arrayTest(1) = 200
  arrayTest(2) = 300

  arrayTest.foreach(println)

  //ArrayBuffer
  val arrayMutable = scala.collection.mutable.ArrayBuffer(1,2,3)

  arrayMutable += 4
  arrayMutable += 5

  arrayMutable ++= Array(10,11,12)



  arrayMutable.appendAll(Array(1,2,3,4,5))

  arrayMutable.append(100)

  arrayMutable.foreach(println)

  //Deleting array
  arrayMutable --= Array(10,11,12)

  arrayMutable.remove(0)

  arrayMutable.remove(1,2)

  arrayMutable --= Array(2,3,4)

  arrayMutable --= Seq(5,6,7)

  arrayMutable.foreach(println)

  //Sorting an array

  val fruits1 = Array("apple","banana","grape")

  fruits1.sorted

  fruits1.sortWith(_ > _)
  fruits1.sortWith(_ < _)
  fruits1.sortWith(_.length < _.length)


  scala.util.Sorting.quickSort(fruits)


}
