package com.programmingscala.examples.functionalprogramming

case class Employee (
  name: String,
  title: String,
  annualSalary: Double,
  taxRate: Double,
  insurancePremiumsPerWeek: Double)

object AdvancedFoldExample extends App {

  val employees = List(
    Employee("Buck Trends", "CEO", 200000, 0.25, 100.0),
    Employee("Cindy Banks", "CFO", 170000, 0.22, 120.0),
    Employee("Joe Coder", "Developer", 130000, 0.20, 120.0))

  //Advanced way of using map to create new variables from existing case class
  val netPayPerEmployee = employees.map{
    e =>
      val net = (1.0 - e.taxRate) * (e.annualSalary / 0.52) - e.insurancePremiumsPerWeek
      (e, net)
  }

  println("PayChecks ... ")

  //Note in f"", we can mention spaces %-16s and decimal points %10.2f

  netPayPerEmployee.foreach{ e => println(f"Employee ${e._1.name}%-16s earns ${e._2}%10.2f") }


  //Just an example of fold
  println("Simple example of fold ... ")
  println(List(1,2,3,4).fold(0)((xs,a) => xs + a ))

  //The normal way of doing this is take the value from the list and do a calculation
  netPayPerEmployee.map(x => x._1.annualSalary).fold(0.0) {(xs,as) => xs + as}

  //The better way of doing this is
  //Remember we cannot use fold for this because for fold the input type and output type should be the same
  val totals = netPayPerEmployee.foldLeft(0.0,0.0,0.0) {
    //THis is nothing but (accumulator,netPayPerEmployee)
    case((totalSalary, totalNet, totalInsurancePremiumsPerWeek),(employee, net)) => {
      (totalSalary + employee.annualSalary/52.0,
      totalNet + net,
      totalInsurancePremiumsPerWeek + employee.insurancePremiumsPerWeek
      )
    }
  }

  println(f"Total salary per week is ${totals._1}%10.2f")
  println(f"Total net is ${totals._2}%2.2f")
  println(f"Total insurance per week is ${totals._3}")


}
