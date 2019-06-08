package com.scala.FPS

object RecursionExamples extends App {

  val list = List(1,2,3,9,4,5,6)

  def listSum(list : List[Int]) : Int = list match {
    case Nil => {
      val stackTraceArray = Thread.currentThread().getStackTrace
      stackTraceArray.foreach(println)
      println("Nil execution reached")
      0}
    case x :: xs =>
      {
        println(s"current execution reached x is ${x} xs is ${xs}")
        x + listSum(xs)
      }
  }

  println("Sum of list " + listSum(list))
  println("Sum of list1 " + listSum(List(1,2,3,4,5)))

  def last(list : List[Int]) : Int = list match {
    case x :: Nil => x
    case x :: xs => last(xs)
    case _ => 0
  }

  println("last item of list " + last(list))

  def lastButOne(list : List[Int]) : Int = list match {
    case x :: y :: Nil => x
    case x :: xs => lastButOne(xs)
  }

  println("Last but one of list " + lastButOne(list))

  def myLength(list : List[Int]) : Int = list match {
    case Nil => 0
    case x :: xs => 1 + myLength(xs)
  }

  println("Length of list " + myLength(list))

  def reverseList(list : List[Int]) : List[Int] = list match {
    case Nil =>
      {
        println("Nil execution reached")
        List()
      }
    case x :: xs =>
      {
        val ls = xs :+ x
        println(s"list is ${xs} and x is ${x}")
        reverseList(ls)
      }
  }

  //println(reverseList(list))


}
