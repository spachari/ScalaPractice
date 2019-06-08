package com.programmingscala.examples.types.functor.types.lamba

trait Functor [A, +M[_]]{
  def map2[B](func : A => B) : M[B]
}

object Functor {

  implicit class SeqFunctor[A](s : Seq[A]) extends Functor[A, Seq] {
    override def map2[B](func: A => B): Seq[B] = s map(func)
  }

  implicit class OptionFunctor[A](o : Option[A]) extends Functor[A, Option] {
    override def map2[B](func: A => B): Option[B] = o map (func)
  }

  implicit class MapFunctor[K,V1](map : Map[K,V1]) extends Functor[V1,({type λ[α] = Map[K,α]})#λ] {
    override def map2[V2](func: V1 => V2): Map[K, V2] = map map {
      case(a,b) => (a,func(b))
    }
  }

}

object FunctorTypes extends App {

  import Functor._

  val seq = Seq(1,2,3,4)
  def multipluyBy2 (i : Int) = i * 2

  val output = seq.map(multipluyBy2(_))
  println(output)

  val outputFromMyMap = seq.map2(multipluyBy2)
  println(outputFromMyMap)

  val map = Map(1 -> 2, 2 -> 3, 3 -> 4)
  println(map.map2(multipluyBy2))

}
