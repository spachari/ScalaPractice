package com.scalaCookbook.examples.Collections

object Filters extends App {
  //Normal Filters

  val list = Range(1, 10).toList
  def isEven (x : Int) = if (x % 2 == 0) true else false

  val evenNums = list.filter(isEven)

  println(evenNums)

  //We can provide a case statement within a filter
  val stringInts = List(1,2,3,"String","member")

  val ints = stringInts.filter {
    case s : Int => true
    case _ => false
  }

  //Filter with if condition
  def isBetween20 (x : Any) = {
    x match {
      case a : Int if (a >= 20) => true
      case _ => false
    }
  }

  //Filter with do something
  def isBetween20DoSomething (x : Any) = {
    x match {
      case a : Int if (a >= 20) => a * 20
      case _ => false
    }
  }


  ints.foreach(println)

  //Whereas map will return something
  def checkInt (x : Any) = {
    val ints1 = x match {
      case s : Int => s
      case _ =>
    }
    ints1
  }

  println(stringInts.map(checkInt))


  //Final useful code
  def printFileContents (canonicalFileName : String) = {

    try {
      scala.io.Source.fromFile(canonicalFileName)
          .getLines
          .toList
          .filter(_.trim != (" "))
          //.filter(_.charAt(0) != "#"))
    }
  }



  def printFirstCharIfAvailable(lines : List[String]) = {
    val list = for (x <- lines) yield {
      try {
        val output = Some(x.charAt(0))
        if (x.charAt(0) != "#")
          Some(x)
        else
          None
      }
      catch {
        case e: Exception => None
      }
    }
    list
  }

  val lines = printFileContents("/Users/spachari/scala-learning/QueueNormal.scala")
  val optionOutput = printFirstCharIfAvailable(lines).flatten
  optionOutput.foreach(println)

}
