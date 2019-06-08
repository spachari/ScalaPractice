package com.programmingscala.examples.functional.programming.monad.category

import scala.util.{Failure, Success, Try}

object UsingFlatMap extends App {

  //Using foldLeft
  val list = List(1,2,3,4,5)
  println(list.foldLeft(0) {case (initialValue, listItem) => initialValue + listItem})

  val optList = List(Some(5), Some(10), Some(20))
  println(optList.foldLeft(0) {case (initialValue, listItem) => initialValue + listItem.get})

  //Let's start the example
  type Step = Int => Try[Int]

  //In essence, Monad is important because it gives us a principled way to wrap context information around a value,
  // then propagate and evolve that context as the value evolves. Hence, it minimizes coupling between the values and
  // contexts while the presence of the Monad wrapper informs the reader of the context’s existence.

  val successfulSteps : List[Step] = List(
    (x : Int) => Success(x + 10),
    (x : Int) => Success(x + 15),
    (x : Int) => Success(x + 30)
  )

  val partiallySuccessfulSteps : List[Step] = List(
    (x : Int) => Success(x + 10),
    (x : Int) => Failure(new RuntimeException),
    (x : Int) => Success(x + 20)
  )

  def sumCounts(steps : Seq[Step]) = {
    val zero : Try[Int] = Success(0)
    (steps foldLeft zero) {
      case (sumTry, step) => sumTry flatMap (i => step(i))
    }
  }



  println(sumCounts(successfulSteps))

  println(sumCounts(partiallySuccessfulSteps))

}
