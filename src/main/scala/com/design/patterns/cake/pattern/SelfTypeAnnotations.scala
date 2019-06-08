package com.design.patterns.cake.pattern




object SelfTypeAnnotations extends App {

  //Let's use this with abstract methods and traits
  //Self type Annotations
  class BarWithFooAbleSelfType {
    myFoo : FooAble =>
    def bar() = "bar calls Foo " + foo()
  }

  val barWithFooAbleSelfType = new BarWithFooAbleSelfType with FooAble
  println(barWithFooAbleSelfType.bar())


}
