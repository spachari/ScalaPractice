package com.scalaCookbook.examples.Idioms

import scala.io.Source

case class Address (city : String, state : String, zip : String)

//There are three palces where we can use Option instead of nulls
//When a var field in a class or method doesn’t have an initial default value, initialize it with Option instead of null.

//class with nulls
class UserWithNulls (email: String, password: String)
{
  var firstName : String = _
  var lastName : String = _
  var address : Address = _
}

//class without nulls
class UserWithOptionValues (email : String, password: String)
{
  var firstName : Option[String] = None
  var lastName : Option[String] = None
  var address : Option[Address] = None
}

//class with optional values in constructors
case class Stock (stockID : Long,
                  var symbol : String,
                  var company : Option[String])


object OptionSomeNone extends App {

  //Creating a new user
  val srini = new UserWithOptionValues("srinivaspach@gmail.com", "Srinivas")

  //Assigning values to options
  srini.firstName = Some("Srinivas")
  srini.lastName = Some("Pachari")
  srini.address = Some(Address("Morden", "London","SM4 5NA"))

  //Getting the values from Options
  println(srini.firstName.getOrElse("Null"))

  //We can use foreach on a single object too
  srini.address.foreach{ address =>
    println(address.city);
    println(address.state);
    println(address.zip);
  }

  //Option can be thought of a collection of zero elements or One elements. So if you have a new variable that has 0 elements,
  //the for loop will do nothing
  val shankar = new UserWithOptionValues("shankar@gmail.com", "Shankar")

  //Nothing will happen. We will not get Null pointer exception at all
  shankar.address.foreach{ address =>
    println(address.city);
    println(address.state);
    println(address.zip);
  }

  println(srini.address.get)

  println(shankar.address.getOrElse(new Address("Default","default", "SM4 5NA")))

  //We still need to provide None when we create a constructor even if we have it as Option[String]
  val ibm = new Stock(12345678L, "IBM", None)

  //2. When a method does not produce an intended result, we can return an option instead of null
  def checkAddress(address : Option[Address]) : Option[String] = {

    println(address.get.city + address.get.state + address.get.zip)
    println(srini.address.get.city + srini.address.get.state + srini.address.get.zip)
    println(srini.address.get)

    if (address.get.city == srini.address.get.city ||
      address.get.zip == srini.address.get.zip ||
      address.get.state == srini.address.get.state
    )
      {
        val result = s"This ${address.get.city}, ${address.get.state} and ${address.get.state} is Srinivas's address"
           Some(result)
      }
    else
      {
        None
      }
  }


  println(checkAddress(srini.address))

  //Example 2 of returning an Option instead of Null
  def readTextFile (fileName : String) : Option[List[String]] = {
    try {
      val lines = Some(Source.fromFile(fileName).getLines().toList)
      lines
    }
    catch {
      case e : Exception => None
    }
  }

  println(readTextFile("dummy_file_name"))

}
