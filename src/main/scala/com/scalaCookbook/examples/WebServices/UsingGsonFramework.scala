package com.scalaCookbook.examples.WebServices

import com.google.gson.GsonBuilder
import scala.collection.mutable.ArrayBuffer


sealed case class Person3(name : String, address: Address3)
{
  var friends = ArrayBuffer[Person3]()
}

sealed case class Address3(name : String, city : String)


object UsingGsonFramework extends App {

  val merc = Person3("Mercedes", Address3("Somewhere", "KY"))
  val mel = Person3("Mel", Address3("Lake Zurich", "IL"))
  val friends = ArrayBuffer(merc, mel)
  val p = Person3("Alvin Alexander", Address3("Talkeetna", "AK"))
  p.friends = friends

  val gson = (new GsonBuilder()).setPrettyPrinting().create()
  println(gson.toJson(p))



}
