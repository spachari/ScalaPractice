package com.scalaCookbook.examples

class PrivatePerson private (name : String) {
  override def toString = s"Private person's name is ${name}"

  def printThis = { println(this) }
  printThis
}

object PrivatePerson {
  val privatePerson = new PrivatePerson("Srinivas")
  def getPrivatePersonInstance = privatePerson
}

object SingletonObjectScala extends App {
  //this will not work
  //val p = new PrivatePerson()

  val srinivas = PrivatePerson.getPrivatePersonInstance

}
