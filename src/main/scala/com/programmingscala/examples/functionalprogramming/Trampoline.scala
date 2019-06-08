package com.programmingscala.examples.functionalprogramming

import scala.util.control.TailCalls.TailRec
import scala.util.control.TailCalls._

object Trampolines extends App {

  def isOdd(xs : List[Int]) : TailRec[Boolean] = if (xs.isEmpty) done(true) else tailcall(isEven(xs))

  def isEven(xs : List[Int]) : TailRec[Boolean] = if (xs.isEmpty) done(true) else tailcall(isOdd(xs))

  for (i <- 1 to 5) {
    val even = isEven((1 to i).toList).result
    println(s"is ${i} even : \t $even")
  }

}
