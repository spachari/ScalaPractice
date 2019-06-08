package com.scalaCookbook.examples.Functions

//Try will give out either Succcess() or Failure
//So in result, we can use getOrElse.

class Family {
  val map = Map("Srinivas" -> "Daddy", "Kirthika" -> "Mummy", "Sadhana" -> "Daughter", "Sadhiv" -> "Son")

  def getValuesOrNull (x : String) : String = {
    scala.util.Try {
      val output = map(x)
      output
    }.getOrElse("Not a FamilyMember")
  }
}

object TryMethodInScala extends App {
  val f = new Family
  val person = "Srinivas"
  println(f.getValuesOrNull(person))

  val person1 = "Sri"
  println(f.getValuesOrNull(person1))
}
