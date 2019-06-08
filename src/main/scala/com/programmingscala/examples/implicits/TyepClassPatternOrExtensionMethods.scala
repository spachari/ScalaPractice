package com.programmingscala.examples.implicits


//This is also called extension methods
//From another perspective, this capability is called ad hoc polymorphism,
// because the polymorphic behavior of toJSON is not tied to the type system, as in subtype polymorphism,
// the conventional object-oriented inheritance.




case class Address1(street : String, city : String)
case class Person(name : String, address : Address1)

//Student does not have the method
class Students(names : String, marks : Int) extends Person(name = "Srinivas", address = Address1("23 buck", "london"))

trait toJSON {
  def toJSON(level : Int = 0) : String

  val INDENTATION = "  "
  def indentation(level : Int = 1) : (String, String) = {
    (INDENTATION * level, INDENTATION * (level + 1))
  }
}

object ImplicitsToJSON {
  implicit class AddressToJSON(address : Address1) extends toJSON {
    override def toJSON(level: Int): String = {
      val (outdent, indent) = indentation(level)
      println(s"${indent} + ${outdent}")
      s"""{
         |${indent}street : ${address.street}
         |${indent}city : ${address.city}
         |${outdent}}""".stripMargin
    }
  }

  implicit class PersonTOJSON(person : Person) extends toJSON {
    override def toJSON(level: Int): String = {
      val (outdent, indent) = indentation(level)
      println(s"${indent} + ${outdent}")
      s"""{
         |${indent}name : ${person.name}
         |${indent}address : ${person.address.toJSON(1)}
         |}
       """.stripMargin
    }
  }
}

//The Type Class Pattern is ideal for situations where certain clients will benefit from the “illusion” that a set of classes
// provide a particular behavior that isn’t useful for the majority of clients. Used wisely, it helps balance the needs of
// various clients while maintaining the Single Responsibility Principle.

object TyepClassPattern extends App {

  import ImplicitsToJSON._

  val myaddress = Address1("86 Ridge Langley", "Croudon")
  println(myaddress.toJSON())

  val person = Person("Srinivas", myaddress)
  println(person.toJSON())

  val student = new Students("Srinivas", 100)
  println(student.toJSON())


}
