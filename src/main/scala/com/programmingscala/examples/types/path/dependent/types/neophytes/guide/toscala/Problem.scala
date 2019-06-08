package com.programmingscala.examples.types.path.dependent.types.neophytes.guide.toscala

class A {
  class B

  var b : Option[B] = None
}



object NeophytesGuideToScala {

  val a1 = new A
  val a2 = new A

  val b1 = new a1.B
  val b2 = new a2.B

  a1.b = Some(b1)

  //This will not work in scala
  //a1.b = Some(b2)

  //Why do we need scala to not let access from one class's inner class with another. An example



}
