package com.programmingscala.examples.functional.programming.monad.category.theory

//In scala a Monad is simply a concept that has the following functions

trait M[A] {
  def flatMap[B](x : A => M[A]) : M[B]
}

object M {
  def unit[A](a : A) : M[A] = ???
}

//List, Option, Seq are just a few examples of Monad
//From the above two we can make a map
//m map g = flatmap(x => unit(g(x)))

//They also need to follow these laws
//1. left-identity law
// unit(x).flatMap(f) == f(x)

//2. right-identity law
// m.flatMap(unit) == m

//associativity-law
//m.flatMap(f).flatmap(g) == m.flatMap(x => f(x).flatMap(g))

class MonadTheory {



}
