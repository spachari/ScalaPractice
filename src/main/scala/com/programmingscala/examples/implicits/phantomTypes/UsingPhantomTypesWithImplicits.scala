package com.programmingscala.examples.implicits.phantomTypes


object PipelineImplicits {
  implicit class toValue[V](value : V) {
    def |>[R](f : V => R) = f(value)
  }
}


object UsingPhantomTypesWithImplicits extends App {

  import PipelineImplicits._
  import PayRoll._

  val employee = Employee("Srinivas Pachari", 100000.00F, 0.5F, 200F, 0.10F, 0.5F)

  val pay = start(employee) |> minusInsurance |> minus401k |> minusTax |> minusFinalDeductions


  val twoWeeksGross = employee.annualSalary / 26.05F

  val twoWeekNet = pay.netPay

  val percent = (twoWeeksGross / twoWeekNet) * 100

  println(s"For ${employee.name} the gross vs net every two weeks is ")
  println(f" $$${twoWeekNet}%.2f vs $$${twoWeekNet}%.2f or ${percent}%.1f")

}
