package com.scala.FPS

case class WrapperInt (value : Int) {

  def map(f : Int => Int) : WrapperInt = {
    val result = f(value)
    new WrapperInt(result)
  }

  def flatMap(f : Int => WrapperInt) : WrapperInt = {
    f(value)
  }

  override def toString: String = value.toString
}
/*
object WrapperInt{
  def apply(value : Int) : WrapperInt = new WrapperInt(value)
}
*/
object IntWrapperExample extends App {

  val result = for {
    a <- WrapperInt(10)
    b <- WrapperInt(20 + 10)
    c <- WrapperInt(30 + 20)
  } yield a * b * c

  println(result)
}
