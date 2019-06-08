package com.scalaCookbook.examples.Objects


class Person {
  var firstName : String = _
  var lastName : String = _
  override def toString: String = s"The person's firstName is ${firstName} and lastName is ${lastName}"

  //def printThis = {println(this)}
  //printThis
}

object Person {
  def apply(firstname : String, lastName : String) : Person = {
    var p = new Person
    p.firstName = firstname
    p.lastName = lastName
    p
  }

  def apply(firstName : String) : Person = {
    var p = new Person
    p.firstName = firstName
    p.lastName = "UNKNOWN"
    p
  }

}

object ImplementingApplyMethod extends App {
  val p = Person("Srinivas")
  val q = Person("Srinivas", "Pachari")

  println(p.toString)
  println(q.toString)


}
