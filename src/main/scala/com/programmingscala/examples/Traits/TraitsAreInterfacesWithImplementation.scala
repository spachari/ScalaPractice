package com.programmingscala.examples.Traits

class Base { def b = "b" }
trait Cool { def c = "c" }
trait Awesome { def a = "a" }

class BA extends Base with Awesome
class BC extends Base with Cool



object TraitsAreInterfacesWithImplementation extends App {

  val ba : BA = new BA()
  val bc : Base with Cool = new BC

  val b1 : Base = ba
  val b2 : Base = bc

  println(ba.a)
  println(bc.c)
    println(b1.b)


}
