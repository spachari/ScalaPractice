package com.programmingscala.examples.oopsInScala


sealed trait Status


// Use case objects when instances don’t actually carry any additional state information.
// These objects behave like “flags” indicating a state.
case object On extends Status
case object Off extends Status

object CaseObjects extends App {


  def switchStatus (i : Int) : Status = {
    if ( i >= 100) {
      On
    } else
      {
        Off
      }
  }

  println(switchStatus(10))
  println(switchStatus(1000))



  //Use it only when there is a





}
