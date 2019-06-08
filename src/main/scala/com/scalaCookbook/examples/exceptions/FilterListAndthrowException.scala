package com.scalaCookbook.examples.exceptions

 class LessThanZeroException(message : String) extends Exception(message) {
  def printMessage() = println(s"ERROR : ${message}")
}

object FilterListAndthrowException extends App {

  val list = List(1,2,3, -3 , 0)

  try {
    list.foreach{ case x => if (x < 0) throw new LessThanZeroException(s"$x is less than 0. Please replace it with a new one")}
  }
  catch {
    case x : LessThanZeroException => x.printMessage()
  }

  case class Person(name : String, age : Int)
  case class Student(name : String, marks : Int)

  val srini = new Person("Srinivas", 38)
  val kirthi = new Person("Kirthika", 38)
  val sadhiv = new Person("Sadhiv", 38)
  val sadhana = new Person("Sadhana", 38)

  val sriniStudent = new Student("Srinivas", 100)
  val sadhanaStudent = new Student("Sadhana",  90)

  val persons = List(srini, kirthi, sadhiv, sadhana)
  val students = List(sriniStudent, sadhanaStudent)

  val output = persons.map(x => students.map{case y => (x,y)}).flatten

  output.foreach(println)

  println(output)

  val output1 = persons.map(x => students.map{case y => (x,y)}).flatten.filter{case(x,y) => x.name != y.name}

  output1.foreach(println)

  println("------------------")
  val output2 = persons.map(x => students.map{case y => (x,y)}).flatten.filter{case(x,y) => x.name == y.name}

  output2.foreach(println)

  val output3 = persons.map(x => students.map{case y => (x,y)}).flatten.filter{case(x,y) => x.name != y.name}
  println("------------------")

  output3.foreach(println)


  val studentMap = students.flatMap(x => Map(x.name -> x.marks)).toMap

  studentMap.foreach(x => println(x._1, x._2))

  val output4 = persons.map(x => if (studentMap.getOrElse(x.name,"") == "") Some(x) else None).flatten

  println(output4)

}
