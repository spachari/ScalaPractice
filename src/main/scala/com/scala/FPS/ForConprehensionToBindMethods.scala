package com.scala.FPS

case class Debugable(value : Int, message : String) {

  def map(f : Int => Int) : Debugable = {
    println("\n<<<<<entering map<<<<<<<<<<")
    println(s"map: value: ${value}")
    println(s"map: msg: (${message})")
    val nextValue = f(value)
    println(s"map : next Value = ${nextValue}")
    println("<<<<<leaving map<<<<<<<<<<\n")
    Debugable(nextValue, message)
  }

  def flatMap(f : Int => Debugable) : Debugable = {
    println("\n<<<<<entering fmap<<<<<<<<<<")
    println(s"fmap: value: ${value}")
    println(s"fmap: msg: (${message})")
    val result = f(value)
    println(s"fmap: msg: (${message})")
    println(s"fmap: next value: ${result.value}")
    println(s"fmap: next msg: \n(${result.message})")
    println("<<<<<leaving fmap<<<<<<<<<<\n")
    Debugable(result.value,message + result.message)
  }

}

object ForConprehensionToBindMethods extends App {

  println(s"value: ${}")
  println()

  //THis is the function list
  def f(i : Int) : Debugable = {
    println(s"\n[f : i = $i]")
    val result = i * 2
    val message = s"\nf : a ($i) * 2 = $result"
    Debugable(result, message)
  }

  //THis is the function list
  def g(i : Int) : Debugable = {
    println(s"\n[g : i = $i]")
    val result = i * 3
    val message = s"\ng : a ($i) * 3 = $result"
    Debugable(result, message)
  }

  //THis is the function list
  def h(i : Int) : Debugable = {
    println(s"\n[h : i = $i]")
    val result = i * 4
    val message = s"\nh : a ($i) * 4 = $result"
    Debugable(result, message)
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
