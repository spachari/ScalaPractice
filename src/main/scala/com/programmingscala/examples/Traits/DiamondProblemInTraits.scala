package com.programmingscala.examples.Traits

trait A { def common = "A" }

trait B extends A {
  override def common: String = "B"}

trait C extends A {
  override def common: String = "C"}

class D1 extends B with C
class D2 extends C with B
class E extends A with B with C

object DiamondProblemInTraits extends App {

  val d1 = new D1
  println(d1.common)

  val d2 = new D2
  println(d2.common)

  val e = new E
  println(e.common)

}

//The linearisation algorith works like this
// start with D1:
//B with C with <D1>

// expand all the types until you rach Any for all of them:
//(Any with AnyRef with A with B) with (Any with AnyRef with A with C) with <D1>

// remove duplicates by removing "already seen" types, when moving left-to-right:
//(Any with AnyRef with A with B) with (                            C) with <D1>

// write the resulting type nicely:
//Any with AnyRef with A with B with C with <D1>

