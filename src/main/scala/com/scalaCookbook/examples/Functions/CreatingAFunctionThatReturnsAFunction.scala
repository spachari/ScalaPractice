package com.scalaCookbook.examples.Functions

object CreatingAFunctionThatReturnsAFunction extends App {

  //Assign a method to a function literal
  def saySomething(prefix : String) = (s : String) => { prefix + s }

  //call the method and assign it to a val, this will create a partially applied function with the prefix set to hello
  val sayHello = saySomething("Hello ")

  //call the anonymous function by passign it's value in this case s and complete the function
  println(sayHello("Srinivas"))
  println(sayHello("David"))

  //Try the above example with Vals
  //In the below line, you are effectivel assigning this function literal (s : String) => { prefix + s } to
  //val saySomethingVal = (prefix : String)
  //(prefix : String) is just the type declaration part of saySomethingVal
  val saySomethingVal = (prefix : String) => (s : String) => { prefix + s }

  val sayHelloVal = saySomethingVal("Hello ")

  println(sayHelloVal("Srinivas"))
  println(sayHelloVal("Sadhiv"))

  //Another example

  //This is cleaner example
  //In this example, a function is encapsulated inside a method.
  //because depending on the method value (english/spanish) a value will be selected

  def greeting (language : String) = (name : String) => {
    language match {
    case "english" => "Hello " + name
    case "spanish" => "Beunos " + name
    }
  }

  /*def greeting(language : String) = (name : String) => {
    val english = "Hello, " + name
    val spanish = "Buenos dias, " + name

    language match {
      case "english" => "Returning 'english' function "
      case "spanish" =>  "returning 'spanish' function"
      case _ => "Not a valid choice .. "
    }
  }
  */


  val english = greeting("english")
  val sayHello2 = english("Steve")
  println(sayHello2)

  val spanish = greeting("spanish")
  val sayBeunos = spanish("Stavros")

  println(sayBeunos)



}
