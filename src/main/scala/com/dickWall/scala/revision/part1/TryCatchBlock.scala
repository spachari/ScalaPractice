package com.dickWall.scala.revision.part1

object TryCatchBlock extends App {

  def divide(x : Int) = {

    val answer = try {
      10 / x
    }
    catch {
      case a : ArithmeticException => 0 //in scala "the rocket" => means when this happens do this
    } finally {
      println("This is the end of dividing answer by 10")
    }
    answer
  }

  println(divide(10))
  println(divide(0))
}
