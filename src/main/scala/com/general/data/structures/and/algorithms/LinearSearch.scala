package com.general.data.structures.and.algorithms

object LinearSearch extends App {

  val array = Array(1,2,3,4,5)

  def getElementFromSeq(x : Seq[Int]) : Int = x.toList match {
    case x :: Nil => x
    case _ => -1
  }

  def getItemUsingLinearSearch(seq : Seq[Int], item : Int) = {
    val matchingItem = for (i <- seq) yield {
      if (i == item) {
        Some(i)
      } else {
        None
      }
    }
    getElementFromSeq(matchingItem.flatMap(x => x))
  }

  println(getItemUsingLinearSearch(array, 21))

}
