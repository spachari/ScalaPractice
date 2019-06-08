package com.functional.data.structures

object CopyOnWriteLaziness extends App {

  val list = 1 to 10

  val output = list map (_ / 2) filter (_ > 0) partition(_ < 2)

  println(output)

  //During the filter stage one element is removed. But the element is not just removed from the input vector itself.
  //This solves the problem of a leaking getter.
  //As data structures are immutable, they can be freely shared among different threads of execution. THey are
  //Freely shared only for reading.

  //What happens when the data is large, there will be lot of copying, right?
  //No, there is a process called Structural sharing, so that most of the copying is avoided. It will create a new
  //object by adding the new element along with the known ones.

  //However immutability semantics are still preserved.

  //Deferred processing or lazy evaluation

  //A collection is lazy when all of it's elements are not realised on the time of it's creation, but when they are computed on demand.

  //Example

  val list1 = (1 to 100).toList.view

  def isDivisibleBy(d : Int)(n : Int) = {
    println(s"${n} is divisible by ${d}")
    n % d == 0
  }

  val by2 = isDivisibleBy(2) _
  val by3 = isDivisibleBy(3) _
  val by4 = isDivisibleBy(4) _
  val by5 = isDivisibleBy(5) _

  val result = list1 filter by2 filter by3 filter by4 filter by5
  //Note: Only when a check is passed it is passed to the next one

  println(result.force)
  //Note the force method. It forces the collection to a strict one.



}
