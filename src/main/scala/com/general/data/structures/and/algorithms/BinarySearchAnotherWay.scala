package com.general.data.structures.and.algorithms

object BinarySearchAnotherWay extends App {

  def search (list : List[Int], item : Int)  = {
    def recursiveSearch(list : List[Int]) : List[Int]= list match {
      case list if (list(list.length / 2) == item) => List(item)
      case list if (list.length == 1 && list(list.length / 2) != item) => List(-1)
      case list if (list(list.length / 2) >= item) => {println(s"${list}, ${list.length / 2} is greater than ${item}  "); recursiveSearch(list.dropRight(list.length / 2))}
      case list if (list(list.length / 2) <= item) => {println(s"${list}, ${list.length / 2} is lesser than ${item} "); recursiveSearch(list.drop(list.length / 2))}

      case _ => Nil
    }
    recursiveSearch(list)
  }

  println(search((1 to 100).toList, 60))

}
