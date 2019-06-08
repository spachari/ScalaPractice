package com.scalaCookbook.examples.WebServices.Lift

import net.liftweb.json._

case class MailServer (url : String, username : String, password : String)

object CreatingAScalaObjectFromJson extends App {

  implicit val formats = DefaultFormats

  val jsonString = """
  {
    "url": "imap.yahoo.com",
    "username": "myusername",
    "password": "mypassword"
  }
  """

  val jValue = parse(jsonString)

  val mailServer = jValue.extract[MailServer]

  //The JValue class is the root class in the Lift-JSON abstract syntax tree (AST),
  // and its extract method builds a case class instance from a JSON string.

  println(mailServer.url)
  println(mailServer.username)
  println(mailServer.password)

}
