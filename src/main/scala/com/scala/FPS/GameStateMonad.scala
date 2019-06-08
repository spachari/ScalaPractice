package com.scala.FPS

 case class Stat (value : Int)
{

  def flatMap(f : Int => Stat) : Stat = {
    f(value)
  }

  def map(f : Int => Int) : Stat =
    {
      val result = f(value)
      new Stat(result)
    }

  override def toString: String = value.toString
}




object GameStateMonad extends App {

  val result = for {
    a <- Stat(10)
    b <- Stat(a + 10)
    c <- Stat(b + 20)
  } yield c

  println(result)
}
