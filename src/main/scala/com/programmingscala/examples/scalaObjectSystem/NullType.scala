package com.programmingscala.examples.scalaObjectSystem

object NullAndNothingType extends App {

  //Null
  //Null is typically defined as this


  //abstract final class Null extends AnyRef

  //This declaration disallows subtyping and creating your own instances,
  // but the runtime environment provides one instance

  //Null is explicitly defined as a subtype of AnyRef, but it is also a subtype of all AnyRef types.
  // This is the type system’s formal way of allowing you to assign null to instances of any reference type.

  //On the other hand, because Null is not a subtype of AnyVal, it is not possible to assign null to an Int,
  // for example. Hence, Scala’s null behaves exactly like Java’s null behaves, as it must to coexist on the JVM.

  //Nothing
  //Nothing has no analog in Java, but it fills a hole that exists in Java’s type system. Nothing is
  // implemented in the compiler as if it had the following declaration:


  //abstract final class Nothing extends Any

  //Nothing effectively extends Any. So, by construction in the type system, Nothing is a subclass of all other types,
  // reference as well as value types. In other words, Nothing subclasses everything, as weird as that sounds.

  //Unlike Null, Nothing has no instances. Instead, it provides two capabilities in the type system that contribute to robust,
  // type-safe design.

  //The first capability is best illustrated with our familiar List[\+A] class. We now understand that List is covariant in A, so
  // List[String] is a subtype of List[Any], because String is a subtype of Any. Therefore, a List[String] instance can be assigned
  // to a variable of type List[Any].

  //Scala declares a type for the special case of an empty list, Nil. In Java, Nil would have to be a parameterized class like List,
  // but this is unfortunate, because by definition, Nil never holds any elements, so a Nil[String] and a Nil[Any] would be different,
  // but without distinction.

  //Scala solves this problem by having Nothing. Nil is actually declared like this:

  //object Nil extends List[Nothing] with Product with Serializable

  //Because Nil extends Nothing which inturn extends eventhing, you can say that Nil (by the above definition and covariance)
  // will be used to define an empty list[of anything]

  //Note that Nil is an object and it extends List[Nothing]. There is only one instance of it needed, because it carries no
  // “state” (elements). Because List is covariant in the type parameter, Nil is a subtype of List[A] for all types A (because
  // Nothing extends everything). Therefore, we don’t need separate Nil[A] instances. One will do.

  //The other use for Nothing is to represent expressions that terminate the program, such as by throwing an exception.
  // Recall the special ??? method. It can be called in a temporary method definition so
  // the method is concrete, allowing an enclosing, concrete type to compile, but if the method is called, an exception is
  // thrown. Here is the definition of ???:

  def ??? : Nothing = throw new NotImplementedError

  //Because it returns Nothing, it can be called by any function

  //Ex

  /*
  def m(list : List[Int]) : List[Int] = {
    list.map(x => ???)
  }
  */

  //And use it like this
  /*
  *
  * scala> m(List(1,2,3))
scala.NotImplementedError: an implementation is missing
  at scala.Predef$.$qmark$qmark$qmark(Predef.scala:284)
  at .$anonfun$m$1(<console>:13)
  at .$anonfun$m$1$adapted(<console>:13)
  at scala.collection.immutable.List.map(List.scala:283)
  at .m(<console>:13)
  ... 29 elided
  */

  //More realistically it can be declared like this

  def mean_std(list : List[String]) = ???


}
