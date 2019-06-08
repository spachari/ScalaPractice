package com.scala.FPS



case class Name (firstName : String, mi : String, lastName : String)

case class CreditCard (name : Name,
                       number : String,
                       month : Int,
                       year : Int,
                       cvv : String)

case class BillingInfo (creditCards : Seq[CreditCard])

case class Address (houseNumber : Int,
                    streetName : String,
                    suburb : String,
                    postCode : String)
case class User (
                id : Int,
                name : Name,
                billingInfo : BillingInfo,
                phone : String,
                email : String,
                address : Address
                )

object CopyingObjects extends App {

  //Using copy in a simple copy class
  case class Persons(firstName : String, lastName : String, age : Int)

  val srini2017 = Persons("Srinivas","P",36)

  val srinivasPachari2018 = srini2017.copy(lastName = "Pachari")

  val sriniLatestDetails = srinivasPachari2018 match {case Persons(f,l,a) => println(s"${f} -- ${l} -- ${a}")}

  val hannahName = Name("Hannah", "s", "James")

  val hannahCreditCard = CreditCard(name = hannahName,
                                    number = "1234567890123456",
                                    month = 7,
                                    year = 2017,
                                    cvv = "456")

  val hahhahAddress = Address(21,"Buckfast Road", "Morden", "SM4 5NA")

  val hannahUser = User(id = 12345,
                        name = hannahName,
                        billingInfo = BillingInfo(Seq(CreditCard(name = hannahName,
                                                                 number = "1234567890123456",
                                                                 month = 7,
                                                                 year = 2017,
                                                                 cvv = "456"))),
                        phone = "07702108957",
                        email = "hannah@yahoo.com",
                        address = hahhahAddress
  )


  //Updating hannahPhoneNumber
  val hannahUser2 = hannahUser.copy(phone = "07702018999")

  //Hannah get's married
  //updating the lastName
  val hannahName2 = hannahName.copy(lastName = "Smith")

  val hannahUser3 = hannahUser2.copy(name = hannahName2)

  //Changing Hannah's name in credit card
  //Get the first credit card instance
  val oldCC = hannahUser3.billingInfo.creditCards(0)

  //Update the creditCard instance
  val newCC = oldCC.copy(name = hannahName2)

  //Create a new creditCard Sequence
  val newCCs = Seq(newCC)

  val hannahUser4 = hannahUser3.copy(billingInfo = BillingInfo(newCCs))

}
