package com.scalaCookbook.examples.Generics

class test extends Function1[String, Any] {

  def myToInt (s : String) = {
    try{
      s.toInt
    }
    catch {
      case e : Exception => s"COuld not convert ${s}"
    }
  }
  override def apply(v1: String) = myToInt(v1)
}


object testing extends App {

  val t = new test
  val v = t.apply("100")

  println(v)

}