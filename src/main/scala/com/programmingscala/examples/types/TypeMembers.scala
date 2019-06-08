package com.programmingscala.examples.types


//When the type is used in a class it is called Type member.
//Type members can be viewed as duals of generics since much of the things we
// can do with generics can be done with abstract type members

abstract class TypeMembers {
  type T //Simple abstract type

  val ten : T
  //What this actually means is
  //val ten : T >: Nothing <: Any

  def printItem(t : T) = { println(s"t is ${t}")}

}

class TestInt extends TypeMembers {
  type T = Int

  override val ten: Int = 10
}

class TestString extends TypeMembers {
  type T = String
  override val ten: String = "ten"
}

//This is the same as
abstract class TypeParameters[A] {
  val ten : A //Simple parameterised type
}

class TestIntTypeP extends TypeParameters[Int] {
  override val ten = 10
}

class TestStringTypeP extends TypeParameters[String]{
  override val ten = "ten"
}



object Test1 extends App {
  val d = new TestString
  val c = new TestInt
  val a = new TestIntTypeP
  val b = new TestStringTypeP

  d.printItem(d.ten)


  c.printItem(c.ten)

  println(a.ten)
  println(b.ten)
}


