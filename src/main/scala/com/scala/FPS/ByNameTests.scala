package com.scala.FPS

object ByNameTests extends App {

  var asserttionEnabled = true

  def myAssert(p : () => Boolean) = { //Higher order function - a function that can take a function as an input parameter
    if (asserttionEnabled && !p())
      throw new AssertionError()
  }

  myAssert(() => 5 > 3)

  def myAssertByName (predicate : => Boolean) = {
    if (asserttionEnabled && !predicate)
      throw new AssertionError()
  }

  myAssertByName(5 > 3)
  myAssertByName(if(100 < 2) true else false)

  //As we can see there is a small difference between the FIPs of both the functions
  //p : () => Boolean
  //predicate : => Boolean

  //and the way we call them
  //() => 5 > 3
  //5 > 3

}
