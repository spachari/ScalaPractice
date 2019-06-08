package com.design.patterns.cake.pattern


class BarWithFooConstructor(barWithFoo : FooAble with BarAble)
{
  val bar = barWithFoo.bar()
  val foo = barWithFoo.foo()
}

object PassingDependencyViaconstructor extends App {

  println(new BarWithFooConstructor(new FooAble with BarAble).bar)
  println(new BarWithFooConstructor(new FooAble with BarAble).foo)



}
