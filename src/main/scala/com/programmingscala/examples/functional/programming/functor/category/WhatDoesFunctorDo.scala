package com.programmingscala.examples.functional.programming.functor.category



object WhatDoesFunctorDo extends App {

  //Let's create our own version of map method for a Seq
  def map1[A,B](seq : Seq[A])(fn : A => B) : Seq[B] = seq map fn

  //Let's use it to create a partial function

  val f1 = (i : Int) => i * 100
  val list = List(1,2,3,4)

  println(map1(list)(f1))


  def map2[A,B](fn : A => B)(seq : Seq[A]) : Seq[B] = seq map fn
val fnOutput = map2(f1) _

  println(fnOutput)
  //The type of fnOutput is Seq[Int] => Seq[Int]

  //So this means that the output is lifted to use Seq
  //Put another way, Functor allows us to apply a pure function (f: A => B) to a “context”
  // holding one or more A values. We don’t have to extract those values ourselves to apply f, then put the results
  // into a new instance of the “context.”


}
