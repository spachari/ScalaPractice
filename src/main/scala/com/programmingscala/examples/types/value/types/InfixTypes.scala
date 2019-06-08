package com.programmingscala.examples.types.value.types

object InfixTypes extends App {

  val left1 : Either[String, Int] = Left("Srinivas")
  val left2 : String Either Int = Left("Srinivas")
  val right1 : Either[String,Int] = Right(10)
  val righ21 : String Either Int = Right(10)

  //Some complicated infix types
  val leftofleft1 : Either[String,Either[String,Int]] = Right(Right(10))
  val rightOfRight : String Either (Int Either String) = Right(Right("Srinivas"))
  val leftOfLeft : String Either (Int Either String) = Right(Left(10))


}
