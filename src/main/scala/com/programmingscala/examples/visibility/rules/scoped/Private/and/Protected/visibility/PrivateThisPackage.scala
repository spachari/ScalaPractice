package com.programmingscala.examples.visibility.rules.scoped.Private.and.Protected.visibility


//When declaring a type with private[this], use of this effectively binds to the enclosing package, as shown here:
package scopeThisPackageA {
  private[this] class PrivateClass1

  package scopeThisPackageA2 {
    private[this] class PrivateClass2
  }

  //class PrivateClass3 extends PrivateClass1 //cannot extend a private class unless the child class is private
  //protected class PrivateClass4 extends PrivateClass1 //cannot extend a private class unless the child class is private

  private class PrivateClass5 extends PrivateClass1
  private[this] class PrivateClass6 extends PrivateClass1
  //private[this] class PrivateClass7 extends scopeThisPackageA2.PrivateClass2 //cannot extend sub package private[this] class


}

package scopeThisPackageB {
  //class PrivateClass1B extends scopeThisPackageA.PrivateClass1 cannot extend other package private[this] class
}


object PrivateThisPackage extends App {

  //val obj = new scopeThisPackageA.PrivateClass1 //Cannot access private[this] class from outside

}


//Hence, when applied to types, private[this] is equivalent to Java’s package private visibility.