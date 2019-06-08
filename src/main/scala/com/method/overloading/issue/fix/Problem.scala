package com.method.overloading.issue.fix




object Problem {
  implicit def left2Either[A,B](a:A):Either[A,B] = Left(a)
  implicit def right2Either[A,B](b:B):Either[A,B] = Right(b)

  def foo(a: Either[Int, String], b: Int = 42) = a match {
    case Left(i) => i + b
    case Right(s) => s + b
  }
}


object Problems extends App {

  val c = Problem

  println(c.foo(Left(42)))
  println(c.foo(Right("Srinivas")))

}
