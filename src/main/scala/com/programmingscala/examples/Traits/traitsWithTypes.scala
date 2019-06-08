package com.programmingscala.examples.Traits


//Trait can be used with types
case class Student (
                   val name : String,
                   val standard : String,
                   val marks : Int
                   )

trait PrintStudentName[A] {
  def printStudent(s : A)
}

object traitsWithTypes extends App {

  val student = new Student("Srinivas", "8", 100) with PrintStudentName[Student]
  {
    override def printStudent(s: Student): Unit = println(s"${s.name}")
  }

  val student2 = new Student("Srinivas", "8", 100)
  student.printStudent(student2)

}
