package com.programmingscala.examples.types.functor.types.lamba

object TypeAliases extends App {

  //type aliases
  type L = List[Option[(String, Int)]]

  val list : L = List(Option("Srini", 1))

  //We can delare type aliases that takes types too
  type T[A] = Option[Map[Int, A]]

  //Usage
  val l : T[String] = Option(Map[Int, String](1 -> "Srinivas"))

  //Often type alias is used as a convinience, but sometimes types are important
  trait Functor[F[_]]

  type F1 = Functor[List]


  type F2 = Functor[Option]
  //type F3 = Functor[Map]

  //Error:(20, 21) Map takes two type parameters, expected: one
  //type F3 = Functor[Map]

  //We can do it this way
  type IntKeyMap[B] = Map[Int, B]

  type F4 = Functor[IntKeyMap]

  //Simple example of paritially applying function
  def cube(x : Int) = Math.pow(_ : Double, 3)

  cube(4)



  //THis will not work. SO scala is inconsistent in this way.

  //There is, in fact, currently no direct syntax for partial application of type constructors in Scala.
  //How do we mention that we will pas anything for a typewithin a type

  //This wont work too
  //We cannot say I dont care what parameterized type will come in my type constructor in scala
  //type F6 = Functor[List[_]]

  //Like that there is no way we can partially apply a type
  //Let's try this
  //type F5 = Functor[Map[Int, _]]

  //but we can do this
  type F7 = Functor[({type T[A] = Option[Map[Int, A]]})#T]

  //THis is exactly the same as type alias of a type
  //type T[A] = Option[Map[Int, A]]
  //wrapper in a ({})#T


  //We can read the type lambda syntax as: declaring an anonymous type, inside of which we define the desired type alias,
  // and then accessing its type member with the # syntax.

  //Let's say we want to add a partial application style for type parameters
  //THis wont compile
  //def foo[A[_,_], B](functor : Functor[A[B, ?])

  //Can we resolve it via a separate type alias
  //type AB[C] = ???

  //then use
  //def foo(A[_,_], B)(functor : Functor[AB])


  //ALTERNATE ENCODINGS

  //We can uyse type lambda
  def foo[A[_,_],B](functor : Functor[({type AB[C] = A[B,C]})#AB]) = ???

  //Kind projector. THis will use ?
  //type F = Functor[Map[Int, ?]]


}
