package com.scalaCookbook.examples

trait OptionPet {
  var name : String
  val greeting : Option[String]
  var age : Option[Int] = None

  override def toString: String =
    if (greeting.getOrElse("") == "")
      s"Hello, I am ${name}"
    else
      s"${greeting.get} I am ${name} and my age is ${age.get}"
}

class Dogs extends OptionPet {
  var name = "Fido"
  val greeting = Some("Woof!") //There was no variable (because we did not provide a value) created in the trait, so we have to use val
  age = Some(10) //There was a variable created, so in this case we can call directly and use it
}

object BasicTraitExampleUsingOption extends App {

  val d = new Dogs
  println(d)
}
