package com.programmingscala.examples.types.path.dependent.types


class C1 {
  var var1 : String = _
  def setVar1(s : String) = this.var1 = s
  def setVar2(s : String) = C1.this.var1 = s //this is actually a shorthand for C1.this

}

//Inside a type body, but outside a method definition, this refers to the type itself:

trait T1 {
  class C {
    val cvalue = 10
  }
  val c1 : C = new C
  val c2 : C = new this.C
  val output = c2.cvalue
}

//Here new this.C is for the trait T1 and creates T1's C

object ThisExample1 extends App {

  val c1 = new C1
  c1.setVar1("test")
  println(c1.var1)

  c1.setVar2("Srinivas")
  println(c1.var1)

}
