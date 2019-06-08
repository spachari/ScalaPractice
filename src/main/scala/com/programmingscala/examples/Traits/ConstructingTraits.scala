package com.programmingscala.examples.Traits


//While the body of a trait functions as its primary constructor, traits don’t support an argument list for the primary
// constructor, nor can you define auxiliary constructors.


trait T1 {
  println(s" in T1 x = ${x}")
  val x = 1
  println(s" in T1 x = ${x}")
}

trait T2 {
  println(s" in T2 y = ${y}")
  val y = "T2"
  println(s" in T2 x = ${y}")
}

class Base12 {
  println(s" in Base12 b = ${b}")
  val b = "Base12"
  println(s" in Base12 b = ${b}")
}

class C12 extends Base12 with T1 with T2 { //Implementation will always be from left to right
  println(s" in C12 c = ${c}")
  val c = "c12"
  println(s" in C12 c = ${c}")
}

object ConstructingTraits extends App {

  println("Creating C12")
  val c12 = new C12
  println("After creating C12")
  val c122 = new C12

}
