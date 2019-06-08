package com.programmingscala.examples.patternmatching

object partialFunction extends App {

  case class Person(name : String)

  //simple pattern matching example
  val pf1 : PartialFunction[Any, String] = { case s : String => "Yes" }
  val pf2 : PartialFunction[Any, String] = { case s : Double => "Yes" }

  val pf = pf1 orElse pf2

  def tryPF(x : Any, f : PartialFunction[Any, String]) = {
    try{ f(x).toString } catch {case _ : MatchError => "Error" }
  }

  def d(x : Any, f : PartialFunction[Any, String]) = {
    f.isDefinedAt(x).toString
  }

  println(tryPF("100", pf))

  println(tryPF(Person("Srinivas"), pf))

  println(d("100", pf))

  println(d(Person("Srinivas"), pf))
}
