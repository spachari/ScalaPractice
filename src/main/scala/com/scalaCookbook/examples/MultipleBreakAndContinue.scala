package com.scalaCookbook.examples

import scala.util.control.Breaks

object MultipleBreakAndContinue extends App {

  val Inner = new Breaks
  val Outer = new Breaks

  Outer.breakable {
    for (i <- 1 to 5) {
      Inner.breakable {
        for (j <- 'a' to 'c')
          {
            if (i == 2 && j == 'c') Inner.break() else println(s"i = ${i} and j = ${j}")
            if (i == 4 && j == 'a') Outer.break()
          }
      }
    }
  }

}
