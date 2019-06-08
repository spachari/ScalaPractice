package com.scalaCookbook.examples.Methods

class Persons {
  protected var fname = ""
  protected var lname = ""

  def setFirstname (f : String) : this.type = {
    fname = f
    this
  }

  def setLastName (f: String) : this.type = {
    lname = f
    this
  }

  override def toString = { s"The person's firstName is ${fname} and lastname is ${lname}"}

}

class Employees extends Persons {
  protected var role = ""

  def setRole (f : String) : this.type = {
    role = f
    this
  }

  override def toString: String = { s"The employees name is ${fname + lname} and his role is ${role}" }

}

object FluentStyleProgramming extends App {
  val a = new Persons

  a.setFirstname("Srinivas")
  a.setLastName("Pachari")
  println(a.toString)

  val b = new Persons
  b.setFirstname("Srinivas")
    .setLastName("Pachari")
  println(b)

  val e = new Employees
  e.setFirstname("Srini").setLastName("Pach").setRole("Actor")
  println(e)
}
