package com.neophytes.guide

import java.net.MalformedURLException
import java.util.concurrent.CompletableFuture
import java.util.stream.Collectors

import scala.io.Source

object EitherLeftOrRight extends App {

  import java.net.URL

  import scala.util.Try
  def parseURL(url: String): Try[URL] = Try(new URL(url))

  //ReadFile from contnt using for comprehension
  def contentForURLWithForComp(url : String) = {
    val content = for {
      url <- parseURL(url)
      connection <- Try(url.openConnection())
      is <- Try(connection.getInputStream)
      source = Source.fromInputStream(is)
    } yield source.getLines()
    content
  }

  //Creating a Left or Right
  def getContent(url : URL) : Either[String,Source] = {
      if (url.getHost.contains("google"))
        Left("Requested URL is blocked for the good of the people")
      else
        Right(Source.fromURL(url))
  }

  //Using Either values
  getContent(new URL("http://google.com")) match {
    case Left(errorMsg) => println(errorMsg)
    case Right(iterator) => iterator.foreach(println)
  }

  //Difference between Try and Either
  //Try is success-biased: it offers you map, flatMap and other methods that all work under the assumption that the Try is a Success,
  // and if that’s not the case, they effectively don’t do anything, returning the Failure as-is.
  //example

  def getInt(i : String) : Try[Int] = {
    Try(i.toInt)
  }

  println(getInt("10").map(x => x * 2).getOrElse(0))
  println(getInt("Srinivas").map(x => x * 2).getOrElse(0))

  def getIntEither(i : String) : Either[String,Int] = {
    val x = i.toInt
    if (x >= 0 && x <= 1000)
      {
        Right(x)
      }
    else
      {
        Left(x.toString)
      }
  }


  //There is no assumption with Either, we have to specifically call and write right/left and then write the condition
  println(getIntEither("10").right.map(x => x * 2))
  //println(getIntEither("Srinivas").left)


  //Right projection
  val content : Either[String, Iterator[String]] =
    getContent(new URL("http://google.com")).right.map(_.getLines())

  //Regardless of whether content is Right or Left, The return type should be Either[String, Iterator[String]]

  //Left projection
  val errorMessage : Either[Iterator[String], Source] =
    getContent(new URL("http://google.com")).left.map(Iterator(_))

  //Flatmapping on Either
  //Let’s say we want to calculate the average number of lines of two of my articles.
  // You’ve always wanted to do that, right? Here’s how we could solve this challenging problem:
  val part5 = new URL("http://t.co/UR1aalX4")
  val part6 = new URL("http://t.co/6wlKwTmu")

  val part5Content = getContent(part5)
  val part6Content = getContent(part6)

  println("Content is " + part5Content.right.get)
  println("Content is " + part6Content.right.get)

  //This is an example of inner anomyous functions. see how the outer x can be used in the inner y
  val average = getContent(part5).right.map(x => getContent(part6).right.map(y => (x.getLines().size + y.getLines().size) / 2))

  println(average)

  //Another simple example
  val a = List(1, 2)
  val b = List(3, 4)


  val listMultiplication = a.map(x => b.map(y => x * y))
  println(listMultiplication)

  //Let's try flatMap
  val listMultiplicationFlatMap = a.flatMap(x => b.map(y => x * y))
  println(listMultiplicationFlatMap)


  //average on flatmap
  val averageWithFlatMap = getContent(part5).right.flatMap(x => getContent(part6).right
    .map(y => (x.getLines().size + y.getLines().size) / 2))

  println(averageWithFlatMap)

  val averageWithForComp = for {
    i <- getContent(part5).right
    j <- getContent(part6).right
  } yield (i.getLines().size + j.getLines().size) / 2

  println(averageWithForComp)


  //forComprehension
  def averageLineCountWontCompile(url1 : URL, url2 : URL) = {
    for {
      i <- getContent(url1).right
      j <- getContent(url2).right
      line1 <- Right(i.getLines().size).right
      line2 <- Right(j.getLines().size).right
    } yield (line1 + line2) / 2
  }

  //folding in iterator
  val contentFold =
    getContent(new URL("http://danielwestheide.com")).fold(Iterator(_), _.getLines())

  //Advantage of Either is we can pass any Exception rather than just Throwable
  import scala.util.control.Exception.catching
  def handling[Ex <: Throwable, T](exType : Class[Ex])(block : => T) : Either[Ex, T] = {
    catching(exType).either(block).asInstanceOf[Either[Ex,T]]
  }

  //Now use it
  //now throw MalFunctionException

  def getContentOrMalFunctionException(url : String) : Either[MalformedURLException, URL] = {
    handling(classOf[MalformedURLException])(new URL (url))
  }

  println(getContentOrMalFunctionException("http://danielwestheide.com"))

  println(getContentOrMalFunctionException("garbage"))

  //Using a simple real world example
  case class Customer(age : Int)
  class Cigarette
  class UnderAgeException extends Exception {
    def message = println("You are under age")
  }


}


