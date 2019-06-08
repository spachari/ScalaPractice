package com.programmingscala.examples.types.selfrecursive

//TYpe members of type parameters cannot be inferred

object Example extends App {

  trait AType {
    type B
  }

  case object Foo extends AType {
    type AType = B
  }

  def fooAll[A <: AType](a : A, b : A#B) = ???

  //fooAll(Foo, 5) Does nto compile

  def fooAll2[A <: AType](a : A) (b : A#B) = ???

  //fooAll2(Foo)(5)

  def foo[A <: AType](a : A) = println(a)

  foo(Foo)
}

