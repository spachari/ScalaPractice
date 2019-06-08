package com.programmingscala.examples.oopsInScala

case class Address1(number : Int, street : String, city : Option[String])

case class PersonAndAddress(name : String, address : Address1) {
  def getCountry() = {
    require(isValidAddress(this.address), s"Cannot calculate country with the following input ${this.address}")
    if (this.address.city.getOrElse("") == "Morden")
      {
        "London"
      }
    else {
      "Somewhere else"
    }
  }

  def isValidAddress(address1: Address1) : Boolean = {
    if (address1.city != None) true else false
  }

  override def toString: String = s"${name} ${address}"

}


object RequireMethodInMethod extends App {

  val p = new PersonAndAddress("Srinivas", Address1(20, "Buckfast Road", Some("Morden")))

  println(p)

  val q = new PersonAndAddress("Srinivas", Address1(20, "Buckfast Road", None))

  println(q.getCountry())
}
