package com.programmingscala.examples.functional.programming.monad.category

trait Monad[M[_]] {
  def flatMap[A,B](m : M[A])(f : A => M[B]) : M[B]
  def unit [A](a : => A) : M[A]

  def bind[A,B](fa : M[A])(f: A => M[B]) : M[B] = flatMap(fa)(f)
  def >>=[A,B](fa : M[A])(f: A => M[B]) : M[B] = flatMap(fa)(f)
  def pure[A](a: => A) : M[A] = unit(a)
  def `return`[A](a: => A): M[A] = unit(a)
}

object SeqFlatMap extends Monad[Seq] {
  override def flatMap[A, B](seq: Seq[A])(f: A => Seq[B]) = seq.flatMap(f)

  override def unit[A](a: => A) = Seq(a)
}

object OptionFlatMap extends Monad[Option] {
  override def flatMap[A, B](opt: Option[A])(f: A => Option[B]) = opt.flatMap(f)

  override def unit[A](a: => A) = Option(a)
}

object MonadCategory extends App {

  val seqF : Int => Seq[Int] = i => 1 to i
  val optF : Int => Option[Int] = i => Some(i)

  val list = List(1,2,3,4,5)
  val option = Some(4)

  val outputSeq = SeqFlatMap.flatMap(list)(seqF)
  val outputSeq1 = SeqFlatMap.flatMap(List.empty)(seqF)
  println(outputSeq)
  println(outputSeq1)

}
