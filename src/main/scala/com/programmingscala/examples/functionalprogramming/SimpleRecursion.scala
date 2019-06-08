package com.programmingscala.examples.functionalprogramming

import scala.annotation.tailrec

object SimpleRecursion extends App {

  def factorial(int : Int) : Int = {
//The tail-call optimization won’t be applied when a method that calls itself might be overridden in a
// derived type. Hence, the recursive method must be defined with the private or final keyword, or it must be
// nested in another method.
    @tailrec
    def fact(i : Int, accumulator : Int) : Int = {
      if (i == 1) accumulator
      else
        fact(i - 1, i * accumulator)
    }

    fact(int,1)
  }

  //println(factorial(4))

  for(i <- 1 to 10)
    println(s"${i}\t${factorial(i)}")


}
