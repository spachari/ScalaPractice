package com.functional.data.structures

object SimpleCompisitionExamples extends App {

  val list = List(1,2,3,4,5)

  val list1 = list zip list.drop(1)

  println(list1)

  val result = list1.forall(x => x._1 < x._2)

  println(result)

}
