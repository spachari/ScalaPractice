package com.programmingscala.examples.patternmatching

object PatternMatchingOnCaseClasses extends App {

  case class Address(street: String, city: String, country: String)
  case class Person(name: String, age: Int, address: Address)

  val alice   = Person("Alice",   25, Address("1 Scala Lane", "Chicago", "USA"))
  val bob     = Person("Bob",     29, Address("2 Java Ave.",  "Miami",   "USA"))
  val charlie = Person("Charlie", 32, Address("3 Python Ct.", "Boston",  "USA"))

  for (person <- Seq(alice, bob, charlie)) {
    person match {
      case Person("Alice",_, Address(_,"Chicago",_)) => println("Hello Alice from Chicago")
      case Person("Bob", _, Address("2 Java Ave.",  "Miami",   "USA")) => println("Hello Bob from Miami")
      case Person(name, age,Address(_,_,_)) => println("Hello whoever from whereever")
    }
  }

  for (person <- Seq(alice, bob, charlie)) {
    person match { //@ is for extracting fields
      case p @ Person("Alice",_, Address(_,"Chicago",_)) => println("Hello Alice from Chicago")
      case p @ Person("Bob", _, a @ Address(street, city, country)) =>
        println(s"Hello Bob from ${a.country}")
      case p : Person => println("Hello whoever from whereever") //: is for checking the type if it is Person
    }
  }

}
