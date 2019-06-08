package com.programmingscala.examples.types.value.types

object FunctionTypes {

  //It is common to refer to FunctionN trait to be mentioned like this
  val f1 : Function2[Int, Double, String] = (i,d) => (i + d).toString

  //The same can be written as
  val f2 : (Int, Double) => String = (i : Int, d : Double) => (i + d).toString

}
