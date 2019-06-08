package com.scala.FPS

object ScalasMissingSplatOperator extends App {

  def printAll(strings : String*) = {
    println("--------")
    strings.foreach(println)
  }

  printAll("foo")
  printAll("foo","bar")

  val fruits = List("apple","banana","grape")
  printAll(fruits : _*) //As said, this will convert a list to a varargs parameter

  //Notes: THe splat operator will soak up the list to varargs

}
