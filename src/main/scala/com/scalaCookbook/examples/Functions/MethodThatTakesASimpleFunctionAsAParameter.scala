package com.scalaCookbook.examples.Functions



object MethodThatTakesASimpleFunctionAsAParameter extends App {
  //Note: Only Function parameter
  //Note: Only the caller can pass the input parameter but not the intermediate functions, they only contribute to the computations

  val valHello : () => Unit = () => { println("Hello") }
  val valGoodNight : () => Unit = () => {println("Good night")}

  def defHello () = { println("Hello") }

  //Takes any function that has the type signature () => Unit
  def callAnyStrToUnitFunction(f: () => Unit) = f()

  callAnyStrToUnitFunction(valHello)

  callAnyStrToUnitFunction(valGoodNight)

  //Example 2 : Passing a function with Parameters
  val add : (Int, Int) => Int = (x,y) => x + y
  val sub : (Int, Int) => Int = (x,y) => x - y
  val mul : (Int, Int) => Int = (x,y) => x * y




  def calculator(f:(Int,Int) => Int, i : Int, j : Int) : Int = {
    val a = f(i,j)
    return a
  }

  val addition = calculator(add,1,2)
  val subtraction = calculator(sub,1,2)
  val multiply = calculator(mul,1,2)

  println(addition)
  println(subtraction)
  println(multiply)

  //Functional - curry way of calling the function
  def calculator1(f:(Int,Int) => Int)( i : Int, j : Int) : Int = {
    val a = f(i,j)
    return a
  }

  val faddition = calculator1(add)(1,2)
  val fsubtraction = calculator1(sub)(1,2)
  val fmultiply = calculator1(mul) _

  println(faddition)
  println(fsubtraction)
  println(fmultiply)




  //Functional - curry way of calling the function
  def greetName (f:(String) => String)(name:String) : String = {
    val a = f(name)
    a
  }

  //val mul : (Int, Int) => Int = (x,y) => x * y

  val sayHello :(String) => String = (name) => s"Hello $name"

  println(sayHello("Mark"))

  println(greetName(sayHello)("Mark"))

  //We can also use a function literal inside itself
  println(greetName(x => "Hello " + x)("Srinivas"))

  /*def greetFullName (f:(String)(String) => String)(firstName:String)(lastName : String) : String = {
    val a = f(firstName)(lastName)
    a
  }
  */


  //This function cane be called with any function literal that takes two string and passes a string
  def sayHelloFullName1 (f:(String, String) => String) (i : String , j : String) : String
  = {
    val x = f(i, j)
    x
  }


  val string = sayHelloFullName1((x,y) => "hello " + x + y)("Srinivas", "Pachari")

  println(string)


  //Mehtod taking one function that takes an input parameter and does nothing
  def methodInt (f : (Int) => Unit)(x : Int) = {
    f(x)
  }

//Funtions that takes an input parameter and does nothing
  val plusTne :  (Int) => Unit = x => println(x + 1)
  val multiply100 : (Int) => Unit = x => println(x * 100)

  //call it

  methodInt(plusTne)(10)
  methodInt(multiply100)(10)

  //Method that takes a function  that takes an input parameter and deos nothing
  def exec(f : (Int) => Unit) = {
    f(10)
  }

  val plusThree : (Int) => Unit = x => { println(x + 3) }

  val sayHello1 : (Int) => Unit = x => { println("Hello " + x) }

  exec(plusThree)
  exec(sayHello1)

  //Looping a function call the number of times a method is passed
  def execute(f: () => Unit)(noOfTimes : Int) = {
    for (x <- 1 to noOfTimes)
      {
        f()
      }
  }

  val sayHelloTo : () => Unit = () => { println("Hello  X") }
  sayHelloTo()

  execute(sayHelloTo)(3)

  val sayHelloToPerson : (String) => Unit = (s : String) => { println("Hello  " + s) }
  sayHelloToPerson("Srinivas")

  def executeAnyFunction (f: (String) => Unit)(x : String) = {
    f(x)
  }

  sayHelloToPerson("Srinivas")

  //Asked in stack overflow
  println("Executing any function ....")
  executeAnyFunction(sayHelloToPerson)("Srinivas")

  //You can pass anything that has a string
  val printUserNames : (Any, Any) => Unit = (fName : Any, lName : Any) => { println(fName); println(lName) }

  printUserNames("Srinivas", "Pachari")

  def printNames (f:(Any, Any) => Unit)(fName : Any, lName : Any) = {
    f(fName,lName)
  }

  printNames(printUserNames)("Srinivas", "Pachari")

  case class Person(lname : String)

  printNames(printUserNames)("Hello ", Person("Pachari"))

}
