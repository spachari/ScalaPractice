package com.programmingscala.examples.types.path.dependent.types

package p1 {
  object O1 {
    object O2 {
      val name = "Srini on O2"
    }

    class C1 {
      val name = "Srini in C1"
    }
  }
}

object ReachingANestedType extends App {

  val name = p1.O1.O2.name //It is stable so this is fine

  val name2 = new p1.O1.C1
  type C1 = p1.O1.C1

  //val name3 = p1.O1.C1 //Cannot use unstable element in it's last position.

}
