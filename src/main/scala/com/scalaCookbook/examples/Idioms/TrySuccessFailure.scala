package com.scalaCookbook.examples.Idioms

import scala.io.Source
import scala.util.{Failure, Success, Try}

object TrySuccessFailure extends App {

  //If we want to se the error information, we can use the Try/Success/Failure

  def readTextFile(fileName : String) = {
    Try(Source.fromFile(fileName).getLines().toList)
  }

  val fileName = "dummyFile"
  readTextFile(fileName) match {
    case Success(lines) => lines.foreach(println)
    case Failure(error) => println(error)
  }

}
