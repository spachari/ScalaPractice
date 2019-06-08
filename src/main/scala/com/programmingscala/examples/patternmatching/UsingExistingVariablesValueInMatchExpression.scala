package com.programmingscala.examples.patternmatching

object UsingExistingVariablesValueInMatchExpression extends App {

  def checkY (y : Int) = {
    for {
      x <- Seq(99, 100, 101)
    } {
    val s = x match {
        case y => "found y"
        case i : Int => s"found ${i}"
      }
      println(s)
    }
  }

  checkY(100)

  //If we want to check for variables outside the match use back tics ``

  def checkY1 (y : Int) = {
    for {
      x <- Seq(99,100,101)
    }
      {
        val s = x match {
          case `y` => "found y"
          case i : Int => s"found ${x}"
        }
        println(s)
      }
  }

  checkY1(100)

}
