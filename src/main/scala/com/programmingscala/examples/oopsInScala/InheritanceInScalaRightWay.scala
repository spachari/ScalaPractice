package com.programmingscala.examples.oopsInScala

case class AddressN (number : Int, street : String, city : String)

object AddressN {
  //def apply(number: Int, street: String, city: String): AddressN = new AddressN(number, street, city)

  def apply(city : String) : AddressN = new AddressN(zipToNumber, zipToStreet, city)

  def zipToStreet : String = "Unknown"
  def zipToNumber : Int = 0
}

trait PersonState {
  val name : String
  val age : Option[Int]
  val address : Option[AddressN]
}

class PersonN (
              val name : String,
              val age : Option[Int] = None,
              val address : Option[AddressN] = None
              ) extends PersonState


trait EmployeeState {
  val title : String
  val manager : Option[EmployeeN]
}

class EmployeeN (
                val name : String,
                val age : Option[Int] = None,
                val address : Option[AddressN] = None,
                val title : String,
                val manager : Option[EmployeeN]
                ) extends PersonState with EmployeeState


object InheritanceInScalaRightWay extends App {

  val sriniAddress1 = AddressN(20, "21, Buckfast Road", "Morden")

  val address2 = AddressN("California")

  val sriniCeo = new EmployeeN("Srinivas", Some(38), Some(sriniAddress1), "ceo", None)

  val kirthikaCeo = new PersonN("kirthika", Some(38), Some(sriniAddress1))

  val markEmployee = new EmployeeN("Mark Duggan", Some(24), Some(address2), "developer", Some(sriniCeo))

  val lisaMarkWife = new PersonN("Lisa Duggan", Some(22), Some(address2))



}
