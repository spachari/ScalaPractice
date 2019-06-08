package com.programmingscala.examples.visibility.rules.scoped.Private.and.Protected.visibility

package PrivateScopeA {
  class PrivateClass1(private[PrivateClass1] val privateField1 : Int = 1) {
    private[PrivateClass1] val privateField2 = 2

    def equalsFields(other : PrivateClass1) = {
      (privateField1 == other.privateField1) && (privateField2 == other.privateField2) && (nested == other.nested)
    }

    class Nested {
      private[Nested] val nested = 1
    }

    private [PrivateClass1] val nested = new Nested

    //nested.nested //Cannot see nested because the field is declared as private[Nested]
  }

  class PrivateClass2 extends PrivateClass1(1) {
    //val field1 = privateField1 //Cannot access a scope level private field even from a child class
    //val field2 = privateField2 //Cannot access a scope level private field even from a child class
    //val field3 = nested //Cannot access a scope level private field even from a child class
  }

  class PrivateClass3 {
    //val field1 = new PrivateClass1(1).privateField1 //Cannot access a scope level private field outside it's scope
    //val field2 = new PrivateClass1(1).privateField2 //Cannot access a scope level private field outside it's scope
    //val field3 = new PrivateClass1(1).nested //Cannot access a scope level private field outside it's scope
  }

}

object PrivateScope {

}
