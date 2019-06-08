package com.neophytes.guide

class Test {
  def classVar = 1
}

object Test {
  var objVar = 0
}

object objectExample extends App {

  val i = new Test

  val j = Test
  j.objVar = j.objVar + 10

  val k = Test
  println(k.objVar)
}
