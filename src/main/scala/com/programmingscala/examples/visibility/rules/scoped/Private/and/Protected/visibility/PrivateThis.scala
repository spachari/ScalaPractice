package com.programmingscala.examples.visibility.rules.scoped.Private.and.Protected.visibility

package scopePrivateThis {


  //private[this] is the most restrictive
  //The private[this] members are only visible to the same instance. An instance of the same class can’t see private[this]
  // members of another instance, so the equalFields method won’t parse.

  class PrivateThis (private[this] val privateField1 : Int) {
    private[this] val privateField2 = 2

    def equalsField(other :PrivateThis) = {
      //(privateField1 == other.privateField1) && (privateField2 == other.privateField2) && (nested == other.nested)
      //Nothing from other is accesible
    }

    class Nested {
      private[this] val nestedFied = 3
    }

    private[this] val nested = new Nested
  }

  class PrivateClass2 extends PrivateThis(1) {
    //val field1 = privateField1  //we cannot access private[this] objects from child class
    //val field2 = privateField2  //we cannot access private[this] objects from child class
    //val field3 = nested.nestedField //we cannot access private[this] child objects from child class
  }

  class PrivateClass3 {
    val privateClass1 = new PrivateThis(1)
    //val field1 = privateClass1.privateField1 //we cannot access private[this] objects from some other class
    //val field2 = privateClass1.privateField2
    //val field3 = privateClass1.nested.nestedField
  }

}

object PrivateThis extends App {

  val p = new scopePrivateThis.PrivateThis(1)

  println(p)

}
