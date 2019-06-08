package com.programmingscala.examples.visibility.rules.scoped.Private.and.Protected.visibility

package scopePackageLevelScopeForPrivateMembersA {

  class PrivateClass1 {
    private[scopePackageLevelScopeForPrivateMembersA] val privateField = 1

    class Nested {
      private[scopePackageLevelScopeForPrivateMembersA] val nestedField = 1
    }

    private[scopePackageLevelScopeForPrivateMembersA] val nested = new Nested //accessing inner class
  }

  class PrivateClass2 extends PrivateClass1 {
    val field1 = privateField
    val field2 = nested.nestedField
  }

  class PrivateClass3 {
    val privateClass1 = new PrivateClass1
    val field1 = privateClass1.privateField
    val field2 = privateClass1.nested.nestedField
  }
}

package scopePackageLevelScopeForPrivateMembers2A {
  class PrivateClass4 {
    //private[scopePackageLevelScopeForPrivateMembersA] val field1 = 1 Cannot access
    private[scopePackageLevelScopeForPrivateMembers2A] val field2 = 1
  }

  class PrivateClass5 {
    val privateField4 = new scopePackageLevelScopeForPrivateMembers2A.PrivateClass4
    //val field1 = privateField4.field1
    val field2 = privateField4.field2
  }

}

package scopePackageLevelScopeForPrivateMembersB {

  class PrivateClass1B extends scopePackageLevelScopeForPrivateMembersA.PrivateClass1 {
    //val field1 = privateField //Cannot access the parent class level scoped member directly even from child class
    val privateClass1 = new scopePackageLevelScopeForPrivateMembersA.PrivateClass1
    //val field1 = privateClass1.privateField //Cannot access class level scoped member from another package
  }
}

object PackageLevelScopeForPrivateMembers {

}
