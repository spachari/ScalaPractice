package com.programmingscala.examples.implicits

import math.Ordering

case class MyList[A] (list : List[A]) {

  def sortBy1[B](f : A => B)(implicit ord : Ordering[B]) : List[A] = {
    list.sortBy(f)(ord)
  }

  //Using implicitly
  //The combination of a context bound and the implicitly method is a shorthand for the special case where we need
  // an implicit argument of a parameterized type, where the type parameter is one of the other types in scope
  // (for example, [B : Ordering] for an implicit Ordering[B] parameter).

  //Here is how it is done
  //The type parameter B : Ordering is called a context bound. It implies the second, implicit argument list
  // that takes an Ordering[B] instance.

  //However, we need to access this Ordering instance in the method, but we no longer have a name for it, because it’s no
  // longer explicitly declared in the source code. That’s what Predef.implicitly does for us. Whatever instance is passed
  // to the method for the implicit argument is resolved by implicitly. Note the type signature that it requires, Ordering[B]
  // in this case.
  def sortBy2[B : Ordering](f : A => B) : List[A] = {
    list.sortBy(f)(implicitly[Ordering[B]])
  }

}

object UsingImplicitlyExample2 extends App
{
  val list = MyList(List(1,2,4,5,2,1))

  println(list.sortBy1(i => -i))
  println(list.sortBy2(i => -i))

  println(list.sortBy1(i => i))
  println(list.sortBy2(i => i))
}
