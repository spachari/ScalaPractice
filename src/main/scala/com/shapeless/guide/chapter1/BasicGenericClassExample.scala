package com.shapeless.guide.chapter1

import shapeless._

case class Employee(name: String, number: Int, manager: Boolean)

case class IceCream(name: String, numCherries: Int, inCone: Boolean)

object BasicGenericClassExample extends App {

  def employeeCSV(employee : Employee) : List[String]= {
    List(employee.name, employee.number.toString, employee.manager.toString)
  }

  def iceCreamCSV(iceCream: IceCream) : List[String] = {
    List(iceCream.name, iceCream.numCherries.toString, iceCream.inCone.toString)
  }

  //Same thing can be achieved in shapeless via this
  val genericEmployee = Generic[Employee].to(Employee("Dave", 123, false))
  println(genericEmployee)

  val genericStudent = Generic[IceCream].to(IceCream("Vanilla", 30, true))
  println(genericStudent)

  def genericCSV(string : String :: Int :: Boolean :: HNil) : List[String] = {
    List(string(0), string(1).toString, string(2).toString)
  }

  def genericCsv(gen: String :: Int :: Boolean :: HNil): List[String] =
    List(gen(0), gen(1).toString, gen(2).toString)

  println(genericCSV(genericStudent))
  println(genericCSV(genericEmployee))
}
