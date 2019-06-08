package com.scalaCookbook.examples.PatternMatching


case class Person(firstName: String, lastName: String)

object Test2 extends App {

  def matchType(x: Any): String = x match {
    //case x: List(1, _*) => s"$x"          // doesn't compile
    case List(ps @ _*) if ps.last == "string" => s"This is a list containing ${ps}"
    case x @ List(1, _*) => s"$x"           // works; prints the list
    //case Some(_) => "got a Some"          // works, but can't access the Some
    //case Some(x) => s"$x"                 // works, returns "foo"
    case x @ Some(_) => s"$x"               // works, returns "Some(foo)"
    case p @ Person(first, "Doe") => s"$p"  // works, returns "Person(John,Doe)"
  }

  println(matchType(List(1,2,3)))             // prints "List(1, 2, 3)"
  println(matchType(Some("foo")))             // prints "Some(foo)"
  println(matchType(Person("John", "Doe")))   // prints "Person(John,Doe)"
  println(matchType(List("Srinivas","Pachari","string")))
}