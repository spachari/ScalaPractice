package com.programmingscala.examples.functionalprogramming

case class Persons(name : String)

object IsDefinedInOptions extends App {

  val person : Option[Persons] = Some(Persons("Srinivas"))

  //Will give true for a value and false for None
  println(person.isDefined)

  val noPerson : Option[Persons] = None

  println(noPerson.isDefined)

  val getName = if (person.isDefined) person.get.name else None

  //Other way of doing this is
  val getNameCollect = person collect { case person => person.name }

  println(getNameCollect)

  val getnoPersonName = noPerson collect { case person => person.name }

  println(getnoPersonName)
  //Working this on a list

  val personsList = List(Some("Srinivas"), None, Some("kirthika"))

  val output = personsList.filter(_.isDefined).map(x => x.get + " is awesome")

  output.foreach(println)

  val outputCollect = personsList.collect{ case Some(person) => person + " again is awesome"} //pattern matching

  outputCollect foreach(println)

}
