package com.scalaCookbook.examples.Generics

sealed abstract class Attempt1[A] {

  //The functions whole syntax is based on the return types class of def apply (Succeeded1/Failed1)
  def getOrElse [B >: A](default: => B) : B = if (isSuccess)
    {
      println("IsSuccess is true")
      get
    } else
    {
      println("IsSuccess is false")
      default
    }
  var isSuccess = false
  def get : A
}

object Attempt1 {
  def apply[A](s : => A) : Attempt1[A] = {
  try {
    val result = s
    return Succeeded1(result)
  } catch {
    case e : Exception => Failed1(e)
  }
  }
}

final case class Succeeded1[A](result: A) extends Attempt1[A] {
  isSuccess = true
  def get = result
}

final case class Failed1[A](exception: Exception) extends Attempt1[A] {
  isSuccess = false
  override def get: A = throw exception
}

object AttemptGetOrElseTest extends App {

  val s = Attempt1(1/0).getOrElse(0)
  println(s)

  val s1 = Attempt1(1/1).getOrElse(0)
  println(s1)
}
