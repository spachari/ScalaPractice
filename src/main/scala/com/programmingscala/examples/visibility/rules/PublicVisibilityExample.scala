package com.programmingscala.examples.visibility.rules

package ScopePublicA {
  class PublicClass1 {
    val publicField = 1

    class Nested {           //Inner class
      val nestedField = 1
    }

    val nested = new Nested  //Accessing Inner class from outer class

  }

  class PublicClass2 extends PublicClass1 {
    val field2 = publicField + 1
    val field3 = new Nested().nestedField  //Note: new Nested() calls the class. new Nested calls the object
                                          //Child class accessing inner class
  }
}

package ScopeB {
  class PublicClass1B extends ScopePublicA.PublicClass1

  class UsingClass (val publicClass : ScopePublicA.PublicClass1) {
    def method = { println("Using class:  field : " + publicClass.publicField +
      " nested field : " + publicClass.nested.nestedField) }
  }
}

object PublicVisibilityExample extends App {

  val obj = new ScopeB.UsingClass(new ScopePublicA.PublicClass1)

  obj.method
}
