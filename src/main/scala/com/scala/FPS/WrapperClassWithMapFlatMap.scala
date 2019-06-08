package com.scala.FPS


class Wrapper[A] private (value : A) {

  def map[B](f : A => B) : Wrapper[B] = {
    val result = f(value)
    new Wrapper[B](result)
  }

  def flatMap[B](f : A => Wrapper[B]) : Wrapper[B] = {
    f(value)
  }

  override def toString: String = value.toString
}

object Wrapper{
  def apply[A](value : A) : Wrapper[A] = new Wrapper(value)
}

case class Wrapper1[A] (value : A) {

  def map[B](f : A => B) : Wrapper1[B] = {
    val result = f(value)
    new Wrapper1[B](result)
  }

  def flatMap[B](f : A => Wrapper1[B]) : Wrapper1[B] = {
    f(value)
  }

  override def toString: String = value.toString
}

object WrapperClassWithMapFlatMap extends App {

  val x = Wrapper(1)

  //Because we implemented Map we can do these things
  println(x.map(_ * 2))

  val result = for { i <- Wrapper(10) } yield i * 20

  println(result)

  println(x.flatMap(x => Wrapper(x)))

  val result1 = for {
    i <- Wrapper(1)
    j <- Wrapper(2)
    k <- Wrapper(3)
  } yield i * j * j

  println(result1)

  val result2 = for {
    i <- Wrapper1(1)
    j <- Wrapper1(2)
    k <- Wrapper1(3)
  } yield i * j * j

  println(result2)
}
