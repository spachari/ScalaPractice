package com.programmingscala.examples.functionalprogramming

object PartialFunctionVsPartiallyAppliedFunction extends App {

  //Partial function
  //It is nothing but a function that will work for some cases.

  def inverse : PartialFunction[Double, Double] = {
    case d if d != 0.0 => 1.0 / d
  }

  println(inverse(1.0))
  println(inverse(3.0))

  //Will throw error
  //println(inverse(0.0))

  //partially applied function
  //A partially applied function is calling a function by not providing all argument lists, thereby resulting in a function
  //which should be called by providing the remaining arguments

  def greeting(greet : String)(firstName : String)(lastName : String) = {
    println(s"${greet} ${firstName} ${lastName}")
  }

  val hello = greeting("Hello ") _ //Note: however many brackets you have, you just add one _

  hello("Srinivas")("Pachari")

}
