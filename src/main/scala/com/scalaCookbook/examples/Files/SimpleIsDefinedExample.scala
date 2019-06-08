package com.scalaCookbook.examples.Files

object SimpleIsDefinedExample extends App {

  var input : Option[Int] = None

  def checkInputIsDefined (i : Option[Int]) = {
    if (i.isDefined) {
      println("Input is defined")
    }
    else
    {
      println("Input is not defined")
    }
  }

  checkInputIsDefined(input)

  checkInputIsDefined(Some(20))


}
