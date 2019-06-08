package com.scalaCookbook.examples.Akka

import scala.concurrent.Future
import scala.util.{Failure, Random, Success}
import scala.concurrent.ExecutionContext.Implicits.global

object FuturesTest extends App {

  println("1 - starting calculation ...")
  val f = Future {
    sleep(Random.nextInt(500))
    42
  }

  println("2- before onComplete")
  f.onComplete{
    case Success(value) => println(s"Got the callback, meaning = ${value}")
    case Failure(e) => e.printStackTrace()
  }

  def sleep(duration : Long) = Thread.sleep(duration)

  println("A ..."); sleep(100)
  println("B ..."); sleep(100)
  println("C ..."); sleep(100)
  println("D ..."); sleep(100)
  println("E ..."); sleep(100)
  println("F ..."); sleep(100)




}
