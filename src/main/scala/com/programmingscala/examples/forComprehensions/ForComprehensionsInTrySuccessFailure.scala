package com.programmingscala.examples.forComprehensions

import scala.util.{Failure, Success, Try}

object ForComprehensionsInTrySuccessFailure extends App {

  def isPositive (i : Int) : Try[Int] = {
    if (i > 0) Success(i)
    else Failure(new AssertionError("Assertion failed"))
  }

  val output = for {
    i <- isPositive(1)
    j <- isPositive(i * 10)
    k <- isPositive(j * 2)
  } yield (i + j + k)

  println(output)

  val output1 = for {
    i <- isPositive(1)
    j <- isPositive(i * -7)
    k <- isPositive(j * 5)
  } yield (i + j + k)

  println(output1)


}
