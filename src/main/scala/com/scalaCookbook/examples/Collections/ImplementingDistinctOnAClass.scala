package com.scalaCookbook.examples.Collections

class Person (var firstName : String, var lastName : String) {
  //The distinct uses toString, equals and hashCode under the scenes to get it. Once we implement them it will work
  override def toString: String = s"${firstName} ${lastName}"

  def isPerson (that : Any) = that.isInstanceOf[Persons]

  override def equals(that: scala.Any): Boolean = {
    that match {
      case that: Persons => this.isPerson(that) && this.hashCode() == that.hashCode()
      case _ => false
    }
  }

  override def hashCode(): Int = {
    val prime = 31
    var result = 1
    result = prime * result + lastName.hashCode
    result = prime * result + (if(firstName == null) 0 else firstName.hashCode)
    result
  }
}

object ImplementingDistinctOnAClass extends App {
  val x = Vector(1,1,1,2,3,4,5,5)
  val y = x.distinct.toSet

  val srinivas = new Persons("Srinivas", "Pachari")
  val srinivas1 = new Persons("Srinivas", "Pachari")
  val kithika = new Persons("kirthika", "Jeyaraman")
  val kithika1 = new Persons("kirthika", "Jeyaraman")

  val personList = List(srinivas, srinivas1, kithika, kithika1)
  println(personList.distinct)
}
