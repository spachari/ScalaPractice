package com.scalaCookbook.examples.Functions

object PartiallyAppliedFunction extends App {

  //Partially applying a function
  //We have partially applied the cos function
  val c = scala.math.cos _
  println(c(10))

  //Partially applying a function
  val myAddition : (Int, Int) => Int = (x,y) => x + y

  val pApplied = myAddition
  println(pApplied(10,20))

  def addition (i : Int)(j : Int) = i + j

  val pAddition = addition(10) _

  println(pAddition(20))


  //Difference between java.util.date and java.sql.date
  import java.sql.{Date => SQLDate}
  import java.util.{Date => UtilDate}

  val d = new SQLDate(1990202020)
  val u = new UtilDate()

  println(d)
  println(u)


  //Practical use of partiallyapplied function
  //Example1
  def log (date : UtilDate)(message : String): Unit = {
    println(date + " ------- " + message)
  }

  val date = new UtilDate
  //We can eliminate the noise of passing the date to each call by partially applying that argument to the log( ) method.
  //To do so, we first bind a value to the date parameter and leave the second parameter unbound by putting an underscore at
  //its place. The result is a partially applied function that we've stored in a variable.
  val logWithBound = log(date)(_) //Partially applying the log method

  logWithBound("message1")
  Thread.sleep(1000)

  logWithBound("message2")
  Thread.sleep(1000)

  logWithBound("message3")
  Thread.sleep(1000)

  //Example 2
  def wrap(head : String)(message : String)(tail : String) = {
    head + message + tail
  }

  val hello = "Hello"
  val goodNight = "Good Night"

  //def myHtml = wrap(String)(_)(String) --- wrong
  def myHtml = wrap("<div>")(_ : String)("</div>")

  println(myHtml(hello))
  println(myHtml(goodNight))
}
