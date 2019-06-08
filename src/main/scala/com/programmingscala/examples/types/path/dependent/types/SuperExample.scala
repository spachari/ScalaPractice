package com.programmingscala.examples.types.path.dependent.types

trait X {
  def setXX(x : String) = {}
}

class D1 {
  var x = "1"
  def setX1(x:String): Unit = this.x = x
  def setX2(x:String): Unit = D1.this.x = x
}

class D2 extends D1
class D3 extends D2 with X {
  def setX3(x : String) : Unit = super.setX1(x)
  def setX4(x : String) : Unit = D3.super.setX1(x)  //D3.super is equivalent to super in this example.
  def setX5(x : String) : Unit = D3.super[D2].setX1(x)
  def setX6(x : String) : Unit = D3.super[X].setXX(x)

  //def setX7(x : String) : Unit = D3.super[D1].setX1(x) //Error:(20, 34) D1 does not name a parent class of class D3

  //def setX8(x : String) : Unit = D3.super.super.setX1(x) //Wrong because this is not correct syntax
}



object SuperExample extends App {

  val d3 = new D3
  println(d3.setX3("test"))

  

}
