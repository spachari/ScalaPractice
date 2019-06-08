package com.functional.data.structures

object BigONotation extends App {

  def revList(list : List[Int]) : List[Int] = list match {
    case head :: Nil => List(head)
    case head :: tail => revList(tail) :+ head
    case Nil => Nil
  }


  def revList1(list : List[Int]) : List[Int] = list match {
    case head :: tail => revList1(tail) ++ List(head)
    case Nil => Nil
  }

  println(revList(List(1,2,3,4,5,6,7,8,9)))

  //For doing this problem, the code had to go through atleast 45 times

  //The number of iterations are proportional to (num * num) / 2



}
