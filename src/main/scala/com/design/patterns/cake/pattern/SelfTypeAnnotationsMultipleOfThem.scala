package com.design.patterns.cake.pattern


trait BarAble {
  def bar() =  "Here is your bar"
}

class FooWithBar {
  this :BarAble with FooAble =>
  bar()
  foo()
}
object SelfTypeAnnotationsMultipleOfThem extends App {

  val fooWithBar = new FooWithBar with FooAble with BarAble

  println(fooWithBar.bar())
  println(fooWithBar.foo())

}
