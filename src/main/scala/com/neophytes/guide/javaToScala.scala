package com.neophytes.guide

import scala.concurrent.{Await, Future}
import scala.reflect.ClassTag
import scala.util.{Failure, Success}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import java.util.concurrent.CompletableFuture


object javaToScala extends App {


  def f[A : ClassTag](n : Int) = {
    new Array[A](n)
  }


  /*
  import java.util.concurrent.CompletableFuture
  import java.util.stream.Collectors

  def all[T](futures: List[CompletableFuture[T]]) = {
    val futuresSize = futures.size
    val cfs = f[CompletableFuture[T]](futuresSize)

    CompletableFuture.allOf(cfs)
  }

  public static <T> CompletableFuture<List<T>> all(List<CompletableFuture<T>> futures) {
    CompletableFuture[] cfs = futures.toArray(new CompletableFuture[futures.size()]);

  return CompletableFuture.allOf(cfs)
    .thenApply(() -> futures.stream()
      .map(CompletableFuture::join)
      .collect(Collectors.toList())
    );
  }
  */

  val list = List(1,2,3,4,5)

  val array = list.toArray

  val list1 = 1 :: 2 :: 3 :: 4 :: 5 :: Nil

  val future1 = new CompletableFuture[Int]


  val listOFFutures = List(new CompletableFuture[Int]())

  /*
  val futureList = scala.compat.java8.FutureConverters.toScala(listOFFutures)



  futureList.onComplete {
    case Success(x) => x.map(Success(_)).foreach(println)
    case Failure(x) => println(x.printStackTrace)
  }

  futureList.foreach(println)

  println("With await ... ")
  val futureListwithAwait = Await.result(futureList, Duration(100, "millis"))




  futureListwithAwait.foreach(println)

  //array.foreach(println)

*/
}
