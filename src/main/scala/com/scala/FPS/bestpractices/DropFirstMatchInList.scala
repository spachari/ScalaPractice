package com.scala.FPS.bestpractices


object DropFirstMatchInList extends App {

  def dropfirstMatch(list : List[String], s : String) : List[String] = {

    var firstMatchFound = false

    val resultSet = for (i <- list) yield {
      val results = if (i == s && firstMatchFound == false)
      {
        firstMatchFound = true
        None
      }
      else
      {
        Some(i)
      }
      results
    }
    resultSet.flatten
  }


  //Another way of checking


  def dropfirstMatchRecursiveWay(list : List[String], stringToCheck : String) = {
    var bool = false
    def checkFirstItemInString(listString: String) = {
     val result =  if (listString == stringToCheck && bool == false) {
        bool = true
        None
      }
      else Some(listString)
      result
    }

    def recursionLoop (list : List[String]) : List[Option[String]] = {
      list match {
        case Nil => Nil
        case x :: xs =>  checkFirstItemInString(x) :: recursionLoop(xs)
      }
    }

    recursionLoop(list)
  }

  val fruits = List("bananas","apples","bananas","grapes","apples")


  val result1 = dropfirstMatch(fruits, "apples")

  result1.foreach(println)


  println("Result from recursion ...")
  val result2 = dropfirstMatchRecursiveWay(fruits, "apples")

  result2.foreach(println)
}
