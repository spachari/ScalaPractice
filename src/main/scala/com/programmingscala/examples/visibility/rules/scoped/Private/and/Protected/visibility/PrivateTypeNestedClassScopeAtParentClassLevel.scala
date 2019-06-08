package com.programmingscala.examples.visibility.rules.scoped.Private.and.Protected.visibility

package ScopeNestedClassScopeAtParentClassLevelA {
  class PrivateClass1 {

    class Nested {
      private[PrivateClass1] val nestedField = 1
    }

    private[PrivateClass1] val nested = new Nested()
    val nestedNestedField = nested.nestedField //because the nested class variable is at the level private[PrivateClass1]
                                               //they can be accessed from within PrivateClass1

  }

  class PrivateClass2 extends PrivateClass1 {
    //val nField = new Nested().nestedField //Cannot access class level private field by subclass
  }

  class PrivateClass3 {
    val privateClass1 = new PrivateClass1
    //val nField = privateClass1.nested.nestedField //Cannot access class level private field by another class member
  }

}

object PrivateTypeNestedClassScopeAtParentClassLevel {

}
