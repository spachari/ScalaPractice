package com.programmingscala.examples.implicits

object SimpleStateSalesTax {
  implicit val rate : Float = 0.05F
}

case class ComplicatedStateSalesTax (
                                    baseRate : Float,
                                    isHolidayTax : Boolean,
                                    storeId : Int
                                    )

object ComplicatedStateSalesTax {
  //calculating rate for complicated sales tax
  private def extraTaxRateForStoreId (id : Int) : Float = {
    0.0F
  }

  implicit def rate(implicit cstd : ComplicatedStateSalesTax) = {
    if (cstd.isHolidayTax) 0.0F
    else cstd.baseRate + extraTaxRateForStoreId(cstd.storeId)
  }
}



object ImplicitsCanBecalledinValueAndDefExample1 extends App {

  def calcTax(amount : Float) (implicit rate : Float) : Float =
    {
      println(rate)
      amount * rate
    }


  //static blocks are executed first before anything
  //Calculating simple tax
  {
    import SimpleStateSalesTax._

    val amount = 100F
    println(s"Tax on amount ${amount} is ${calcTax(amount)}")
  }

  //Calculating complicated tax
  {
    import ComplicatedStateSalesTax._

    val amount = 100F
    //If your method takes an implicit value, you need to pass it an implicit val/var so that it can pick it
    //Normal value will not cut it

    implicit val complicatedStateSalesTax = ComplicatedStateSalesTax(0.06F, false, 100)

    println(s"Tax on amount ${amount} is ${calcTax(amount)}")

  }

}
