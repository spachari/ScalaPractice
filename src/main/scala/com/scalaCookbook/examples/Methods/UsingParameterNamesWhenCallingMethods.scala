package com.scalaCookbook.examples.Methods

class Pizza {
  var crustType = "Thin"
  var crustSize = 8

  def update (crustType : String, crustSize : Int) = {
    this.crustSize = crustSize
    this.crustType = crustType
  }
  override def toString: String = s"The pizza'a crust type = ${crustType} and it's crust size is ${crustSize}"
}

object UsingParameterNamesWhenCallingMethods extends App {
  val p = new Pizza
  println(p.toString)
  println(p.crustSize)

  p.update(crustSize = 16, crustType = "Thick") //THe best way to call methods because it is very clear
  println(p.toString)

}
