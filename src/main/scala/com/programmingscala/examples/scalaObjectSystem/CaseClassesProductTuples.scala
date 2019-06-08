package com.programmingscala.examples.scalaObjectSystem

object CaseClassesProductTuples extends App {

  //Your case classes mix in the scala.Product trait, which provides a few generic methods for working
  // with the fields of an instance, a Person instance, for example:

  case class Persons  (name : String, age : Int)

  val p : Product = Persons("Srinivas", 37)

  val s = p.productIterator

  println("The elements in person are ")
  for (l <- s) {
    println(l)
  }

  println(p.productArity)

  println(p.productElement(0))

  println(p.productElement(1))

  println(p.productPrefix)

  //THese come from

  /*
  package scala
  trait Product2[+T1, +T2] extends Product {
    abstract def _1: T1
    abstract def _2: T2
      ...
  }
  */

  //The type parameters are covariant, because the ProductN traits are only
  // used with immutable types, where reading the field with a method like _1 uses the corresponding
  // type parameter, T1, in covariant position (i.e., only as a return type).
}
