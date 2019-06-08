package com.programmingscala.examples.functionalprogramming

object CurryingExample extends App {

  //Currying transforms a function that takes multiple arguments into a chain of functions, each taking a single argument.
  //Simple function
  def cat1(s1 : String)(s2 : String) = s1 + s2

  //This can also be written in a curried way
  //We can understand it as cat2 takes a string (s1 : String) and gives you a function that takes a
  //string (s2 : String) and gives a concatenation of strings s1 + s2
  def cat2(s1 : String) = (s2 : String) => s1 + s2

  val cat3 = cat1("Hello ") _

  println(cat3("World"))

  //While the first may be more readable, the second has the advantage that we do not need to add a _ when callign the function

  val cat4 = cat2("Hello ")

  println(cat4("World"))

  //Callign both the functions with two argument lists provides the same result

  println(cat1("Hello ")("World"))

  println(cat2("Hello ")("World"))

  //We can call a function with multiple arguments in a curried form
  def cat3(s1 : String, s2 : String) = s1 + s2


  /*
  scala> val cat3Curried = (cat3 _).curried
cat3Curried: String => (String => String) = scala.Function2$$Lambda$1754/545983259@9681871

scala> cat3Curried("hello")("world")
res70: String = helloworld

   */

  //Let's explore this further
  //cat3Curried: String => (String => String) = scala.Function2$$Lambda$1754/545983259@9681871

  //A function with two arguments
  val j = (i : Int, j : Int) => i * j

  //We cannot write it in a curried way like this
  //val j = (i : Int)(j : Int) => i * j

  //Instead we write like this
  val s = (i : Int) => (j : Int) => i * j * 10

  //(or)

  val s2 : Int => Int => Int = (i : Int) => (j : Int) => i * j * 10

  println(s(10)(10))


  val f1 : String => String => String = (s1 : String) => (s2 : String) => s1 + s2

  //is the same as

  val f2 : String => (String => String) = (s1 : String) => (s2 : String) => s1 + s2

  println(f1("Hello ")("World"))
  println(f2("Hello ")("World"))

  println(f1("Hello "))
  println(f2("Hello "))

  //We can uncurry a function like this
  val uncurriedf1 = Function.uncurried(f1)
  println(uncurriedf1("Hello ", "World"))


  //****Practical uses of currying****
  def multiplier(i : Int)(factor : Int) = i * factor

  val byFive = multiplier(5) _

  val byTen = multiplier(10) _

  println(byFive(8))

  println(byTen(8))


  //Using currying in a tuple

  def mult (d1 : Double, d2 : Double, d3 : Double) = d1 * d2 * d3
  //mult: (d1: Double, d2: Double, d3: Double)Double

  val doubles = (1.0678, 2.3456, 7.2344)

  println(mult(doubles._1, doubles._2, doubles._3))

  //This looks very ugly, but we can convert the def to val of type ((Double, Double, Double)) => Double

  val curryMult = Function.tupled(mult _)
  //((Double, Double, Double)) => Double = scala.Function$$$Lambda$1759/741255101@50c5f81

  println(curryMult(doubles))



}
