package com.programmingscala.examples.types.singleton.types

case object Foo {
  //type type = Foo //imagine that such a line exists
  override def toString: String = "Here is a Foo"
}


object SingletonObjectExample extends App {

  def getFoo (foo : Foo.type ) = { //So we can use Foo.type to refer to the object
    println(foo.toString)
  }

  getFoo(Foo)

}
