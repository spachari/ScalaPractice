package com.scalaCookbook.examples


//class Address (var houseNumber : String, var streetName : String, var pinCode : String)

class Human1 (var name : String, var address : Address, var sex : Char) {

  def this (name : String) //This will never be accessed
  {
    this(name,null, 'D')
    println("Inside auxillary constructor ...")
  }

  println("Inside HUMAN1 constructor")
  override def toString: String = if
  (address == null)
    s"Human's name is ${name}"
  else
    s"Human's name is ${name} and address is ${address.pinCode}"

  def printThis = { println(this) }
  printThis
}

class Person1 (name: String, address : Address, sex : Char, var age : Int) extends Human1(name,address, sex)
{

  println("Inside PERSON1 constructor")
  override def toString: String = { s"The person's name is ${name} and " +
    s"address is ${address.houseNumber}, ${address.streetName}" +
    s" and ${address.pinCode} and age is ${age}" }

  override def printThis = { println(this) }
  printThis
}

trait God {
 var name : String
}

class PersonWithNoAddress(name : String, var age : Int) extends Human1(name) //Eventhough we have given only name, this will never be accessed
{
  override def toString: String = { s"The person's name is ${name} and age is ${age}" }

  override def printThis: Unit = { println(this) }
  printThis
}

object SubclassUsingConstructorVariables extends App
{

  val a = new Human1("Srinivas")

  val h = new Human1("Srinivas", new Address ("21","Buckfast Road","Morden"),'M')

  val s = new Person1("Srinivas", new Address ("21","Buckfast Road","Morden"),'M',30)

  println("-------------Pritning Human-----")
  println(s.name)
  println(s.age)
  println(s.address.houseNumber)
  println(s.address.streetName)
  println(s.address.pinCode)

  println("-------------Pritning PersonWithNoAddress-----")
  val srini = new PersonWithNoAddress("Srinivas", 37)

}
