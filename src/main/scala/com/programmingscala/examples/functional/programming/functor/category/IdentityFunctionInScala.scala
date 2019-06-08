package com.programmingscala.examples.functional.programming.functor.category

object IdentityFunctionInScala extends App {

  //Identiy just returns the argument that has been passed to the function
  def squareIf(test : Boolean) = List(1,2,3,4).map( if (test == true) x => x * x else identity)

  println(squareIf(true))

  //Here it just passes back the values that were passed to the function
  println(squareIf(false))

}
