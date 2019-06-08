package com.scala.FPS

case class DebugableList[A](value : A, msg : List[String]) {

  def map[B](f : A => B) : DebugableList[B] = {
    val result = f(this.value)
    new DebugableList(result, msg)
  }

  def flatMap[B](f: A => DebugableList[B]) : DebugableList[B] = {
    val result = f(this.value)
    new DebugableList(result.value, this.msg ::: result.msg)
  }
}

object DebugableListAkaWriterMonad extends App {

  //THis is the function list
  def f(i : Int) : DebugableList[Int] = {
    val result = i * 2
    val message = s"\nf : a ($i) * 2 = $result"
    DebugableList(result, List(message))
  }

  //THis is the function list
  def g(i : Int) : DebugableList[Int] = {
    val result = i * 3
    val message = s"\ng : a ($i) * 3 = $result"
    DebugableList(result, List(message))
  }

  //THis is the function list
  def h(i : Int) : DebugableList[Int] = {
    val result = i * 4
    val message = s"\nh : a ($i) * 4 = $result"
    DebugableList(result, List(message))
  }

  val output = for {
    fResult <- f(100)
    gResult <- g(fResult)
    hResult <- h(gResult)
  } yield hResult

  println("/---- Final Result -----/")
  println(s"final Value : ${output.value}")
  println(s"final Message : ${output.msg}")

}
