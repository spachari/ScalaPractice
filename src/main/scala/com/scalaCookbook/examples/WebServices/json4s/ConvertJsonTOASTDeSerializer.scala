package com.scalaCookbook.examples.WebServices.json4s

import org.json4s._

 class Person(
                   val user: String
                 )

object PersonSerializer extends CustomSerializer[Person](formats => ( {
  case JObject(JField("user", JString(user)) :: Nil) => new Person(user)
},
  {
    case x : Person => JObject(JField("user", JString(x.user)) :: Nil)
}))


object ConvertJsonTOASTDeSerializer extends App
{

  case class Address(street : String, city : String)
  case class PersonAddress(name : String, address : Address)

  val testJson1 =
    """
{ "user": "Srinivas,
  "address": {
    "street": "Bulevard",
    "city": "Helsinki",
    "country": {
    "code": "CD" }
  },
  "children": [
    {
      "name": "Mary",
      "age": 5,
      "birthdate": "2004-09-04T18:06:22Z"
    },
    {
      "name": "Mazy",
      "age": 3
    }
  ]
}
"""


  //implicit val formats = Serialization.formats(ShortTypeHints(List(classOf[Person])))


  //val output = parse(testJson1).as[Person]

  //println(output.user)

}
