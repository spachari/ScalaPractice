package com.programmingscala.examples.concurrency.futures

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success, Try}

case class ThatsOdd(i : Int) extends RuntimeException(s"that is ${i}")

object FutureExample2 extends App {

  //
  val getResult : PartialFunction[Try[String], Unit] = {
    case s @ Success(_) => println(s)
    case f @ Failure(_) => println(f)
  }

  //Note: This is normal syntax for partial function
  val myPartialF : PartialFunction[Int, Int] = {
    case s  if (s > 5) => s
    case _ => 0
  }

  val list = (0 to 9)

  val futures : IndexedSeq[Future[String]] = (0 to 9) map {
    case i if (i % 2 == 0) => Future.successful(i.toString)
    case i => Future.failed(ThatsOdd(i))
  }

  //If you iterate through a Range using map, it will give you a IndexedSeq[Future[String]]
  //Future.successful is the Try[Success] for a Future
  //Future.failed is the Try[Failure] for a Future

  futures map (_ onComplete getResult)


  //val n = Await.result(futures, Duration.Inf)

  //Note that we can pass a Future.successful or Future.failure when we have a PartialFunction[Try[String], Unit]


  val myResult = Seq(Future.successful(11.toString)) map (_ onComplete getResult)

  Thread.sleep(10000)


  //onComplete will wait till the future is complete
  //onComplete signature
  //def onComplete[U](@deprecatedName('func) f: Try[T] => U)(implicit executor: ExecutionContext): Unit


}
