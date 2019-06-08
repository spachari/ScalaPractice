package com.programmingscala.examples.functional.programming.alregraic.datatypes

//One of the benefits of ADT is it's ability to enable the ease of pattern matching

//Example
sealed trait Shape1
final case class Circle1(point : Double) extends Shape1
final case class Rectangle1(lenght : Double, breadth : Double) extends Shape1

object PatternMatchingInADT extends App {

  def checkShape(shape : Shape1) = {
    shape match {
      case circle : Circle1 => s"Got a ${circle}"
      case rectangle : Rectangle1 => s"Got a ${rectangle}"
      case _ => s"GOt something else"
    }
  }

  def isCircle(shape : Shape1) = {
    shape match {
      case Circle1(_) => true
      case _ => false
    }
  }

  //Example 2
  case class DoubleBool1 (
                           bool1 : Boolean,
                           bool2 : Boolean
                         )

  def and(bool : DoubleBool1) = {
    (bool.bool1, bool.bool2) match {
      case (true, true) => true
      case (false, true) => false
      case (false, false) => true
      case (true, false) => false
    }
  }

  def or(bool : DoubleBool1) = {
    (bool.bool1, bool.bool2) match {
      case (true, _) => true
      case (_, true) => true
      case (_,_) => false
    }
  }

}
