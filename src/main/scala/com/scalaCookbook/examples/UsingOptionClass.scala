package com.scalaCookbook.examples


class Address (var houseNumber : String, var streetName : String, var pinCode : String)

class Human (var name : String, var sex : String, var address : Option[Address] = None) {
   override def toString = s"Human's name is ${name} and sex is ${sex}"

  def printThis = { println(this)}
  def printThat (that : Human) = {println(that)}
  printThis
  //printThat(that)
}

object UsingOptionClass extends App {
  val p = new Human("Srinivas", "M")
  val q = new Human("Kirthika", "F", Some(new Address("21", "Singapore Street", "625 450")))

  q.address.foreach{c => println(c.houseNumber)
                                 println(c.streetName)
                                 println(c.pinCode)}


}
