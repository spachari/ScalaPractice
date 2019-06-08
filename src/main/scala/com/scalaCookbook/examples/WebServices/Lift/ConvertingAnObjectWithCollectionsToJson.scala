package com.scalaCookbook.examples.WebServices.Lift

import net.liftweb.json.JsonDSL._
import net.liftweb.json._


sealed case class Person1(name : String, address: Address1)
{
  var friends = List[Person1]()
}

sealed case class Address1(name : String, city : String)


object ConvertingAnObjectWithCollectionsToJson extends App {

implicit val formats = DefaultFormats

  val merc = Person1("Mercedes", Address1("Somewhere", "KY"))
  val mel = Person1("Mel", Address1("Lake Zurich", "IL"))
  val friends = List(merc, mel)
  val p = Person1("Alvin Alexander", Address1("Talkeetna", "AK"))
  p.friends = friends

  //define the json output
  val json =
    ("person" ->
      ("name" -> p.name) ~
        ("address" ->
          ("city" -> p.address.name) ~
            ("state" -> p.address.city)) ~
        ("friends" ->
        friends.map{f =>
          ("name" -> f.name) ~
            ("address" ->
            ("name" -> f.address.name) ~
            ("city" -> f.address.city))
        })
          )


  println(prettyRender(json))


  //First let's disect this one
  val json1 =
    ("person" ->
      ("name" -> p.name) ~
        ("address" ->
          ("name" -> p.address.name) ~
            ("city" -> p.address.city))) ~
      ("friends" ->
        friends.map{ f =>
          ("name" -> f.name) ~
            ("address" ->
              ("name" -> f.address.name) ~
                ("city" -> f.address.city))
        }
        )

  println(prettyRender(json1))

  val json2 = ("name" -> p.name)

  println(prettyRender(json2))
}
