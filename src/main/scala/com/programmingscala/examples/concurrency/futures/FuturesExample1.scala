package com.programmingscala.examples.concurrency.futures

import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration

object FuturesExample1 extends App {

  val futures = (0 to 9) map {
    i => Future {
      val s = i.toString
      println(s)
      s
    }
  }

  val f = Future.reduce(futures)((s1, s2) => s1 + s2)

  val n = Await.result(f, Duration.Inf)
}
