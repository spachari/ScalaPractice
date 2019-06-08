package com.scalaCookbook.examples

import util.control.Breaks._
object BreakAndContinueDemo extends App {
  println("------BREAK EXAMPLE--------")

  //Break definition
  //private val breakException = new BreakControl
  //def break(): Nothing = { throw breakException }

  //breakable definition
  /* def breakable(op: => Unit) {
    try {
      op
    } catch {
      case ex: BreakControl =>
        if (ex ne breakException) throw ex
    }
  } */

  breakable {
    for (i <- 1 to 10)
      {
        println(i)
        if (i == 4) break //At this point an exception is thrown, and the for loop is exited. The breakable “keyword” essentially catches
                          // the exception, and the flow of control continues with any other code that might be after the breakable block
      }
  }

  println("\n-------CONTINUE EXAMPLE-------")
  val string = "peter piper picked a peck of pickled peppers"
  var counter = 0

  for (i <- 0 until string.length) //println(i + "   " + string(i))
  {
    breakable {
      if (string(i) != 'p') {
        //println(string(i))
        break //
        println("exception thrown")
      }
      else
      {
        counter += 1
        println(i + "---" + counter)
      }
    }
  }


  println(s"There are a total of ${counter} p's in the line")

  println("Scala way of doing this is ..")
  //Scala way of doing it would be
  val totalp = string.map(c => if (c == 'p') 1 else 0).foldLeft(0)(_+_)
  println(s"There are a total of ${totalp} p's in the line")

  //The one in scala book
  val counts = string.count(c => c == 'p')
  println(counts)

  val array = (1 to 10).toArray


  def printTillSum(a : Array[Int], sum : Int) : Array[AnyVal] = {
    var acc : Int = 0
    var newArray : Array[Int] = Array()
    val s = for (i <- a if acc < sum) yield
      {
        acc += i
        if (acc < sum) i
      }
    return s
  }
  val s = printTillSum(array,30)

  s.filter(c => c != ()).foreach(println)



}