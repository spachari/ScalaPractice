package com.scalaCookbook.examples.Idioms

import scala.collection.mutable.ArrayBuffer

object Immutability extends App {

  //You want to reduce the use of mutable objects and data structures in your code.

  //Programming in scala says "Prefer vals, immutable objects, and methods without side effects. Reach for them first."

  //There are two aspects to "prefer immutability
  //1. Prefer immutable collections. For instance, use immutable sequences like List and Vector before reaching for the mutable ArrayBuffer.

  //2. Prefer vals over vars

  //1. We prefer immutable collections over mutable collections because of want of purity
  //This code will still erase the arrayBuffer
  def evilFunction(arr : ArrayBuffer[String]) = {
    arr.clear()
  }

  //THis will not even compile
  def goodFunction(arr : Vector[String]) = {
    //arr.clear() //this will not compile
  }

  //There are a few advantages fo using immutable objects
  //1. They are a form of defensive coding, keeping your data from being changed.
  //2. They are easier to reason about

  //The examples shown in the Solution demonstrate the first benefit:
  // if there’s no need for other code to mutate your reference or collection, don’t let them do it. Scala makes this easy.

  //The second benefit can be thought of in many ways, but I like to think about it when using actors and concurrency.
  // If I’m using immutable collections, I can pass them around freely. There’s no concern that another thread will modify the collection.



}


//A simple class and it's reasoning

class Topping
{
  val item : String = "size"
}

class Pizza {

  private val _toppings = new collection.mutable.ArrayBuffer[Topping]()

  def toppings = _toppings.toList
  def addTopping(t: Topping) { _toppings += t }
  def removeTopping(t: Topping) { _toppings -= t }

}

//Reasoning for using
// private val _toppings = new collection.mutable.ArrayBuffer[Topping]()

//This code defines _toppings as a mutable ArrayBuffer, but makes it a val that’s private to the Pizza class.
// Here’s my rationale for this approach:

//I made _toppings an ArrayBuffer because I knew that elements (toppings) would often be added and removed.

//I made _toppings a val because there was no need for it to ever be reassigned.

//I made it private so its accessor wouldn’t be visible outside of my class.

//I created the methods toppings, addTopping, and removeTopping to let other code manipulate the collection.

//When other code calls the toppings method, I can give them an immutable copy of the toppings.

//I intentionally didn’t use the “val + mutable collection” approach, which would have looked like this:

//val toppings = new collection.mutable.ArrayBuffer[Topping]()

//I didn’t use this approach because I didn’t want to expose toppings as an immutable collection outside of my Pizza class,
// which would have happened here, because the val would have generated an accessor method. In using an OOP design, you think,
// “Who should be responsible for managing the toppings on the pizza?” and Pizza clearly has the responsibility of maintaining its toppings.

//I also didn’t choose this “var + immutable collection” design:

//var toppings = Vector[Topping]()
//The benefits of this approach are (a) it automatically shares toppings as an immutable collection, and (b) it lets me add toppings like this:

//def addTopping(t: Topping) = toppings :+ t

