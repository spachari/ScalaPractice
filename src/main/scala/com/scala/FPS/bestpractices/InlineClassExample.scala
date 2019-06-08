package com.scala.FPS.bestpractices

class Test {

  var variable : Int = _

  @inline
  def doSomething = {
    variable = 100
  }

}

object InlineClassExample extends App {

  val t = new Test
  println(t.doSomething)
  println(t.variable)

}
