package com.programmingscala.examples.visibility.rules.scoped.Private.and.Protected.visibility

import com.programmingscala.examples.visibility.rules.scoped.Private.and.Protected.visibility.scopeB.Class2B

package scopeA {
  class Class1 {
    private[scopeA] val scopeA_privateField = 1
    protected[scopeA] val scopeA_protectedField = 2
    private[Class1] val class1_privateField = 3
    protected[Class1] val class1_protectedField = 4
    private[this] val this_privateField = 5
    protected[this] val this_protectedField = 6
  }

  class Class2 extends Class1 {
    val field1 = scopeA_privateField
    val field2 = scopeA_protectedField
    val field3 = class1_protectedField
    //val field4 = class1_privateField //Cannot access class level private field
    val field5 = this_protectedField
    //val field6 = this_privateField //Cannot access this object's private field
  }
}

package scopeB {
  class Class2B extends scopeA.Class1 {
   val field1 = scopeA_protectedField
    //val field2 = scopeA_privateField //Cannot access other class members private field
    val field3 = class1_protectedField
    //val field4 = class1_privateField //Cannot access other class members private field
    val field5 = this_protectedField
    //val field6 = this_privateField //Cannot access other class members private field
  }
}


object ScopeInheritance extends App {

  val class2B = new Class2B

  println(class2B.field1)

}
