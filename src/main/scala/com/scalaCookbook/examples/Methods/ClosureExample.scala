package com.scalaCookbook.examples.Methods

class Foo1 {

  var age = 21
  def foo (f: (String) => Unit)(x : String) = { f(x) }


  //Passing Print Result around as a utility
  def printResult (f : (Int) => Boolean)(x : Int) ={
    println(f(x))
  }


  def buyStuff (f: (String) => Unit)(s : String) = {
    f(s)
  }
}
