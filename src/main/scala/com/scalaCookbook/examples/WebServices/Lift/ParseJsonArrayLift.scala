package com.scalaCookbook.examples.WebServices.Lift

import net.liftweb.json.{DefaultFormats, _}

case class EmailAccount(
                         accountName: String,
                         url: String,
                         username: String,
                         password: String,
                         minutesBetweenChecks: Int,
                         usersOfInterest: List[String]
                       )


object ParseJsonArrayLift extends App  {

  implicit val formats = DefaultFormats

  // a JSON string that represents a list of EmailAccount instances
  val jsonString ="""
{
  "accounts": [
  { "emailAccount": {
    "accountName": "YMail",
    "username": "USERNAME",
    "password": "PASSWORD",
    "url": "imap.yahoo.com",
    "minutesBetweenChecks": 1,
    "usersOfInterest": ["barney", "betty", "wilma"]
  }},
  { "emailAccount": {
    "accountName": "Gmail",
    "username": "USER",
    "password": "PASS",
    "url": "imap.gmail.com",
    "minutesBetweenChecks": 1,
    "usersOfInterest": ["pebbles", "bam-bam"]
  }}
  ]
}
"""


  val json = parse(jsonString)

  val elements = (json \\ "emailAccount").children

  for (acct <- elements)
    {
      val m = acct.extract[EmailAccount]

      println(s"Account ${m.accountName} " +
        s"Username ${m.username}" +
      s"Password ${m.password}")
      println(s"${m.usersOfInterest.foreach(println)}")
    }

}
