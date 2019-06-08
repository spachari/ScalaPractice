package com.scala.FPS

object ConvertNormalFunctionTOCurriedFunction extends App {

  def add (x : Int, y : Int) = x + y

  //Function is converted into curried function
  def addFunction = add _

  println(addFunction.isInstanceOf[Function2[_,_,_]])

  def addCurriedVersion(x : Int)(y : Int) = x + y

  def test = addCurriedVersion(_: Int)(_: Int)

  println(test.isInstanceOf[Function2[_,_,_]])

  //Use the curried method
  def addCurried = (add _).curried

  //Use curried function
  println(addCurried(1)(2))

  //Another simple example
  def wrap (prefix : String)(body : String)(suffix : String) = {
    println( prefix + body + suffix)
  }

  def wrapWithDiv = wrap("<div>")(_ : String)("</div>")

  wrapWithDiv("Srinivas")
  wrapWithDiv("Hello")

}
