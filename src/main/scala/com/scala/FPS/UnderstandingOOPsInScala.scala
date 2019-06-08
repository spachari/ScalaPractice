package com.scala.FPS

import scala.util.Try

trait Student {
  def name : String
  def id : Int
  def marks : Int

  override def toString = s"${name}  + ${id}  + ${marks}"
}


object UnderstandingOOPsInScala extends App {

  def timer[A](blockOfCode : => A) = {
    val startTime = System.currentTimeMillis()
    val result = blockOfCode
    println(result)
    val endTime = System.currentTimeMillis()
    val timeTaken = endTime - startTime
    (result, timeTaken)
  }

  val srinivas = new Student {
    val name = "Srinivas"
    val id = 123
    val marks = 80
  }

  val (result, time) = timer{
    scala.io.Source.fromFile("/Users/spachari/Desktop/create_customer_profile_change_history_file.hql").getLines.toList.length
  }

  println((result, time))

  val results = scala.io.Source.fromFile("/Users/spachari/Desktop/create_customer_profile_change_history_file.hql").getLines.toList.length

  println(results)

  //So if you see a code that starts like this
  //val output = FOO {
  //
  //}

  //It could be one of this
  //1. Anomyous class implementing a trait
  //2. function taking a calling by name parameter

  //Passing FIP in case class
  case class StringToInt(f : String => Int)

  val stringLength = StringToInt {
    s : String => s.length
  }

  val stringHash = StringToInt {
    s : String => s.hashCode
  }

  println(stringLength.f("bananas"))

  println(stringHash.f("bananas"))

  //Another complicated example
  case class Transform2InputsToOne[A,B](f : (A,A) => B)

  val intsConcat = Transform2InputsToOne { (a : Int, b : Int) => a.toString + b.toString }
  println(intsConcat.f(10,10))

  val stringLengthTogether = Transform2InputsToOne {
    (a: String, b : String) =>
    val x = Try(a.toInt)
    val y = Try(b.toInt)
    x.getOrElse(0) + y.getOrElse(0)
  }

  val output = stringLengthTogether.f("Srinivas","Pachari")

 println(output)

  val output1 = stringLengthTogether.f("100","100")

  println(output1)

    //Case class with multiple parameters
  case class StringUtils(s : String)(f : String => Int){
      def fun = f(s)
    }

  val x = StringUtils("hello"){
    s : String => s.length
  }

  println(x.fun)

  //function with multiple parameters
  def stringManipulations(s : String)(fun : String => Int) = {
    fun(s)
  }

  val x1 = stringManipulations("Hello"){
    s : String => s.length
  }

  println(x1)

  //So if you see a code that starts like this
  //val output = FOO { (a : String) =>
  //
  //}

  //It could be one of this
  //1. A class that takes a function parameter
  //2. function that takes a function as a parameter

  //A real use case
  println("A real use case ... ")
  def using[A <: {def close() : Unit} ,B](resource : A)(f : A => B) = {
    try{
      f(resource)
    }
    catch {
      case e : Exception => None
    }
  }

  //Remember using will execute the f(resource)
  using(scala.io.Source.fromFile("/Users/spachari/Desktop/create_customer_profile_change_history_file.hql")){
    source => val l = source.getLines().toList.length
    println(l)
  }


  //This chapter is very useful when we read someone's code
  
}
