package com.scala.FPS

class ListMonad(list : Int) {
  def map(f : Int => Int) : ListMonad = {
    new ListMonad((f(list)))
  }

  def flatMap(f : Int => ListMonad) : ListMonad = {
    f(list)
  }

  override def toString: String = list.toString

}

object ListMonad{
  def apply( s : Int) : ListMonad = new ListMonad(s)
}

object ListMonadTest extends App {

  val list = ListMonad(1)
  val list1 = ListMonad(4)

  val output = for (i <- list) yield i * 2

  println(output)

  val output1 = for {
    i <- list
    j <- list1
  } yield i * j

  println(output1)


}