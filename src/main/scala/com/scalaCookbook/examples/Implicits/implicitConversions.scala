package com.scalaCookbook.examples.Implicits

//Example 1
//val button = new JButton
//button.addActionListener(
//  new ActionListener {
//      def actionPerformed(event: ActionEvent) = {
//          println("pressed!")
//        }
//    }
//)

//We can make this work in Scala:

//button.addActionListener( // Type mismatch!
//  (_: ActionEvent) => println("pressed!")
//)

//We just need to add an implicit

//Look closely, it is nothing but a function (def) that adds to some other functionality in our code

//implicit def function2ActionListener(f: ActionEvent => Unit) =
//  new ActionListener {
//      def actionPerformed(event: ActionEvent) = f(event)
//    }

//we can use this like this way
//button.addActionListener(
//  function2ActionListener(
//    (_: ActionEvent) => println("pressed!")
//  )
//)


// Now this works
//button.addActionListener(
//  (_: ActionEvent) => println("pressed!")
//)

import scala.language.implicitConversions

class Addition {
  implicit def stringToInt(s : String) = {
    println("Implementing implicit def")
    s.toInt
  }

  implicit def doubleToInt(i : Double) = {
    println("DOuble to Int")
    i.toInt
  }

  implicit def intToString(s : Int) = { println("Using implicit method")
    s.toString }

  def myAdd (s: String, d : Int) = stringToInt(s) + d

  def printInt (x : Int) = println(x)

  //val x : Int = 1.7

}

//Rule 1 : Only defs can be implicitly converted
//Rule 2 : An implicit definition must be in scope as a single identifier or be associated with the source or target definition.
//Either in the same class or in the companion object
//Rule 3: Only one import at a time The compiler will not do convert2(convert1(x)) + y
//Rule 4: When the code type checks, it does not consider implicits. So that means, we cannot pass a double to a method that takes Int or viceversa

//They are used in 3 different situations
// 1. Conversions to an expected type (Example: using implicit def to coonvert a double to Int)
// 2. Conversions of the receiver of the selection (Example: adding method to Rational to convert Rational to
// support non-fractional values
// as if it was Rational's method)
// 3. Implicit parameters

//scala>  class PreferredPrompt(val preference: String)
//defined class PreferredPrompt

//scala> object Greeter {
//  |   def greet(name : String)(implicit prompt : PreferredPrompt) = {
//    |     println("Welcome " + name + " . Your system is ready")
//    |     print(prompt.preference)
//    | }
//  | }
//defined object Greeter

//Running the output
//scala> Greeter.greet("Srinivas")(v)
//Welcome Srinivas . Your system is ready
//  relax >

//Or we can do it this way also
//scala> object JoesPrefs {
//|    implicit val prompt = new PreferredPrompt("Hello Master")
//| }
//defined object JoesPrefs

//scala> import JoesPrefs.prompt
//import JoesPrefs.prompt

//scala> Greeter.greet("Srinivas Pachari")
//Welcome Srinivas Pachari . Your system is ready
//  Hello Master
//In the above case, implicit will automatically pick up the prompt and add it to the greet method

class PreferredDrink(val preference: String)
class PreferredMessage(val preference: String)

object MyPreference {
  implicit val drink = new PreferredDrink("lassi")
  implicit val message = new PreferredMessage("Hello Master")
}

object Greeter {
  def greet(name : String)(implicit drink : PreferredDrink, message : PreferredMessage) = {
    println("Welcome " + name + " . Hoep you are alright. Have a " + drink.preference)
    println(message.preference)
  }
}

class Greatest {
  def getListMax[T] (list : List[T])(implicit ordering : Ordering[T]) : T = {
    list match {
      case List() => throw new IllegalArgumentException("empty List!")
      case List(x) => x
      case x :: rest =>
        val Maxrest = getListMax(rest)
        if (ordering.gt(x,Maxrest)) x
        else Maxrest
    }
  }
}

//Implicit classes. They are used to write rich wrapper class
//For an implicit class, the compiler generates an implicit conversion from the
// class's constructor parameter to the class itself.

//scala> case class Rectangle(width : Int, height : Int)
//defined class Rectangle

//scala> implicit class RectangleMaker(width : Int) {
//  | def x (height : Int) = new Rectangle(width, height)
//  | def plus (height : Int) = width + height }
//defined class RectangleMaker

//scala> val v = 3 x 4
//v: Rectangle = Rectangle(3,4)

//scala> val g = 6 plus 19
//g: Int = 25



object implicitConversions extends App {
  val a = new Addition
  println(a.myAdd("10", 20))
  val a1 = 10000
  println(a1 + " Hello")

  //println(a.x)


  implicit def doubleToInt (x : Double) = x.toInt

  val x : Int = 10.5
  println(x)



  implicit def intToRational(x: Int) = new Rational(x, 1)
  val two = intToRational(2)
  println(two)
  val twoThird = new Rational(2,3)
  //println(two + oneThird)
  val oneThird = new Rational(1,3)
  val output = twoThird + oneThird

  println(output)

}
