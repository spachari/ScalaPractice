package com.scalaCookbook.examples.Idioms

import java.io.{FileNotFoundException, IOException}

import scala.io.Source

object MatchExpressionsInScala extends App {

  //as much as possible use match expressions. A match expression can be used in the following ways.

  //Replacement for Java if/Else statement
  //Note about partial functions here, if the value is not there, it will still execute the apply funtion and throw error.
  // We need to use isDefinedAt and check if it works

  val getMonth = new PartialFunction[Int, String] {

    override def isDefinedAt(x: Int) = x >= 1 && x <= 12

    override def apply(i: Int) = {
      val month = i match {
        case 1 => "January"
        case 2 => "February"
        case 3 => "March"
        case 4 => "April"
        case 5 => "May"
        case 6 => "June"
        case 7 => "July"
        case 8 => "August"
        case 9 => "September"
        case 10 => "October"
        case 11 => "November"
        case 12 => "December"
        case _ => "Dont know"
      }
      month
    }
  }

  println(if (getMonth.isDefinedAt(10)) getMonth(10))
  println(if (getMonth.isDefinedAt(13)) getMonth(13))

  //2. Multiple conditions in if/then/else statements

  def oddOrEven (i : Int) = {
    i match {
      case 1 | 3 | 5 | 7 | 9 | 11 => "Odd"
      case 2 | 4 | 6 | 8 | 10 | 12 => "Even"
    }
  }

  //3. In Try catch expressions
  def readFile(filename : String) : Option[List[String]] = {
    val lines = try {
      Some(Source.fromFile(filename).getLines().toList)
    }
    catch {
      case e : Exception => None
    }
    lines
  }

  //We can also use multiple case statements when we need to
  def readFileWithException(filename : String) : Option[List[String]] = {
    val lines = try {
      Some(Source.fromFile(filename).getLines().toList)
    }
    catch {
      case e : FileNotFoundException => //log.error
      None
      case e : IOException => //log.error
      None
    }
    lines
  }

  case class Person(name : String)
  class Dog11(name : String)

  //Matching against the type of the object
  def getClassAsString(x : Any) : String = x match {
    case s : String => "String"
    case i : Int => "Int"
    case Person(p) => "person"
    case d : Dog11 => "dog"
    case List(e @ List(1,2),_) => e.toString()
    case _ => "Dont know"
  }

  val d = new Dog11("Srini")
  println(getClassAsString(d))

}
