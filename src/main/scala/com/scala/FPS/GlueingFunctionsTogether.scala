package com.scala.FPS

object GlueingFunctionsTogether extends App {

  def f(i : Int) : Int = i * 2
  def g(i : Int) : Int = i * 3

  //Glueing them together(normal way)
  println(f(g(100)))

  def f1(i : Int) : (Int, String) = {
    val result = i * 3
    (result,s"\nf1 result : ${result}")
  }

  def g1(i : Int) :(Int, String) = {
    val result = i * 2
    (result,s"\ng1 result : ${result}")
  }

  val (f1Int,f1String) = f1(2)
  println(f1Int)

  val (g1Int,g1String) = g1(f1Int)

  val degugInfo = f1String + " " + g1String

  println(s"result = ${g1Int}, debug: ${degugInfo}")

  //Glueing them together(bind way)
  def f2(i : Int) : (Int, String) = {
    val result = i * 2
    (result, s"\nf2 result : ${result}")
  }

  def g2(i : Int) : (Int, String) = {
    val result = i * 2
    (result, s"\ng2 result : ${result}")
  }

  def h2(i : Int) : (Int, String) = {
    val result = i * 2
    (result, s"\nh2 result : ${result}")
  }

  def bind(f : (Int) => (Int,String), result : (Int, String)): (Int,String) ={
    val givenResult = result
    val newResult = f(result._1)
    val newStringString =  givenResult._2 + newResult._2
    (newResult._1,newStringString)
  }


  val fResult = f2(100)
  val gResult = bind(g2, fResult)
  val hResult = bind(h2, gResult)

  println(s"result = ${hResult._1}, debug = ${hResult._2}")

}
