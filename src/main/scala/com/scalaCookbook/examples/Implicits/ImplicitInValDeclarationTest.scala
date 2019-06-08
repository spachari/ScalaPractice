package com.scalaCookbook.examples.Implicits

case class MyPreferredDrink(name : String)
case class MyPreferredLanguage(name : String)

object SrinivasPreference {
  implicit val drink = MyPreferredDrink("lassi")
  implicit val language = MyPreferredLanguage("Tamil")
}

object BlakePreference {
  implicit val drink = MyPreferredDrink("Beer")
  implicit val language = MyPreferredLanguage("English")
}

object Greeting {
  def greet(name : String)(implicit drink :  MyPreferredDrink, language : MyPreferredLanguage) = {
    println("Welcome " + name + "Your preferred drink is " + drink.name + " your language is " + language.name)
  }
}

object ImplicitInValDeclarationTest extends App {

  import SrinivasPreference._

  val greet = Greeting.greet("Srinivas")


}

object Test2 extends App {
  import BlakePreference._

  val greet1 = Greeting.greet("Blake")
}