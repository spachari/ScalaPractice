package com.neophytes.guide

import java.io.{FileNotFoundException, InputStream}
import java.net.MalformedURLException

import scala.io.Source
import scala.util.{Failure, Success}

object ErrorHandling extends App {

  //Java's way of handling error
  case class Cigarettes(age : Int)

  case class UnderAgeException(message : String) extends Exception

  def checkAge(cigarettes : Cigarettes) : Cigarettes = {
      if (cigarettes.age <= 15)
        {

          throw new UnderAgeException("You are under age, so we cannot sell you cogarettes")
        }
      else
      {
        println(cigarettes.age)
        println("Happy smoking")
        cigarettes
      }

  }

val user1 = Cigarettes(20)
  val user2 = Cigarettes(10)

  def buyCigarette(cigAge : Cigarettes) = {
    try {
      checkAge(cigAge)
      println("Here is your pack of cigs")
    }
    catch {
      case UnderAgeException(msg) => println("Error ::: " + msg)
    }
  }

  buyCigarette(user1)
  buyCigarette(user2)

  import java.net.URL

  import scala.util.Try
  def parseURL(url: String): Try[URL] = Try(new URL(url))

  println(parseURL("http://danielwestheide.com"))
  println(parseURL("garbage"))

  //GetOrElse on URL
  def getURL() = {
    val userURL = scala.io.StdIn.readLine().toString
    val outputURL = parseURL(userURL).getOrElse("http://yahoo.com")
    println(outputURL)
  }

  getURL

  println(parseURL("http://danielwestheide.com").map(_.getProtocol))

  println(parseURL("garbage").map(_.getProtocol))

  def getOutput[A](input : Try[A]) : Try[A] = {
    input match {
      case Success(x) => Success(x)
      case Failure(x) => Failure(x)
    }
  }

  parseURL("garbage").map(_.getProtocol) match {
    case Success(x) => println("Success is " + x)
    case Failure(x) => println("Failure is " + x)
  }

  println(getOutput(parseURL("garbage")))
  println(getOutput(parseURL("http://danielwestheide.com")))

  //Multiple maps in error handling
  def inputStreamForURL(url : String) : Try[Try[Try[InputStream]]] =
    {
      parseURL(url).map(x => Try(x.openConnection()).map(conn => Try(conn.getInputStream)))
    }

  //we can do a flatMpa on this

  def inputStreamForURLFlatMap(url : String) : Try[Try[InputStream]] = {
    parseURL(url).flatMap(x => Try(x.openConnection()).map(conn => Try(conn.getInputStream)))
  }

  def inputStreamForURLFlatMapTwice(url : String) : Try[InputStream] = {
    parseURL("").flatMap(x => Try(x.openConnection()).flatMap(conn => Try(conn.getInputStream)))
  }

  //1st level of Try function
  def toInt(i : Int) : Try[Int] = {
    Try(i.toInt)
  }

  def divByNum(i : Int, f : Int => Int) : Try[Int] = {
    Try(f(i))
  }

  val output = toInt(10).flatMap(x => Try(x/100))

  //FlatMap on Options
  def isEven(i : Int) = {
    if (i % 2 == 0) {
      Some(i)
    }
    else
    {
      None
    }
  }

  val outputOnOptions = isEven(6).map(x => Option(1 to x))
  outputOnOptions.foreach(println)
  //FlatMap on Option/List
  val outputOnOptions1 = isEven(6).flatMap(x => Option(1 to x))

  outputOnOptions1.foreach(println)

  //Filter on Try
  parseURL("http://yahoo.com").filter(_.getProtocol == "http")

  //foreach on Try
  parseURL("http://yahoo.com").foreach(println)

  //normal way
  val test = parseURL("").map(x => Try(x.openConnection()).map(conn => Try(conn.getInputStream)))
  //for comprehension to chain operations together
  def inputStreamForURLWithForComp(url : String) = {
    val conn = for {
      url <- parseURL(url)
      connection <- Try(url.openConnection())
      is <- Try(connection.getInputStream)
    } yield is
    conn
  }

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

  //The above is the same as
  val test1 = parseURL("")
      .map(x => Try(x.openConnection())
      .map { conn =>
        val is = Try(conn.getInputStream)
        val source = Source.fromInputStream(is.get)
        source
      }
        .map(source => source.getLines()))

  contentForURLWithForComp("http://danielwestheide.com") match {
    case Success(x) => x.foreach(println)
    case Failure(x) => println("error message is " + x.getStackTrace)
  }

  //Recovering from an exception
  val result = contentForURLWithForComp("garbage") recover {
    case e : FileNotFoundException => Iterator("Cannot get the file to open")
    case e : MalformedURLException => Iterator("Please enter a valid URL")
    case _ : Exception => Iterator("An unexpected error occcured. Please check")
  }

  result.get.foreach(println)


  //Simple illustration of try with transform
  def result(i : Int, d : Double, b : Boolean) : Any = {
    if (b) d else i
  }

  def fA(s : String) = 7
  def fB(s : String, i : Int) = 1.0
  def fC(s : String, i : Int, d : Double) = true

  def test(s : String) = {
    Try(fA(s)).transform (
      ea => Success(result(0,0.0,false)), b => Try(fB(s,1))
    ).get
  }

  println(test("srinivas"))



}
