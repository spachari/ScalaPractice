package com.scalaCookbook.examples

//Defining a class as a case class results in a lot of boilerplate code being generated, with the following benefits:
//apply - 1. An apply method is generated, so you don’t need to use the new keyword to create a new instance of the class.

//Accessors/Mutators - Accessor methods are generated for the constructor parameters because case class constructor parameters are val by default.
// Mutator methods are also generated for parameters declared as var.

// toString - A good, default toString method is generated.

// unapply - An unapply method is generated, making it easy to use case classes in match expressions.

//equals - equals and hashCode methods are generated.

//copy - A copy method is generated.

case class StudentWithMarks (id : Int, name : String, sex : Char)

object CaseClassTheory extends App {
  val srini = StudentWithMarks(1, "Srinivas", 'M')
  println(srini.toString) //toString

  val hannah = StudentWithMarks(2, "Hannah", 'F')

  println(kirthika)

  println("The equals method ... ")
  println(hannah.name == srini.name)

  val kirthika = hannah.copy(name = "kirthika")
  println(kirthika)

  hannah match { case StudentWithMarks (a,b,c) => if (c == 'M') println(s"Student's id is ${a} and his name is ${b}")
                                                  else println(s"Student's id is ${a} and her name is ${b}") }
}
