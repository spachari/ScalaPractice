package com.programmingscala.examples.concurrency.futures

import scala.concurrent.{Await, Future}
import scala.async.Async.{async, await}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration

object AsyncModule {

  def recordExists(id : Long) : Boolean = {
    println(s"record exists ${id}")
    Thread.sleep(1000)
    id < 0
  }

  //An expensive predicate to test for the existence of a record. It returns true if the id is greater than zero.

  def getRecord(id : Long) : (Long, String) = {
    println(s"getRecord ${id}")
    Thread.sleep(1000)
    (id, s"record ${id}")
  }

  //Another expensive method, which retrieves the record for an id.

  def asyncGetRecord(id : Long) : Future[(Long, String)] = async {
    val exists = async { val b = recordExists(id); println(b); b}
    if(await(exists)) await (async{val r = getRecord(id); println(r); r})
    else (id, "Record does not exist")
  }

  //A method that sequences asynchronous computations together. It first invokes recordExists asynchronously.
  // It waits on the result and if true, it fetches the record asynchronously. Otherwise, it returns an error record.
}

object AsyncTest extends App {

  (-1 to 1) foreach{ id =>
      val fut = AsyncModule.asyncGetRecord(id)
    println(Await.result(fut, Duration.Inf))
  }
}