package com.scala.FPS

object PassingMultipleParameterGroups extends App {

  def sumWithMultipleParams(a : Int)(b : Int)(c : Int) = a + b + c

  println( "Sum is " + sumWithMultipleParams(1)(2)(3))


  def whilst(condition : => Boolean)(codeBlock : => Unit) : Unit = {
    while(condition == true) {
      codeBlock
    }
  }

  var i = 5
  whilst(i > 0){
    println(i)
    i = i - 1
  }

  def ifBothTrue(condition1 : => Boolean)(condition2 : => Boolean)(codeBlock : => Unit) : Unit = {
    if(condition1 && condition2){
      codeBlock
    }
  }

  val num = 50
  val name = "Srini"
  ifBothTrue(num > 20)(name == "Srini"){
    println("Both conditions are true")
  }

}
