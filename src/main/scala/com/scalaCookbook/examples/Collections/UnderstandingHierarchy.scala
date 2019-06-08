package com.scalaCookbook.examples.Collections

object UnderstandingHierarchy {

  //1.                                      Traversable
  //The Traversable trait lets you traverse an entire collection, and its Scaladoc states that it
  // “implements the behavior common to all
  // collections in terms of a foreach method,” which lets you traverse the collection repeatedly.

  //2.                                      Iterable
  //The Iterable trait defines an iterator, which lets you loop through a collection’s elements one at a time,
  // but when using an iterator, the collection can
  // be traversed only once, because each element is consumed during the iteration process.

  //3a.                                     Seq
  //It is split into Index Seq and Linear Seq
  //4a.                                     Indexed Seq
  // An IndexedSeq indicates that random access of elements is efficient, such as accessing an Array
  // element as arr(5000). By default, specifying that you want an IndexedSeq with Scala 2.10.x creates a Vector:

  //IndexedSeq indecates that random access is efficient
  val a = Range(1,10)
  val array = a.toArray
  println(a(4))

  val v = Vector(1,2,3,4,5)
  println(v(4))

  //4b.                                     Linear Seq
  //A LinearSeq implies that the collection can be efficiently split into head and tail components, and it’s
  // common to work with them using the head, tail, and
  // isEmpty methods. Note that creating a LinearSeq creates a List, which is a singly linked list:
  val list = scala.collection.immutable.LinearSeq(1,2,3,4)
  println(list.head)
  println(list.tail)



  //3.b                                     Set
  //Like a Java Set, a Scala Set is a collection of unique elements. The common set classes are shown in
  val s = Set(1,2,3)
  s.foreach(println)




  //3.c                                     Map
  //Like a Java Map, Ruby Hash, or Python dictionary, a Scala Map is a collection of key/value pairs,
  // where all the keys must be unique.
  val m = Map(1 -> 'a', 2 -> 'b')


}
