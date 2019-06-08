package com.scalatypes

import com.scalatypes.ViewBounds.f

object ConvertAListToAnArray extends App {

  //Let's try with some other objects
  case class Person(name : String)

  val familyList = List(Person("Srinivas"),Person("Pachari"))

  def createArray(personList : List[Person]): Array[Person] = {
    var familyArray = f[Person](0)

    for (l <- personList)
    {
      familyArray = familyArray :+ l
    }
    familyArray
  }

  val familyArray = createArray(familyList)

  familyArray.foreach(println)
  println(familyArray.size)

}
