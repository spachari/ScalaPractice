package com.programmingscala.examples.patternmatching

object GuardsInCaseClass extends App {

  for (s <- Seq(1,2,3,4,5,6)) {
    s match {
      case xs if xs % 2 == 0 => println(s"${xs} is even")
      case _  => println(s"${s} is odd")
    }

  }

}
