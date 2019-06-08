package com.programmingscala.examples.implicits

case class Student(name : String) (implicit val a : String )

object ImplicitInCaseClass extends App {

  val extra = "hobby"

  val name = new Student("Srinivas")(extra)

}
