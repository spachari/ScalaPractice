package com.programmingscala.examples.types

//What does type mean:
//==============================================
//type is a member defined on object (not class) in Scala.
//==============================================

//Suppose we have this

class Foo (x : String)

object Foo {
  def apply(x : String) = new Foo(x)
  def plus(x : String, foo : Foo) = {
    x + foo
  }
}

object Foo1 {
  type T = String
}

object TypeDefinitionInScala {

  //We cannot write this i.e. access apply method in object
  //def doSomething(foo : Foo) = {
  //  foo.apply("String")
  //}

  //foo new Foo("String") or Foo("String")
  // refers to the class member. So we cannto use the apply method in the object

    //This is why objects have a type member
  def doSomething(foo : Foo.type ) = {
    foo.apply("Srinivas")
    foo.plus("x" , new Foo("x"))
  }

  //If we want specific examples, List.type is the companion object for class List
  val listObj : List.type = List

  //You are creating them via
  val emptyList = listObj.empty
  val aListOfIntegers = listObj(1,2,3,4)

  //And how this type related to type that can be defined as a field in a trait for example.
  //The type keyword defines a type member. .type is a type member.
  // Conceptually it's like every object in Scala has a type member named type, like this:

  //object Foo {
  //  type type = Foo
  // }

  val foo = new Foo1.T

  //Type constructor
  def testMethod[F[_]] : F[Int] = ???

  //We can call this method like this
  lazy val x = testMethod[List]
  lazy val y = testMethod[Option]


  //This is the same as
  def testMethod1[F[X]] : F[Int] = ???

  // F - type constructor
  // X - Type parameter

  //We can call this method like this
  //lazy val x1 = testMethod1[List[Int]] Compile error
  lazy val x2 = testMethod1[List]
  lazy val y1 = testMethod1[Option]

  //Simple tests

  import scala.language.higherKinds

  def tests[F[X]](x : F[_]) = {
    println(x)
  }

  println(List(1,2,3))

  //Hense F[X] or F[_] means you can call it with List(1,2,3) or Some(2)



  //Difference between type parameter and abstract type member

  //abstract type example
  abstract class Builders {
    type T
  }

  class IntBuilder extends Builders {
    type T = Int
  }

  //Type parameter
  class Builders1[T] {
    def printT(t : T) = {
      println(t)
    }
  }

  //. A type parameter is syntactically part of the type that it parameterises,
  //whereas a type member – like value members – is encapsulated, and must be
  // selected explicitly. Similarly, type members are inherited, while type parameters
  // are local to their class.



}
