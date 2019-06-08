package com.programmingscala.examples.basics


//If a def does not have equals to sign after the declaration that means it gives an Unit.
//Usually used for side-effects like setting a global variable or something

object SignificanceOfEqualToSignInDef extends App {

  def double(x : Int) { println(x) }

  def willNotWork(x : Int) { x * 2}

  println(double(10))

  println(willNotWork(10))

}
