package com.programmingscala.examples

object UsingParanthesisToCallEmptyMethod extends App {

  val list = List(1,2,3,4,5,6)

  //Should be called from list.size only
  println(list.size)

  //THis is because the signature of size is
  //override def size = length

  //On the other hand we can call length for a string both ways
  val hello = "Hello"

  println(hello.length)
  println(hello.length())

  //because the signature is
  /*

 public int length() {
        return value.length;
    }

   */

  //THis is because the method is a java method
  //It’s because of Java interoperability that the rules are not consistent for the two cases where empty parentheses
  // are part of the definition or not. Scala would prefer that definition and usage remain consistent, but it’s more flexible
  // when the definition has empty parentheses, so that calling Java no-argument methods can be consistent with calling Scala
  // no-argument methods.

  //When the method performs side effects, parentheses are usually added, offering a small “caution signal” to the reader
  // that mutation might occur, requiring extra care. If you use the option -Xlint when you invoke scala or scalac, it will
  // issue a warning if you define a method with no parentheses that performs side effects (e.g., I/O). I’ve added that flag to
  // our SBT build.

  def isEven(i : Int) = if (i % 2 == 0) true else false

  //we can call them vis this way too

  list filter isEven foreach println

  //Another way of writing is
  list.filter(isEven).foreach(println)


}
