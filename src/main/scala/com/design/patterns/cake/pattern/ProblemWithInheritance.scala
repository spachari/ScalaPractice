package com.design.patterns.cake.pattern

trait FooAble {
  def foo() = "Here is your foo"
}

class BarUsingFooAble extends FooAble {
  def bar() = "bar calls foo " + foo()
}



object ProblemWithInheritance extends App {

  val bar = new BarUsingFooAble
  println(bar.bar())

  //What is the problem? well, first, you are stuck with this specific FooAble, if you want something that extends /
  // implements FooAble you need to modify the class or create another one, but this is not exactly dependency injection,
  // the user of the dependency declares it specifically, it's not injected.

  //Let's try with when creating the isntance in the class
  /*
  class Bar {
    def bar() = "bar calls foo" + foo()
  }

  val barWithFoo = new Bar with FooAble
  */

  //The above will not compile





}
