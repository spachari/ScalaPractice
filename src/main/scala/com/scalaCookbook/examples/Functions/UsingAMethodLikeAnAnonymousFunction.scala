package com.scalaCookbook.examples.Functions

object UsingAMethodLikeAnAnonymousFunction extends App {

  def modMethod (i : Int) : Boolean = i % 2 == 0
  //we can use it like modMethod(10)

  val valMethod : Int => Boolean = i => i % 2 == 0
  //we can use it like valMethod(10)

  val l = Range(1,10).toList
  println(l.map(modMethod))
  println(l.map(valMethod))

  //The obvious difference is that modMethod is a method defined in a class and valMethod is a function that
  //is an instance of Function1 trait that defines a function that takes 1 argument
}
