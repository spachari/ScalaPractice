package com.programmingscala.examples.scalaObjectSystem.linearization

class Z1 {
  def m = print("Z1 ")
}

trait Y1 extends Z1 {
  override def m: Unit = { print("Y1 "); super.m}
}

trait Y2 extends Z1 {
  override def m: Unit = { print("Y2 "); super.m }
}

trait Y3 extends Z1 {
  override def m: Unit = { print("Y3 "); super.m }
}

class Z2A extends Y2 {
  override def m: Unit = { print("Z2A "); super.m }
}


class Z2B extends Z2A with Y1 with Y2 with Y3 {
  override def m: Unit = { print("Z2B "); super.m }
}


object LinearisationExample4 extends App {

  def calcLinearization(obj : Z1, name : String) = {
    print(s"${name} ")
    obj.m
    print(" AnyRef ")
    println(" Any")
  }

  calcLinearization(new Z2B,"Z2B :")
  calcLinearization(new Y3 {}, "Y3 :")
  calcLinearization(new Y2 {}, "Y2 :")
  calcLinearization(new Y1 {},"Y1 :")
  calcLinearization(new Z2A, "Z2A :")
  calcLinearization(new Z1, "Z1 :")

}
