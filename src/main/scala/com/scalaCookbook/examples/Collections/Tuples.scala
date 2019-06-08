package com.scalaCookbook.examples.Collections

case class Persons(val firstName : String, val lastName : String)

object Tuples extends App {
  val personTupleWithID = (1, new Persons("Srinivas", "Pachari"))

  val kirthikaInMarketing = (1, "Marketing", new Persons("Kirthika", "Jeyaraman"))

  val t = personTupleWithID

  println(t._1)
  println(t._2.firstName)
  println(t._2.lastName)


  //We can assign them in a pattern matching way, so that we can take bits and pieces from the tuple itself
  val (x,_,z) = kirthikaInMarketing

  println(x)
  println(z)

  //Because of that pattern, we can now assign x and z to any proffession
  val kirthikaInMedicine = (x,"Doctor",z)
  val kirthikaInCineField = (x,"Actress",z)

  val u = kirthikaInCineField.productIterator

  println("Iterating through a tuple")
  u.foreach(println)

  println("We can obviously make the iterator permanent by making converting the productIterator to a permanent Array")

  val tupleToArray = kirthikaInCineField.productIterator.toArray
  for(c <- tupleToArray) {
    println(c)
  }

  //Pattern matching on tuples
  def patternMatchTuples (s : Any) = {
    s match {
      case s : String => println("This is String")
      case s : Int => println("This is Int")
      case (_, x, Persons("Srinivas", "Pachari")) => println("This is Srinivas and his profession is " + x)
      case (1, "Doctor", Persons("Kirthika","Kirthika")) => println("This is Kirhtika and her profession is Doctor")
    }
  }

  patternMatchTuples((100,"Doctor", Persons("Srinivas", "Pachari")))

}
