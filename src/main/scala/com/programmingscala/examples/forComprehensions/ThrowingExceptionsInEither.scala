package com.programmingscala.examples.forComprehensions

object ThrowingExceptionsInEither extends App {

  //Imagine we have a situation that will throw an error
  def addInts(s1 : String, s2 : String) = {
    s1.toInt + s2.toInt
  }

  for {
    i <- 1 to 3
    j <- i to 5
  } println(s"$i + $j = ${addInts(i.toString, j.toString)}")


  //What if we just want to throw an exception like this
  //addInts("0","x")

  //There are two issues in the code
  //1. It does not give any indication that there could be a failure
  //2. we cannot cache the values for future use

  //THis is where most people use Either

  def addInt(s1 : String, s2 : String) : Either[NumberFormatException, Int] = {
    try {
      Right(s1.toInt + s2.toInt)
    } catch {
      case e : NumberFormatException => Left(e)
    }
  }


  println(addInt("x","0"))
  println(addInt("1","2"))

}
