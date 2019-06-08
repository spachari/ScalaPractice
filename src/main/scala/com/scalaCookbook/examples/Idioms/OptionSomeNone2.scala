package com.scalaCookbook.examples.Idioms

import scala.io.Source
import scala.util.{Failure, Success, Try}
import scala.util.control.Exception._

object OptionSomeNone2 extends App {

  //There are other uses of Options. They are
  //Returning an Option from a method
  //Example
  def toInt (s : String) : Option[Int] = {
    try{
      println("inside my method ...")
      Some(Integer.parseInt(s))
    } catch {
      case e : Exception => None
    }
  }
  println(toInt("100"))
  println(toInt("foo"))

  //Note the try is a key word in Scala, but Try is taken from scala.util.{Failure, Success, Try}


  //Getting the value from an Option
  //There are three ways of doing it in scala
  //1. getOrElse(0)
  val int : Option[Int] = Some(1)
  println(int.getOrElse(0))

  val none : Option[Int] = None
  println(none.getOrElse(0))


  //2. using foreach in an Option. Remember, an Option is a collection of 1 or no elements
  int.map(i => println(i))
  int.foreach(println)

  //Does nothing if we have a none
  none.foreach(println)

  //3. Using match expressions
  int match {
    case Some(i) => println(i)
    case _ => println(None)
  }

  //Using Option with collections
  //Option plays well with Scala collections
  val list = List("1", "2", "foo", "3", "bar")
  println(list.map(toInt))

  //This does not work
  //println(list.map(_.toInt))


  //Then we can use flatten method
  println(list.map(toInt).flatten)

  //Or we can use flatMap method instead
  println(list.flatMap(toInt))

  //Last is we can use collect method
  println(list.map(toInt).collect{ case Some(i) => i})

  //using allCatch approach
  def readTextFile(fileName : String) = {
    allCatch.opt(Source.fromFile(fileName).getLines().toList)
  }

  //allCatch is described as a Catch object “that catches everything.”
  // The opt method returns None if an exception is caught (such as a FileNotFoundException), and a Some if the block of code succeeds.

  readTextFile("dummyfile").foreach(println)

  //Using Option with frameworks

  //Using Try/Success/Failure when you need the error message (Scala 2.10 and newer)

  def divide(i : Int, j : Int) : Try[Int] = {
    Try(i / j)
  }

  println(divide(1,1))

  println(divide(1,0))

  //Again, we can use the above methods to get value from Success/Failure
  println("Using getOrElse loop ... ")
  println(divide(1,1).getOrElse(0))
  println(divide(1,0).getOrElse(0))

  //We can use foreach in here also
  println("Using foreach loop ... ")
  divide(1,1).foreach(println)
  divide(1,0).foreach(println)

  //Using matching in Try/Success/Failure
  println("Using match expression in Try/Success/Failure .. ")
def getDivideValue(x : Int, y : Int) = {
  divide(x, y) match {
    case Success(i) => println(i);
    case Failure(i) => println(i);
  }
}

  getDivideValue(1,1)
  getDivideValue(1,0)

  val x = divide(1,1).getOrElse(0)
  println(x)
  val y = divide(1,0).getOrElse(0)
  println(y)

  //This will never fail. Eventhough x is an exception, java.lang.ArithmeticException: / by zero
  //It will never fail

    val z = for {
       a <- Try(x.toInt)
       b <- Try(y.toInt)
    } yield a * b

  println(z)
  println(z.getOrElse(0) * 2)

  //Using Either/Left/Right when you need the error message (pre-Scala 2.10)
  def divideXByYEither (x : Int, y : Int) = {
    val output =
    {
      if (y == 0) Left("Cannot divide by 0")
      else Right(x / y)
    }
    output
  }

  val rightX = divideXByYEither(1,1).right.getOrElse(0)
  val leftX = divideXByYEither(1,0).left.getOrElse(None)

  println(rightX)
  println(leftX)


  //Pattern matching on Right/Left
  println("Pattern matching way ... ")
  val outputs = divideXByYEither(1,0) match {
    case Right(x) => println(x)
    case Left(x) => println(x)
  }

  println(outputs)

  case class Person(name : String, age : Int)

  def getPersonTuple(person : Person) = {
    val name = person.name
    val age = person.age
    (name)(age)
  }

  val srini = new Person("Srinivas", 37)
  getPersonTuple(srini)

}
