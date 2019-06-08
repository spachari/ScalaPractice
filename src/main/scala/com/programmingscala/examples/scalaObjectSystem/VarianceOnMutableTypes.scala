package com.programmingscala.examples.scalaObjectSystem

object VarianceOnMutableTypes extends App {

  /*
  * scala> class ContainerPlus[+A](var value: A)
    <console>:11: error: covariant type A occurs in contravariant position in type A of value value_=
          class ContainerPlus[+A](var value: A)
                                   ^

    scala> class ContainerPlus[-A](var value: A)
    <console>:11: error: contravariant type A occurs in covariant position in type => A of variable value
          class ContainerPlus[-A](var value: A)
  */

  //We cannot use a variance directly in scala for an immptable variable. This is because a var
  //acts like a private variable with accessors and mutators even though it is not one.

  //We can write them like this

  class ContainerPlusNormal[A](var a: A) {
    private var _value : A = a //Assign it to some other value
    def value_=(newA : A) : Unit = _value = newA //contravariant position i.e you can pass any super type of A
    def value : A = _value //covariant position i.e you can pass any subtype of A
  }

  //If you think of a mutable field in terms of a getter and setter method, it appears in both covariant position
  // when read and contravariant position when written. There is no such thing as a type parameter that is both
  // contravariant and covariant, so the only option is for A to be invariant for the type of a mutable field.

  class ContainerPlusl[A](var a: A) {
    private var _value : A = a //Assign it to some other value
    def value_=(newA : A) : Unit = _value = newA //contravariant position i.e you can pass any super type of A
    def value : A = _value //covariant position i.e you can pass any subtype of A
  }

}
