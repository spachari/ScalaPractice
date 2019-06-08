package com.scalaCookbook.examples.Generics

sealed class Attempt[A]

object Attempt {

  def apply[A](f :  => A) : Attempt[A] = { //This is call-by-name syntax. Same as (s : Int), you are saying
                                           //(s : => A)
    try {
      val result = f
      return Succeeded(result)
    }
    catch {
      case e: Exception => Failed(e)
    }
  }
}


final case class Succeeded[A](value : A) extends Attempt[A]
final case class Failed[A](exception: Exception) extends Attempt[A]


object TestAttempt extends App {
  val s = Attempt(1/1)
  println(s)

  val s1 = Attempt(1/0)
  println(s1)
}