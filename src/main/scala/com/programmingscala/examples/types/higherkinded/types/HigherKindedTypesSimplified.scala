package com.programmingscala.examples.types.higherkinded.types


//We can redefine Reduce with one type parameter, the higher-kinded type, allowing us to use it in a context bound like we wanted to do before
trait Reduce1[-M[_]] {
  def reduce[T](container : M[T])(func : (T,T) => T) : T
}

object Reduce1 {
  implicit val reduceSeq = new Reduce1[Seq] {
    override def reduce[T](container: Seq[T])(func: (T, T) => T) = container.reduce(func)
  }

  implicit val reduceOpt = new Reduce1[Option] {
    override def reduce[T](container: Option[T])(func: (T, T) => T) = container.reduce(func)
  }
}

object HigherKindedTypesSimplified extends App {


  val seq = Seq(1,2,3,4,5)
  println(seq.reduce((x,y) => x + y))

  def myReduce1[T : Add, M[_] : Reduce1](container : M[T]) = {
    implicitly[Reduce1[M]].reduce(container)(implicitly[Add[T]].add(_,_))
  }

  println(myReduce1(seq))

  println(myReduce1(Some(1)))

}
