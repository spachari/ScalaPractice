package com.scalaCookbook.examples.WebServices.Lift

import net.liftweb.json.Serialization.write
import net.liftweb.json._


sealed case class Address(city : String, state : String)

sealed case class Work(name : String)

sealed case class Person(name : String, address : Array[Address], family : Map[String, String], work : Work)



object ConObjToJsonLiftJson extends App {

  val addresses = Array(
    new Address("Morden", "Surrey"),
    new Address("Tamil Nadu", "India"),
    new Address("Simei", "Singapore"))

  val family : Map[String, String]= Map("Father" -> "Srinivas",
    "Mother" -> "Kirthika",
    "Daughter" -> "Sadhana",
    "Son" -> "Sadhiv")

  val work = Work("Expedia")

  val person = new Person(("Srinivas"), addresses, family, work)


  implicit val formats = DefaultFormats
  val jsonString = write(person)
  println(jsonString)


}

