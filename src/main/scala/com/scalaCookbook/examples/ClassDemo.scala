package com.scalaCookbook.examples


case class Person (var firstName : String, var lastName : String) {
  println("the constructor begins")

  val HOME = System.getProperty("user.home")
  var age = 0

  override def toString = s"Person ${firstName} and ${lastName}'s age is ${age}"
  def printFullName = { println(this) }
  def printHome = { println("$HOME = " + HOME)}
  def printLastName = { println(this.lastName) }

  printFullName
  printHome
  printLastName
  println("Still inside the constructor")


}

object ClassDemo extends App
{
  val p = Person("Srinivas", "Pachari")
  p.firstName = "Scott"
  p.lastName = "Tiger"
  p.age = 30
  println(p)


  println(p.printFullName)
  println(p.printLastName)

  p.firstName_$eq("Srinivas")
  p.lastName_$eq("Srinivas")

  println(p)
}
