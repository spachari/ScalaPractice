package com.programmingscala.examples.functional.programming.alregraic.datatypes

case class DoubleBool(b1 : Boolean,
                 b2 : Boolean)

//This is a Product Type because It’s name comes from the fact that you use the Scala case class constructor to
// create a data type whose number of possible concrete instances can be determined by multiplying the number of
// possibilities of all of its constructor fields.



object ProductType extends App {

  //These are the only possible instances that can be created from the Bool1 class
  val a = DoubleBool(true, false)
  val b = DoubleBool(false, false)
  val c = DoubleBool(false, true)
  val d = DoubleBool(false, false)

  //Let's take a case class with two Ints
  case class Pair (
                  int1 : Int,
                  int2 : Int
                  )

  //There are a total of 2^32 possible values

  //Let's take a case class with two Strings
  case class Person (
    firstName : String,
    lastName : String
  )

  //There are a total of infinite possibilities

  //THe point is if the code as minimal number of possibilities, it will be easier to deal with

  //The number of possible values of a Product type is the product of all possible combinations of
  // the constructor parameters (i.e., a Cartesian product).

  //We use the phrases “has a” and “and” when talking about Product types. Pair has a a and a b; Person has a firstName,
  // lastName, mother, and father.

}
