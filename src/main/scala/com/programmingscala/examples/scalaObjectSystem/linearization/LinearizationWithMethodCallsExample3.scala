package com.programmingscala.examples.scalaObjectSystem.linearization

class C21 {
  def m(previous : String) = println(s"C21(${previous})")
}

trait M21 extends C21 {
  override def m(p : String) = {super.m(s"M21(${p})")}
}

trait M22 extends C21 {
  override def m(p: String): Unit = super.m(s"M22(${p})")
}

trait M23 extends C21 {
  override def m(p: String): Unit = super.m(s"M23(${p})")
}

class C22 extends M21 with M22 with M23  {
  override def m(p: String): Unit = super.m(s"C22(${p})")
}

object LinearizationWithMethodCallsExample3 extends App {

  val c = new C22

  c.m("")

}
