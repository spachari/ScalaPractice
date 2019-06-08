package com.programmingscala.examples.scalaObjectSystem

object VarianceUnderInheritance extends App {

  //Both Java and Scala support covariant, contravariant, and invariant types. However, in Scala, the variance behavior is defined
  // as part of the type declaration using a so-called variance annotation on each type parameter, as appropriate. For covariant type
  // parameters, + is used. For contravariant type parameters, - is used. No annotation is used for invariant type parameters. In
  // other words, the type designer decides how the type should vary under inheritance.

  class W[+A]         // covariant
  class X[-A]         // contravariant
  class Y[A]          // invariant
  class Z[-A,B,+C]    // mixed


  //Scala	        Java	          Description
  //+T            ? extends T     Covariant (e.g., List[Tsub] is a subtype of List[T]).
  //-T            ? super T       Contravariant (e.g., X[Tsup] is a subtype of X[T]).
  //T             T               Invariant subclassing (e.g., can’t substitute Y[Tsup] or Y[Tsub] for Y[T]).

  //The best example of looking at covariance and contravariant example is an anonymous function

  //For example
  val list = List("Srinivas", "Kirthika", "Sadhana", "Sadhiv")

  val output = list.map(_.length)

  //THis can be written as

  val f :String => Int = new Function[String, Int] {
    def apply(s : String) = s.length
  }

  //The apply method is what is called in by default. Let's use this
  val output2 = list.map(f)


  //Let's write a function of FunctionN type taking two parameters
  //It's signature is trait Function2[-T1, -T2, +R] extends AnyRef

  //This means -T1 and -T2 will accept parameters contravariant to -T1 and -T2 but the return type +R
  // will be covariant to +R

  val f2 : (String, String) => Int = new Function2[String, String, Int] {
    def apply(s1 : String, s2 : String) = s1.length + s2.length
  }

  //We can use this by
  val listOfFullNames : List[(String, String)] = List(("Mark","Smith"), ("Kim","Hughes"), ("Zoe","Zaldana"), ("Matt","Damon"))

  val output3 = listOfFullNames.map(x => f2(x._1, x._2))

  //Let's see an example

  class CSuper { def mSuper() = println("CSuper") }
  class C extends CSuper { def m() = println("C") }
  class CSub extends C { def mSub() = println("CSub") }

  //We are testing
  //The values we assign must satisfy the constraints of variance under inheritance for functions. The first assignment is


  val b1 : C => C = (c : C) => new C

  val b2 : C => C = (c : CSuper) => new CSub

  val b3 : C => C = (c : C) => new C

  val b4 : C => C = (c : C) => new CSub


  //All these will throw a Run-time exception
  //a runtime failure is likely when function is “surprised,” i.e., it tries to call some method that is only defined for CSub, not C.


  //val b5 : C => C = (c : CSub) => new CSub

  //val b7 : C => C = (c : CSub) => new C

  //Also if the caller gets a CSuper, it will “surprise” the caller with an instance that is outside the
  // range of expected return values, the allowed instances of C.
  //val b6 : C => C = (c : CSub) => new CSuper




//What is happenign is
val func : C => C = new Function1[C,C] {
  def apply(c : C) = new C
}


  //a simple example
  class Animal { def mSuper() = println("Animal") }
  class Dog extends Animal { def m() = println("Dog") }
  class Puppy extends Dog { def mSub() = println("Puppy") }

  //We are testing
  //The values we assign must satisfy the constraints of variance under inheritance for functions. The first assignment is


  val d1 : Dog => Dog = (c : Dog) => new Dog

  val d2 : Dog => Dog = (c : Animal) => new Puppy

  val d3 : Dog => Dog = (c : Dog) => new Dog

  val d4 : Dog => Dog = (c : Dog) => new Puppy



  //val d5 : Dog => Dog = (c : Puppy) => new Puppy

  //val b6 : Dog => Dog = (c : Puppy) => new Animal

  //val d7 : Dog => Dog = (c : Puppy) => new Dog



  /*
  trait MyFunction2[+T1, +T2, -R] {
       def apply(v1:T1, v2:T2): R = ???
     }
  */

}
