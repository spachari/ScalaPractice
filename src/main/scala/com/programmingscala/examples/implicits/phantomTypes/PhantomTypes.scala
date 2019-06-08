package com.programmingscala.examples.implicits.phantomTypes

sealed trait PreTaxDeductions
sealed trait PostTaxDeductions
sealed trait Final

case class Employee (name : String,
                     annualSalary : Float,
                     taxRate : Float,
                     insurancePremiuimsPerpayPeriod : Float,
                    _401DeductionRate : Float,
                     postTaxDeductions : Float)

//Pay can only be used with any of the sealed traits PreTaxDeductions, PostTaxDeductions, Final
//even though we never gave it any types

case class Pay[Step] (employee: Employee, netPay : Float)


object PayRoll {

  // Biweekly paychecks. Assume exactly 52 weeks/year for simplicity.

  def start (employee : Employee) : Pay[PreTaxDeductions] = {
    Pay[PreTaxDeductions](employee, employee.annualSalary / 26.05F)
  }

  def minusInsurance(pay : Pay[PreTaxDeductions]) : Pay[PreTaxDeductions] = {
    val newNet = pay.netPay - pay.employee.insurancePremiuimsPerpayPeriod
    pay copy (netPay = newNet)
  }

  def minus401k(pay : Pay[PreTaxDeductions]) : Pay[PreTaxDeductions] = {
    val newNet = pay.netPay - (pay.employee._401DeductionRate * pay.netPay)
    pay copy (netPay = newNet)
  }

  def minusTax(pay : Pay[PreTaxDeductions]) : Pay[PostTaxDeductions] = {
    val newNet = pay.netPay - (pay.employee.taxRate * pay.netPay)
    pay copy (netPay = newNet)
  }

  def minusFinalDeductions(pay : Pay[PostTaxDeductions]) : Pay[Final] = {
    val newNet = pay.netPay - pay.employee.postTaxDeductions
    pay copy (netPay = newNet)
  }

}

object PhantomTypes extends App {

  val employee = Employee("Srinivas Pachari", 100000.00F, 0.5F, 200F, 0.10F, 0.5F)

  val c1 = PayRoll start employee
  val c2 = PayRoll minusInsurance c1
  val c3 = PayRoll minus401k c2
  val c4 = PayRoll minusTax c3
  val pay = PayRoll minusFinalDeductions c4

  val twoWeeksGross = employee.annualSalary / 26.05F

  val twoWeekNet = pay.netPay

  val percent = (twoWeeksGross / twoWeekNet) * 100

  println(s"For ${employee.name} the gross vs net every two weeks is ")
  println(f" $$${twoWeekNet}%.2f vs $$${twoWeekNet}%.2f or ${percent}%.1f")

}
