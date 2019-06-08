package com.scalaCookbook.examples

class Outer {
  class Inner {
    var x = 1
  }
}

object OuterObject {
  var y = 1
  class InnerClass {
    var x = 1
  }
}

class OuterClass {
  var y = 1
  object InnerObject {
    var x = 1
  }
}

object InnerClassInScala extends App {
  val out1 = new Outer
  val in1 = new out1.Inner //In scala, Inner classes are bound to the outer object

  println(in1.x)

  var outOb = new OuterObject.InnerClass
  println(outOb.x)

  var outCl = new OuterClass
  println(outCl.y)


}
