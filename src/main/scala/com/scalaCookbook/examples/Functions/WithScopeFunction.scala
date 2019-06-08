package com.scalaCookbook.examples.Functions

import scala.reflect.runtime.universe._

object WithScopeFunction {
  def withScope(func: => String) = {
    println("withscope")
    println("is Executing bar ..." + func.getClass)
    println(typeOf[Option[_]])
    func
  }

  def bar(foo: String) = withScope {
    println("Bar: " + foo)
    "BBBB"
  }

  def helloName (name : String) = withScope {
    val string = "Hello " + name
    string
  }

  //the whole thing in bar is sent as a function to withScope
  //{
  // println("Bar: " + foo)
  // "BBBB"
  // }

  def main(args: Array[String]): Unit = {
    println(bar("AAAA"));

    println(helloName("Srinivas"))
  }
}
