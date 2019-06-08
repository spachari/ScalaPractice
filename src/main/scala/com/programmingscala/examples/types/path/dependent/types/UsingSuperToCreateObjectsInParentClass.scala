package com.programmingscala.examples.types.path.dependent.types

class D4 {
  class D5
}

class D6 extends D4 {
  val d5 = new D5
  val d51 = new super.D5
}

object UsingSuperToCreateObjectsInParentClass {

}
