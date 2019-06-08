package com.general.data.structures.and.algorithms.javatutorial.examples.scala


class CreditCard1(name : String, bank :  String, account : String, limit : Double, balance : Double) {

   val ccName = this.name
   val ccBank = this.bank
   val ccAccount = this.account
   val ccLimit = this.limit
   var ccBalance = this.balance

   //You need this for creating a secondary constructor
   def this(name : String, bank :  String, account : String, limit : Double) {
     this(name, bank, account, limit, 0.0)
   }

  def makePayment(amount : Double) = {
    this.ccBalance = ccBalance - amount
  }

  def charge(price : Double) = {
    if ((this.ccBalance - price) >= 0) {
      this.ccBalance = this.ccBalance - price
      true
    } else {
      false
    }
  }

   def printSummary(creditCard1: CreditCard1): Unit = {
     println("Name " + this.name)
     println("Bank " + this.bank)
     println("Account " + this.account)
     println("Limit " + this.limit)
     println("Balance " + this.balance)
   }

}

object CreditCard1 {

  def apply(name : String, bank :  String, account : String, limit : Double) =
    new CreditCard1(name, bank, account, limit, 0.0)

  def apply(name : String, bank :  String, account : String, limit : Double, balance : Double) =
    new CreditCard1(name, bank, account, limit, balance)

  def printCreditCardDetails(creditCard1: CreditCard1): Unit = {
    println("Name " + creditCard1.ccName)
    println("Bank " + creditCard1.ccBank)
    println("Account " + creditCard1.ccAccount)
    println("Limit " + creditCard1.ccLimit)
    println("Balance " + creditCard1.ccBalance)
  }
}

object CreditCardTest extends App {


  val wallet = List(
    new CreditCard1("Srinivas Pachari", "HSBC Premier", "1234567890", 10000, 1000),
    new CreditCard1("Srinivas Pachari", "HSBC Premier", "2345678901", 1000, 200),
    new CreditCard1("Srinivas Pachari", "HSBC Premier", "4567890123", 10000)
  )

  //Use the charge method
  for (i <- wallet) {
    println(s"Initial balance for ${i.ccAccount} -----------")
    CreditCard1.printCreditCardDetails(i)
  }

  val test = new CreditCard1("Srinivas Pachari", "HSBC Premier", "1234567890", 10000, 1000)
  val output = test.charge(100)

  CreditCard1.printCreditCardDetails(test)

  for (i <- 1 to 16) { //traditional for loop in scala
    wallet(0).charge(i * 3)
    wallet(1).charge(i * 2)
    wallet(2).charge(i * 3)
  }

  for (i <- wallet) { //enhanced for loop in scala
    println(s"Final balance for ${i.ccAccount} --------------")
    CreditCard1.printCreditCardDetails(i)
  }

}
