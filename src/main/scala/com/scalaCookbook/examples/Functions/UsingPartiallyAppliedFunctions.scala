package com.scalaCookbook.examples.Functions


object UsingPartiallyAppliedFunctions extends App {

  //Note: When we create the partial function we shwuld not declare the variables again

  //difference between a function literal and method in scala
  //Function literal
  val sum = (x : Int, y : Int) => x + y

  //Method
  def sum(x : Int, y : Int) = x + y


  //Example 1
  //Create a function
  def sumThreeNumbers (x : Int, y: Int, z : Int) = x + y + z

  //create a partial function from the actual function
  val sumWith12 = sumThreeNumbers(10, _ : Int, 22)

  println(sumWith12(22))


  //Example 2
  //Another example with open brackets
  def sum3Numbers (x : Int) (y : Int) (z : Int) = x + y + z

  //create a partial function
  val myAddition = sum3Numbers(12) (_ : Int) (22)

  println(myAddition(22))


  //Example 3
  //A practical usage
  def wrap (head : String, body : String, tail : String) = {
    println(head + body + tail)
  }

  val wrapWithDev = wrap("<div>", _ : String, "<\\div>")

  wrapWithDev("Hello World")
  wrapWithDev("<img src=\"/images/foo.png\" />" )

}

