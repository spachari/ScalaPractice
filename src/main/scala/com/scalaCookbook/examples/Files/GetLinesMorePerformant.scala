package com.scalaCookbook.examples.Files

object GetLinesMorePerformant extends App {

  //Normal way of reading a file and counting lines that start with 10
  def countLines(string : String) : Option[Int] = {

    var counter = 0

    try {
      for {c <- scala.io.Source.fromFile(string)
      if c.toByte == 10}
        counter += 1
      return Some(counter)
    }
    catch {
      case e : Exception => None
    }
  }


  def countLinesPerformantWay(string : String) : Option[Int] = {

    var counter = 0
    try {
      for {line <- scala.io.Source.fromFile(string).getLines()
           c <- line
           if c.toByte == 10}
        counter += 1
      return Some(counter)
    }
    catch {
      case e : Exception => None
    }
  }

  //the above line is equal to having an inner loop
  //for (line <- scala.io.Source.fromFile(string).getLines()) {
  //    for (c <- line
  //         if c.toByte == 10) {
  //              counter


}
