package com.programmingscala.examples.oopsInScala


//This is a best practice of creating static variable in scala

case class StudentMarks (
                        name : String,
                        standard : String,
                        scienceMarks : Int,
                        mathsMarks : Int,
                        englishMarks : Int
                        )

object StudentMarks {

  //You create it in the object
  val DefaultStudent = new StudentMarks("noName", "N/A",0,0,0)

}

object StaticVariablesInScala extends App {

  val s = StudentMarks.DefaultStudent

  println(s)

}
