package com.scalaCookbook.examples.Collections

object ArrayBuffer extends App {
  //Use ArrayBuffer as the default collection for a mutable indexed sequence
  //Use ListBuffer as the default collection for an mutable linear sequence


  def printArray(a : Seq[Any])  = {
    for (c <- a)
      {
        print(c + " -- ")
      }
    println()
  }

  //Create an Array Buffer
  var a = scala.collection.mutable.ArrayBuffer[Int](1,2,3)

  //Adding a new element
  a = a += 4

  //Adding another Array
  a = a ++ Array(5,6)

  //Adding a List to the array
  a = a ++ List(7,8,9)


  //Removing an element from the array
  a = a -= 9

  //Removing an element from the array
  a = a -- List(7,8)

  a.foreach(println)

  //General ArrayBuffer methods
  var array = scala.collection.mutable.ArrayBuffer[Int](1,2,3,4,5,6)
  array.append(7,8)
  array.appendAll(Array(10,11,12))
  array.clear()

  var array1 = scala.collection.mutable.ArrayBuffer[Int](1,2,3,4)
  array1.insert(4,5)
  array1.insert(5,6,7,8)
  array1.insertAll(8, List(9,10,11)) //insert method will append to the back of the string,
  array1.foreach(println)

  def isFour(x: Int) = if (x == 4) true else false

  var array2 = array1.dropWhile(x => x == 4)

  var array3 = array1.filter(x => x == 4).foreach(print)

  println()

  printArray(array2)

  var array4 = scala.collection.mutable.ArrayBuffer[Int](4,5,6,7)

  array4.prepend(0,1,2,3)

  array4.prependAll(List(1,2,3))

  println("Printing array 4")
  printArray(array4)

  val array5 = scala.collection.mutable.ArrayBuffer.range('a', 'h')
  printArray(array5)

  array5.trimStart(2)
  array5.trimEnd(2)

  printArray(array5)

  //Append, update, and random access take constant time (amortized time). Prepends and removes are linear in the buffer size.”
  // The ArrayBuffer documentation also states, “array buffers are useful for efficiently
  // building up a large collection whenever the new items are always added to the end.”

  //If you need a mutable sequential collection that works more like a List (i.e., a linear sequence
  // rather than an indexed sequence), use ListBuffer instead of ArrayBuffer
}
