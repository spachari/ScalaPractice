package com.scalaCookbook.examples.Objects

case class Student (id : Int, firstName : String, lastName : String)
{
  override def toString: String = s"The student's firstName is ${firstName} and lastname is ${lastName}" +
    s" and id is ${id}"

  def printThis = { println(this)}
  printThis
}

object Student {
  def apply (id : Int, firstName : String) = new Student(id, firstName, "Unknown")
  def apply (firstName : String, lastName : String) = new Student(1, firstName, lastName)
  def apply(id : Int) = new Student(id, "Unknown", "Unknown")
  def apply (firstName : String) = new Student(1,firstName, "Unknown")
  //def apply (lastName : String) = new Student(1,"Unknown",lastName)
}

object ImplementingApplyMethodCaseClass extends App {
  val id = Student(1)
  val firstName = Student("Srinivas")
  val fandlname = Student("Srinivas", "Pachari")
  val idandname = Student(1,"Srinivas")

}
