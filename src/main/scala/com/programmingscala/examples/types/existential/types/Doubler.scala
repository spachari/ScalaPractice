package com.programmingscala.examples.types.existential.types

class Doubler {

  def double(d : Seq[_]) : Seq[Int] = { // this means d can be Seq[Any]. It is technically mentioned as Seq[T] forSome {type T}
    d match {
      case Nil => Nil
      case xs :: x => myToInt(xs) * 2 +: double(x)
    }
  }

  def myToInt(a : Any) = a match {
    case i : Int => i
    case s : String => s.toInt
    case x => throw new RuntimeException(s"Not expected data ${x}")
  }

}

object Test extends App {
  val list = List(1,"2","3",4)

  val d = new Doubler

  val output = d.double(list)

  println(output)

}
