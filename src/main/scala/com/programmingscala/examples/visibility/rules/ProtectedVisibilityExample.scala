package com.programmingscala.examples.visibility.rules

package ScopeProtectedA {

  class ProtectedClass1 (protected val protectedField1 : Int) {
    protected val protectedField2 = 2

    def equalFields(other : ProtectedClass1) = {
      (protectedField1 == other.protectedField1) && (protectedField2 == other.protectedField2) && (nested == other.nested)
    }

    class Nested {
      protected val nestedField = 1
    }

    protected val nested = new Nested //This is a way to access Nested
  }

  class ProtectedClass2 extends ProtectedClass1(1) {

    val field1 = protectedField1
    val field2 = protectedField2

    //val nField = new Nested().nestedField //Cannot access a inner class



  }

  class ProtectedClass3 {
    //val field1 = protectedField1
    //val field2 = protectedField2
    //val nField = new Nested().nestedField
  }

  protected class ProtectedClass4

  class ProtectedClass5 extends ProtectedClass4

  protected class ProtectedClass6 extends ProtectedClass4

}

package ScopeProtectedB {

  class ProtectedClass4B extends ScopeProtectedA.ProtectedClass1(1)
  //class ProtectedClass4B1 extends ScopeProtectedA.ProtectedClass4 //Cannot access a protected class from other package
}


object ProtectedVisibilityExample extends App {

  val protectedField = new ScopeProtectedB.ProtectedClass4B()

}
