package com.scalaCookbook.examples.WebServices.Lift

import net.liftweb.json.JsonDSL._
import net.liftweb.json.{DefaultFormats, _}

sealed case class Person2(name : String, address: Address2)
{
  var friends = List[Person2]()
}

sealed case class Address2(name : String, city : String)

object ConvertingAnObjectWithCollectionsToJsonPart2 extends App {


  implicit val formats = DefaultFormats

  val merc = Person2("Mercedes", Address2("Somewhere", "KY"))
  val mel = Person2("Mel", Address2("Lake Zurich", "IL"))
  val friends = List(merc, mel)
  val p = Person2("Alvin Alexander", Address2("Talkeetna", "AK"))
  p.friends = friends

  val json = ("person" ->
                 ("name" -> p.name) ~
                   ("address" ->
                     ("name" -> p.address.name) ~
                       ("city" -> p.address.city)) ~
                   ("friends" -> friends.map{f =>
                     ("name" -> f.name) ~
                       ("address" ->
                         ("name" -> f.address.name) ~
                           ("city" -> f.address.city))
                   })

    )

  println(prettyRender(json))

  //Let's create a separate method for reading the each elements

  val json1 =
    ("person" ->
      ("name" -> p.name) ~
        getAddress(p.address) ~
        getFriends(p)
      )


  def getFriends(person: Person2) = {
    ("friends" ->
      person.friends.map { f =>
        ("name" -> f.name) ~
          getAddress(f.address)
      })
  }



    def getAddress(address: Address2) = {
      ("address" ->
        ("name" -> address.name) ~
          ("city" -> address.city))
    }

    println(prettyRender(json1))

}
