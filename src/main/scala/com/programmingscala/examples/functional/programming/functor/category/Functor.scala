package com.programmingscala.examples.functional.programming.functor.category

//Implementing the map function
trait Functor1[F[_]] {
  def map[A,B](fa : F[A])(func : A => B) : F[B]
}

//Let's implement this for a couple of collections
object SeqFunctor extends Functor1[Seq] {
  override def map[A, B](fa: Seq[A])(func: A => B) = fa map func
}

object OptionFunctor extends Functor1[Option] {
  override def map[A, B](fa: Option[A])(func: A => B) = fa map func
}

//Creating an object that takes a map which chains two functions together


object FunctorF {
  def map1[A,A1,B](f : A => A1)(func: A1 => B) : A => B = {// We will pass a function A => B for F[_]
    val functor = new Functor1[({ type A3[B] = A => B})#A3] {             // To do this, we need to say { type A3[B] = A => B}
                                                           // so that if we cancel B on both sides we will get type A3[_] = A =>
      override def map[A4, B](fa: A => A4)(func: A4 => B) : A => B = (a : A) => func(fa(a))
    }
    functor.map(f)(func)
  }
}

//Trying to write it as a case class
trait Functor2[F[_]] {
  def map1[A,B](fa : F[A])(func: A => B) : F[B]
}
//If you want to convert the above as a SeqFunctor of case class we need to do this
case class SeqFunctor1[A](fa: Seq[A]) extends Functor2[Seq] {
  override def map1[A, B](fa: Seq[A])(func: A => B) : Seq[B] = fa map func
}

//Trying to write it as a case class way 2
trait Functor3[A,F[_]] {
  def map1[B](func: A => B) : F[B]
}
//If you want to convert the above as a SeqFunctor of case class we need to do this
//But it is not needed because we need only one instance of it, so object is the right way to do it
case class SeqFunctor2[A](fa: Seq[A]) extends Functor3[A,Seq] {
  override def map1[B](func: A => B) = fa map func
}

//Let's use them
object FunctorTest extends App {

  val f1 : Int => Int = (i : Int) => i * 10
  val f2 : Int => Double = (i : Int) => 2.1 * i
  val f3 : Int => String = (i : Int) => i.toString

  val list = List(1,2,3,4)
  val output = SeqFunctor.map(list)(f1)
  println(output)

  val output1 = SeqFunctor1(list).map1(list)(f1)
  println(output1)

  val output2 = SeqFunctor2(list).map1(f1)
  println(output2)

  //Using OptFunctor in our code
  val int = Some(5)
  val output4 = OptionFunctor.map(int)(f1)

  println(output4)

  //Using our FunctorF in our code
  val output5 = FunctorF.map1[Int, Int, Double](f1)(f2)(10)
  println(output5)

  //This is the same as a compose
  val output6 = f2 compose f1
  println(output6(10))

}