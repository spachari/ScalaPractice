package com.programmingscala.examples.visibility.rules

import com.programmingscala.examples.visibility.rules.ScopePrivateA.PrivateClass1

package ScopePrivateA {
  class PrivateClass1 (private val privateField1 : Int = 0) {
    private val privateField2 = 1

    def equalsField(other : PrivateClass1) = { //Note: Private class can access private members of other PrivateClass1 instance
      (privateField1 == other.privateField1) &&
        (privateField2 == other.privateField2) && (nested == other.nested)
    }

    class Nested {
      private val nestedField = 1
    }

    private val nested = new Nested
    //val nestedAccess = new Nested().nestedField //Cannot access inner class field if it is private
  }

  class PrivateClass2 extends PrivateClass1 {
    //val field1 = privateField1 //Child class cannot access parent class private constructor fields
    // They are completely invisible to the subclass
    //val field2 = privateField2 //Child class cannot access parent class private fields
    //val nested = new Nested().nestedField //Child class cannot access parent class nested inner private class field
  }

  class privateClass3 {
    val privateClass1 = new PrivateClass1(1)
    //val field1 = privateClass1.privateField1 //Cannot access a private constructor fields from some other class
    //val field2 = privateClass1.privateField2 //Cannot access a private field from some other class
    //val nested = new PrivateClass1().nested.nestedField //Cannot access a private field from some other class
  }

  private class PrivateClass4

  //class PrivateClass5 extends PrivateClass4 //Cannot extend private class unless it is private

  //protected class PrivateClass6 extends PrivateClass4 //Cannot extend private class unless it is private

  private class PrivateClass7 extends PrivateClass4

}

package ScopePrivateB {

  //class PrivateClass1B extends ScopePrivateA.PrivateClass4 //Cannot extend a private class from some other package
}



object PrivateVisibilityExample extends App {

  val privateClass = new PrivateClass1(1)

  println(privateClass)

}
