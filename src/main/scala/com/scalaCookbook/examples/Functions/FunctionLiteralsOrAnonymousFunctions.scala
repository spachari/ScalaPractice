package com.scalaCookbook.examples.Functions



object FunctionLiteralsOrAnonymousFunctions extends App {

  val list = List.range(1,10)

  //We can pass an anomyous function to list's filter method
  val output = list.filter((i: Int) => i % 2 == 0)

  //Here the contents inside the list is the anomyous function or Function Literal
  //(i: Int) => i % 2 == 0

  //The other way of writing is this with _s
  val output1 = list.filter (_ %2 ==0)
  output1.foreach(println)

  //Expression
  //(i : Int) => i % 2 == 0

  //Think of the => as a transformer where it transforms what is in the left (i : Int) to a new element using the algorithm

  //This (i : Int) => i % 2 == 0 can be written as i => i % 2 == 0, because scala can infer the Int

  //Further it can be written as _ % 2 == 0 when the variable i is used only once inside the function

  val output2 = list.map(i => if (i % 2 == 0) println("This is even number") else println("This is odd number"))

  //try underscoring this one
  //val output3 = list.map(if (_ % 2 == 0) println("This is even number") else println("This is odd number"))

  //Another example

  output.foreach(i => println(i))

  //can be written as
  output.foreach(println(_))
}
