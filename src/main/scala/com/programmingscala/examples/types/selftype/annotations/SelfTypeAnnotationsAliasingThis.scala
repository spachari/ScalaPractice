package com.programmingscala.examples.types.selftype.annotations


class C1 {
  selfExample =>
  def talk (message: String) = { println(s"C1.talk + ${message}") }

  class C2 {
    class C3 {
      def talk(message : String) = { selfExample.talk(s"C3.talk ${message}")}
      //We need this alias selfExample to access C1's talk method
      //We cannot use super.talk because it they are not parent child relationship
    }
    val c3 = new C3
  }

  val c2 = new C2
}

object SelfTypeAnnotationsAliasingThis extends App {

  val c1 = new C1
  c1.talk("Hello ")
  c1.c2.c3.talk("Hello ")

}
