package com.programmingscala.examples.functionalprogramming

object Combinators {
  def map[A,B](f : A => B)(list : List[A]) = {
    list map f
  }
}

object UsingMapforLifting extends App {

  def intToString(i : Int) : String = s"N=${i}"

  val list = List(1,2,3,4,5)

  val lift1 = Combinators.map(intToString) _

  println(lift1)

  val output = lift1(List(1,2,3,4))

  println(output)

  val normalOutput = Combinators.map(intToString)(List(1,2,3,4))

  println(normalOutput)


}
