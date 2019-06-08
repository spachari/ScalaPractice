package com.programmingscala.examples.visibility.rules.scoped.Private.and.Protected.visibility

package scopePackageLevelPrivateA {

  private [scopePackageLevelPrivateA] class PrivateClassA

  package scopePackageLevelPrivateA2 {
    private [scopePackageLevelPrivateA] class PrivateClass2
    private [scopePackageLevelPrivateA2] class PrivateClass3
  }

  class PrivateClass4 extends PrivateClassA
  protected class PrivateClass5 extends PrivateClassA
  private class PrivateClass6 extends PrivateClassA

  private[this] class PrivateClass7 extends PrivateClassA
  private[this] class PrivateClass8 extends scopePackageLevelPrivateA2.PrivateClass2
  //private[this] class PrivateClass9 extends scopePackageLevelPrivateB.PrivateClass3 //Cannot access a class outside scope
}

package scopePackageLevelPrivateB {
  //class PrivateClassScopeB2 extends PrivateClassA //Cannot access a class outside scope
}

object PrivatePkgType {


}
