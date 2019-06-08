package com.scalaCookbook.examples

case class Persons (firstName : String, lastName : String, age : Int) {
  override def toString = {
    if (this.firstName != Nil)
    s"Person's first name is ${firstName} and last name is ${lastName} and age is ${age}"
    else
      s"Person does not have a firstname but the age provided is ${age}"
  }

  def printThis = { println(this) }

  printThis
}

object Persons {
  def apply () = new Persons ("<no name>", "", 0)
  def apply (firstName : String, lastName : String) = new Persons(firstName, lastName, 0)
  def apply(age : Int) = new Persons("<no name>", "", age)
}

object CaseClassAuxillaryConstructors extends App {
  val p = Persons("Srinivas", "Pachari", 10)
  val q = Persons()
  val r = Persons("Sadhana","Srinivas")
  val s = Persons(100)
}
