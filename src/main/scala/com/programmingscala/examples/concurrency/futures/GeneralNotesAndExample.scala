package com.programmingscala.examples.concurrency.futures

import scala.concurrent.Future
import scala.async.Async.{async, await}
import scala.concurrent.ExecutionContext.Implicits.global
//example
  object NonParallelizedCode {
  def slowCalcFuture: Future[Int] = ???           // 01
  def combined: Future[Int] = async {               // 02
    await(slowCalcFuture) + await(slowCalcFuture)   // 03
  }
  //val x: Int = Await.result(combined, 10.seconds)   // 05
}

//Line 1 defines an asynchronous method (a method that returns a Future): it returns a Future

//Line 2 begins an async block. During compilation, the contents of this block will be analyzed to identify
// the await calls, and transformed into non-blocking code.

//Control flow will immediately pass to line 5, as the computation in the async block is not executed on the caller's thread.

//Line 3 begins by triggering slowCalcFuture, and then suspending until it has been calculated.
// Only after it has finished, we trigger it again, and suspend again. Finally, we add the results and complete combined,
// which in turn will release line 5 (unless it had already timed out).

//It is important to note that while lines 1-4 are non-blocking, they are not parallel. If we wanted to parallelize
// the two computations, we could rearrange the code as follows:

object ParallelizedCode {
  def slowCalcFuture: Future[Int] = ???
  def combined : Future[Int] = async {
    val future1 = slowCalcFuture
    val future2 = slowCalcFuture
    await(future1) + await(future2)
  }
}

object FlatMapCode {
  def slowCalcFuture : Future[Int] = ???
  val future1 = slowCalcFuture
  val future2 = slowCalcFuture
  def combined : Future[Int] = for {
     f1 <- future1
     f2 <- future2
  } yield f1 + f2
}

class GeneralNotesAndExample {

}
