package com.programmingscala.examples.types.higherkinded.types

import scala.language.higherKinds


//The symbol for M[T] is contravariant because
// 1. the method types hve to be always contravariant.
// 2. then thsi would mean that where you give a Seq, we can pass a Vector

//If we change the symbol to M[T]
//We get this error
// Error:(40, 19) could not find implicit value for parameter red: com.programmingscala.examples.types.higherkinded.types.Reduce[Int,Some]
//println(myReduce(Some(5))) i.e invariance


//If we change the symbol to +M[T]
//We cannot use them in a method because methods only accepts co-variant position ones

trait Reduce[T, -M[T]] {
  def reduce(m : M[T])(f : (T, T) => T) : T
}

object Reduce {
  implicit def reduceSeq[T] = new Reduce[T, Seq] {
    //M is being replaced here. Note that they are not adding Seq[T]. The reason is that it is inferred from the first T. [T, Seq]
    override def reduce(m : Seq[T])(f : (T, T) => T) = m reduce(f)
  }

  implicit def reduceOption[T] = new Reduce[T, Option] {
    override def reduce(m: Option[T])(f: (T, T) => T): T = m reduce(f)
  }

}



object HigerKindedTypes extends App {

  //Normal reduce
  val seq = Seq(1,2,3,4,5)
  println(seq.reduce(_ + _))

  //We are getting the function from Add[T] and container from Reduce[T, -M[T]]


  def myReduce[T : Add, M[T]](container : M[T])(implicit red: Reduce[T, M]) = {
    red.reduce(container)(implicitly[Add[T]].add(_,_))
  }

  // We have the same context bound T : Add we had in SimpleTypeClassPattern. We would like to define a context bound for M[T], such as M[T] : Reduce,
  // but we can’t because Reduce takes two type parameters and context bounds only work for the case of one and only one parameter.
  // Hence, we add a second argument list with an implicit Reduce parameter, which we use to call reduce on the input collection.

  println(myReduce(seq))
  println(myReduce(Some(5)))
  println(myReduce(Option(5)))

  //println(myReduce[Int, Option](None)) //myReduce[Int, Option] is to tell the compiler that

}
