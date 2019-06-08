package com.programmingscala.examples.types.trial.tutorial


//This article is about type members and how they enable code abstraction
trait Iterable[T] {
  def filter(p : T => Boolean) : Iterable[T]
  def remove(p : T => Boolean) : Iterable[T] = { filter(x => !p(x)) }

}


//if you need to send a List[T]
trait List[T] extends Iterable[T] {
  override def filter(p: T => Boolean): List[T]

  override def remove(p: T => Boolean): List[T] = { filter (x => !p(x))}
}

trait Option[T] extends Iterable[T] {
  override def filter(p: T => Boolean): Option[T]

  override def remove(p: T => Boolean): Option[T] = { filter (x => !p(x))}
}
//The drawback of this system is we ahve to copy paste remove and only change it's return type

//Solution 1
trait Iterable1[T, Container[T]]{
  def filter(p : T => Boolean) : Container[T]

  def remove(p : T => Boolean) : Container[T] = {filter(x => !p(x))}
}

trait List1[T] extends Iterable1[T , List]

trait Option1[T] extends Iterable1[T, Option]

//The improved Iterable now takes two type parameters: the first one, T, stands for the
//type of its elements, and the second one, Container, represents the type constructor that determines part of the result
//type of the filter and remove methods. More specifically, Container is a type parameter that itself takes one type parameter.
//Although the name of this higher-order type parameter (X) is not needed here, more sophisticated examples will
//show the benefit of explicitly naming 2 higher-order type parameters.

//Now, to denote that applying filter or remove to a List[T] returns a List[T], List simply instantiates
//Iterable’s type parameter to the List type constructor.

//Example of it's usage

class Lists extends List1[Int] {
  val list = List(1,2,3)
  override def filter(p: Int => Boolean) : List[Int] = this.filter(p)
}

//Improving the Iterable for Foreach for for-comprehensions
trait Builder[Container[X], T] {
  def +=(t : T) : Unit

  def finalise() : Container[T]
}



