package com.scala.FPS

case class DebugableGeneric[A](value : A, message : String) {

  def map[B](f : A => B) : DebugableGeneric[B] = {
    val nextValue = f(value)
    DebugableGeneric(nextValue, message)
  }

  def flatMap[B](f : A => DebugableGeneric[B]) : DebugableGeneric[B] = {
    val result = f(value)
    DebugableGeneric(result.value,message + result.message)
  }

}


object ForComprehensionToBindMethods2 extends App {

  //THis is the function list
  def f(i : Int) : DebugableGeneric[Int] = {
    val result = i * 2
    val message = s"\nf : a ($i) * 2 = $result"
    DebugableGeneric(result, message)
  }

  //THis is the function list
  def g(i : Int) : DebugableGeneric[Int] = {
    val result = i * 3
    val message = s"\ng : a ($i) * 3 = $result"
    DebugableGeneric(result, message)
  }

  //THis is the function list
  def h(i : Int) : DebugableGeneric[Int] = {

    val result = i * 4
    val message = s"\nh : a ($i) * 4 = $result"
    DebugableGeneric(result, message)
  }

  //We need to make this work
  val output = for {
    fResult <- f(100)
    gResult <- g(fResult)
    hResult <- h(gResult)
  } yield hResult

  println("/-------- final result ---------/")
  println(s"final value: ${output.value}\n")
  println(s"final message: ${output.message}")

}
