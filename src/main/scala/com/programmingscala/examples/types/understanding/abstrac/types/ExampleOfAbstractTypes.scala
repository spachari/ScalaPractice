package com.programmingscala.examples.types.understanding.abstrac.types

trait exampleTrait {
  type t1 //t1 is uncontratined
  type t2 >: t3 <: t1 //t2 is between t3 and t1, Whatever t1 becomes, it must be a superclass of t2 (or equal to it),
                      // and t3 must be a subclass of t2 (or equal to it).
  type t3 <: t1 //The above line is not an excuse for not declaring explicitly that t3 is a subtype of t1
  type t4 <: Vector[t1]

  val v1 : t1
  val v2 : t2
  val v3 : t3
  val v4 : t4
}

trait T1 {val name1 : String}
trait T2 extends T1 { val name2 : String }
case class C(name1 : String, name2: String) extends T2

//Let's use it here
object Test extends exampleTrait with App {
  type t1 = T1
  type t2 = T2
  type t3 = C
  type t4 = Vector[t1]

  val v1 = new T1 { val name1 = "Srinivas" }
  val v2 = new T2 { val name2 = "Pachari"; val name1 = "Srinivas" }
  val v3 = C("Srinivas", "Pachari")
  val v4 = Vector(C("Srinivas","Pachari"))


}

