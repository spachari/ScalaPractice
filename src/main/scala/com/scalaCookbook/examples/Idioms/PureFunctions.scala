package com.scalaCookbook.examples.Idioms

object PureFunctions extends App {

  //Theory:
  //Referential Transparency: An expression is said to be referentially transparent if it can be replaced
  //by it's resulting value without changing the behaviour of the program

  //Example: x + y is an expression

  //val z = x + y is the actual expression. If x + y can be replaced by z throughout the scope of the program
  //without affecting the functionality

  val x = "Hello".length + "World".length
  println(x)

  //Pure Functions
  //1. A pure function has one or more input parameters.

  //2. It's result is based solely off of those parameters and its algorithm.
  // The algorithm will not be based on any hidden state in the class or object it’s contained in.

  //3. It won’t mutate the parameters it’s given.

  //4. It won’t mutate the state of its class or object.

  //5. It doesn’t perform any I/O operations, such as reading from disk, writing to disk, prompting for input, or reading input.

  //Examples of Pure Functions

  //1. Mathematical functions, such as addition, subtraction, multiplication.
  //2. Methods like split and length on the String class.
  //3. Methods on immutable collections like map, filter


  //Examples of non Pure functions

  //1. A getRandomNumber function.
  //2. A function that reads user input or prints output.
  //3. A function that writes to an external data store, or reads from a data store.



}
