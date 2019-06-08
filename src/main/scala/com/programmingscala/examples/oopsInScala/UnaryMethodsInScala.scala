package com.programmingscala.examples.oopsInScala

case class Complex(real : Double, image : Double) {
  //The method name is unary_X, where X is the operator character we want to use, - in this case.
  // Note the space between the - and the :. This is necessary to tell the compiler that the method name ends with -
  // and not :! For comparison, we also implement the usual minus operator.
  def unary_- : Complex = Complex(-real, image)

  def - (other : Complex) = Complex(this.real - other.real, this.image - other.image)

  //Once we’ve defined a unary operator, we can place it before the instance, as we did when defining c2. We
  // can also call it like any other method, as we did for c3.
}

object UnaryMethodsInScala extends App {

  val c1 = Complex(1.0, 2.0)

  println(c1)

  val c2 = Complex(2.0,3.0)

  println(c2 - c1)

  val c3 = -c2
  println(c3)



}
