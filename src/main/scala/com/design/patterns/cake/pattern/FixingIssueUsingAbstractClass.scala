package com.design.patterns.cake.pattern

object FixingIssueUsingAbstractClass extends App {

  abstract class BarUsingFooAbleAbs {
    val bar = "bar calls foo " + foo.foo()
    def foo: FooAble
  }

  //Use the above

  val fooAble = new FooAble {}

  val barWithFooAbs = new BarUsingFooAbleAbs {
    override def foo: FooAble = fooAble
  }

  //Let's try abstract class then
  //Here  we create a method that gets a foo and uses in the abstract class

  println(barWithFooAbs.bar)

}
