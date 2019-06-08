package com.scala.FPS

import org.scalactic.{Bad, ErrorMessage, Good, Or}

import scala.util.{Failure, Success, Try}

object ComparingTryOptionEither extends App {

  //Option to convert String to Int
  def makeIntOptionWay(i : String) : Option[Int] = {
    try{
      Some(i.trim.toInt)
    } catch {
      case e : Exception => None
    }
  }

  def printResultOptionWay(int : Option[Int]) : Unit = int match {
    case Some(x) => println(s"i = ${x}")
    case None => println("Could not derive sum because of bad input")
  }

  val output = for {i <- makeIntOptionWay("1")
                    j <- makeIntOptionWay("2")
                    k <- makeIntOptionWay("3")} yield i + j + k

  printResultOptionWay(output)

  val output1 = for {
    i <- makeIntOptionWay("1")
    j <- makeIntOptionWay("Srinivas")
    k <- makeIntOptionWay("Pachari")
  } yield i + j + k

  printResultOptionWay(output1)

  //THe draw back of Option is that it will not tell us why the output has failed
  //Try way

  def makeIntTryWay(i : String) : Try[Int] = Try(i.trim.toInt)

  def printResultTryWay(result : Try[Int]) = result match {
    case Success(x) => println(s"Successfully printed result. Output is ${x}")
    case Failure(x) => println(s"Failed to print result. Failure is ${x}")
  }
  println("Try tests ... ")

  val output2 = for {i <- makeIntTryWay("1")
                     j <- makeIntTryWay("2")
                     k <- makeIntTryWay("3")} yield i + j + k

  printResultTryWay(output2)

  val output3 = for {
    i <- makeIntTryWay("1")
    j <- makeIntTryWay("Srinivas")
    k <- makeIntTryWay("Pachari")
  } yield i + j + k

  printResultTryWay(output3)

  //Using Either option. It is similar to Try
  def makeIntEitherWay(s : String) : Either[String, Int] = {
    try {
      Right(s.trim.toInt)
    }
    catch {
      case e : Exception => Left(e.toString)
    }
  }

  def printResultEitherWay(i : Either[String, Int]) : Unit = i match {
    case Left(x) => println(s"Output failed, reason is ${x}")
    case Right(x) => println(s"Output is ${x}")
  }

  println("Either tests ... ")

  /* Does not work in IDE, but works fine in REPL, maybe because of versions
  val output5 = for {i <- makeIntEitherWay("1")
                     j <- makeIntEitherWay("2")
                     k <- makeIntEitherWay("3")} yield i + j + k

  printResultEitherWay(output5)

  val output6 = for {
    i <- makeIntEitherWay("1")
    j <- makeIntEitherWay("Srinivas")
    k <- makeIntEitherWay("Pachari")
  } yield i + j + k

  printResultEitherWay(output6)
*/
  printResultEitherWay(makeIntEitherWay("1"))
  printResultEitherWay(makeIntEitherWay("Srinivas"))

  //Scalactic Or way
  def makeIntOrWay(s : String) : Int Or ErrorMessage = {
    try {
      Good(s.trim.toInt)
    }
    catch
      {
        case e : Exception => Bad(e.toString)
      }
  }

  def printResultOrWay(int : Int Or ErrorMessage) = int match {
    case Good(x) => println(s"Output is ${x}")
    case Bad(x) => println(s"Error message is ${x}")
  }

  println("Or tests ...")
  printResultOrWay(makeIntOrWay("1"))
  printResultOrWay(makeIntOrWay("Srinivas"))

  val output5 = for {i <- makeIntOrWay("1")
                     j <- makeIntOrWay("2")
                     k <- makeIntOrWay("3")} yield i + j + k

  printResultOrWay(output5)

  val output6 = for {
    i <- makeIntOrWay("1")
    j <- makeIntOrWay("Srinivas")
    k <- makeIntOrWay("Pachari")
  } yield i + j + k

  printResultOrWay(output6)

  //Last Null object pattern
  def nullPattern(list : List[Int]) : List[Int] = {
    if (list.sum >= 30)
      {
        list.filter( _ > 4)
      }
    else
      {
        Nil : List[Int]
      }
  }

  val nullPatternOutput = nullPattern(List(1,2,3,4))

  println(nullPatternOutput)
}
