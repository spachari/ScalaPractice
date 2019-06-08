package com.programmingscala.examples.functionalprogramming

object LiftingAPartialFunctionToOption extends App {

  val partialFunc : PartialFunction[Double,Double] = {
    case d if (d != 0.0) => d / 1.0
  }

  println(partialFunc(1.0))

  //Will not owrk for this one
  //println(partialFunc(0.0))

  //We can lift the partial function to option

  val optOfPartialFn = partialFunc.lift

  println(partialFunc(1.0))
  println(optOfPartialFn(0.0))

  //But will not work for this one
  val partialFunc1 = PartialFunction[Double,Double] {
    case d if (d != 0.0) => d / 1.0
  }

  val unPartialFunc = Function.unlift(optOfPartialFn)

  println(unPartialFunc(1.0))
  println(unPartialFunc(0.0))


}
