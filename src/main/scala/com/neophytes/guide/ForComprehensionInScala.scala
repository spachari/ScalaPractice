package com.neophytes.guide

object ForComprehensionInScala extends App {

  def add1(i : Int) : Int = {
    i + 1
  }

  val list = List(1,2,3,4,5)


  def recursiveList(list : List[Int]) : Int = {
    val output = list match {
      case Nil => {
        println("Called in Nil ...")
        0
      }
      case x :: Nil => {
        println("Called in xs :: x :: Nil ")
        add1(x)
      }
      case x :: xs => {
        println(s"Calling for ${x}")
        add1(x) + recursiveList(xs)
      }
    }
    output
  }

  println(recursiveList(list))

}
