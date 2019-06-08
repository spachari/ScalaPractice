package com.scalaCookbook.examples

case class PersonName(name : String) {

  //Inline is nothing but telling the compiler that you can have one function over the other

  @inline
  final def printHello = printMessage

  def printMessage = println("hello " + name)

  //THis will be converted into def printHello = println("hello " + name) by the JIT compiler, this si generally used for optimization purposes
  //It is always best to add it with final so that it will not be overridden

}

object InlineExample extends App {

  val p = PersonName("Srinivas")

  p.printHello

}
