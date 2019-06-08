package com.programmingscala.examples.scalaObjectSystem

case class Address(street : String, state : String, zip : String)
case class Employee1(name : String, salary : Double, address : Address)

//Type Method Pattern means we just create an abstract class and implement the common mehtods
//For the changable methods we will create them in the sub classes thereby we will never have to
//use override keyword


//There are two exceptions to this rule.
//1. When we extend parent class useless methods like toString, hashCode and so on
//2. When we extend parent class methods and use logging calls. In that case, e can just use super. and call the parent class
//method. Try to avoid the use of overriding parent class implemented methods as much as possible

abstract class PayRoll {
  def netPay(employee : Employee1) : Double = {
    val fedTaxes = calcFedTaxes(employee.salary)
    val localTaxes = calcLocalTaxes(employee.salary, employee.address)
    val totalTax = employee.salary - (fedTaxes + localTaxes)
    totalTax
  }

  def calcFedTaxes (salary : Double) : Double
  def calcLocalTaxes (salary : Double, address : Address) : Double
}

object PayRoll2014 extends PayRoll {

  val stateRate = Map(
    "Surrey" -> 0.05,
    "Croydon" -> 0.02,
    "Detroit" -> 0.03
  )

  def calcFedTaxes(salary: Double): Double = salary * 0.25

  def calcLocalTaxes(salary: Double, address: Address): Double = {
    val localRate = stateRate.get(address.state)
    salary * localRate.get
  }
}

object PayRoll2015 extends PayRoll {

  val stateRate = Map(
    "Surrey" -> 0.04,
    "Croydon" -> 0.02,
    "Detroit" -> 0.01
  )

  def calcFedTaxes(salary: Double): Double = salary * 0.25

  def calcLocalTaxes(salary: Double, address: Address): Double = {
    val localRate = stateRate.get(address.state)
    salary * localRate.get
  }
}

object TypeMethodPatternExample extends App {

  val morden = Address("21, Buckfast Road", "Surrey", "SM45NA")
  val croydon = Address("86, Ridge Langley", "Croydon", "CR20AR")

  val srinivas = Employee1("Srinivas", 10000, croydon)

  val ricardo = Employee1("Ricardo", 4000, morden)

  println("Srinivas details for 2014 ... ")
  println(PayRoll2014.calcFedTaxes(srinivas.salary))
  println(PayRoll2014.calcLocalTaxes(srinivas.salary, srinivas.address))

  println("Srinivas details for 2015 ... ")
  println(PayRoll2015.calcFedTaxes(srinivas.salary))
  println(PayRoll2015.calcLocalTaxes(srinivas.salary, srinivas.address))

}
