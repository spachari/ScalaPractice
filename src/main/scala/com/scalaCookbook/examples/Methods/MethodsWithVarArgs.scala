package com.scalaCookbook.examples.Methods

class Fruits {
  def printFruits (fruits : String*) = { //The varargs field can be only one and it can be in the last parameter declaration
    fruits.foreach(println)
  }

  def getFruitMap(s : List[Tuple2[Int,String]]) = Map(s :_*)

  def getFruitMapFromTuples(s : (Int,String)*) = Map(s :_*)

  def getFruitList(s : String*) = List(s :_*)

}

object MethodsWithVarArgs extends App {
  val listOfFruits = List("apple", "banana", "Grapes")


  val f = new Fruits
  f.printFruits("apple", "banana", "Grapes")

  val s = List((1,"apple"),(2, "banana"), (3,"Grapes"))

  println(f.getFruitMap(s))

  println(f.getFruitList("apple", "banana", "Grapes"))

  val ys = ((1,"apple"),(2, "banana"), (3,"Grapes"))

  //Converting a list to varargs to pass into the method
  f.printFruits(listOfFruits : _*)

  //: - type ascription, a hint that helps compiler to understand, what type does that expression have
  //_* - placeholder accepting any value (_) + vararg operator

  //example
  val x : Seq[Seq[Int]] = Seq(Seq(1), Seq(2))

  def f(x : Seq[Any]*) = {
    x.length
  }

  println(f(x))

  println(f(x : _*))
  //It splats the contents of the list from Seq[Seq[Int]] to Seq[Int,Int]

  //Type ascriptions. Simple example for :

  val list = List(1,2,3,4)

  //val output = list.foldRight(Nil)((a,b) => a :: b)
  //The above will not work because Scala cannot infer that Nil is of type List[Int]
  //So this will work

  val output = list.foldRight(Nil : List[Int])((a,b) => a :: b)
  println(output)


}
