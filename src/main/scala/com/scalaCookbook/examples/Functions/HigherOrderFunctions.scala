package com.scalaCookbook.examples.Functions

object HigherOrderFunctions extends App {

  //A higher order function is nothing but a function that
  //1. Takes a function as a parameter
  //2. Return function as results


  println("Int Sum program ... ")
  def sumInts(a : Int, b : Int): Int = {
    if (a > b) 0 else
      {
        println(a + " " + b)
        a + sumInts(a + 1, b)
      }
  }

  println(sumInts(1, 10))

  println("Cube program ... ")
  def cube(x : Int): Int = x * x * x

  def sumCube(a : Int, b : Int) : Int = {
    if (a > b)
      0
    else
    {
      println(a + " --- "+ cube(a))
      cube(a) + sumCube(a + 1, b)
    }
  }

  sumCube(1, 5)

  println("Factorial program ... ")
  def factorial(i: Int) : Int = {
    if (i == 0) 0 else i + factorial(i - 1)
  }

  def sumFactorials(a : Int, b : Int) : Int = {
    if (a > b) 0
    else
    {
      println(a + " --- " + factorial(a))
      factorial(a) + sumFactorials(a + 1, b)
    }

  }

  println(sumFactorials(1,5))

  //Now comes the higher order functions
  def sum(f :Int => Int, a : Int, b : Int) : Int = {
    if (a > b) 0
    else
      f(a) + sum(f, (a + 1), b)
  }

  def id(x : Int) = x
  def sumInts1(a : Int, b : Int) = sum(id, a , b)

  def sumCubes1 (a : Int, b : Int) = sum(cube, a , b)

  def sumFactorials1 (a : Int, b : Int) = sum(factorial, a , b)

  //Comparing both functions
  println(sumFactorials(1, 5))
  println(sumFactorials1(1, 5))

}
