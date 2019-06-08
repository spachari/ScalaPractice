package com.scalaCookbook.examples

object forexamples extends App {
  val a = Array ("apple","banana","grape","orange")

  //using for to print a collection. THis is equal to foreach
  for (e <- a) println(e)

  //for loop with multiple lines
  for (e <- a) {
    val s = e.capitalize
    println(s)
  }

  //returning the output of a for loop to a new collection
  val newArray = for (e <- a) yield e
  newArray.foreach(println)


  ////returning the output of a for loop to a new collection with multiple lines
  val myNewArray = for (e <- a) yield {
    val s = e.capitalize
    s
  }

  myNewArray.foreach(println)

  //counters in for loop
  for (i <- 0 until a.length) println(s"${i} is ${a(i)}")

  //using zip with index
  for ((count, e) <- a.zipWithIndex) {
    println(s"${e} is ${count}")
  }

  //using generators and guards
  for (i <- 1 to 10 if i < 4) println(i)
  //a guard is nothing but if statements in a for loop

  //looping over a map
  val family = Map("daddy" -> "Srinivas", "mummy" -> "Kirthika", "son" -> "Sadhiv","daughter" -> "Sadhana")

  for ((role, name) <- family) println(s"${role} is ${name}")

  //Internally a scala for loop is converted into foreach method,
  //for/yeild is converted into foreach and map method
  //a for/if (a for comprehension) with yield is converted into foreach.withfilter.map
  // The -Xprint:parse option shows a small amount of compiler output,
  // while the -Xprint:all option produces hundreds of lines of output for some of these examples,
  // showing all the steps in the compilation process.


  //Multiple for loops one by one (more simpler than imperative programming)
  for (i <- 1 to 3; j <- 1 to 3) println(s"${i} -- ${j}")

  //the { way, you do not need to use ;
  for {
    i <- 1 to 3
    j <- 1 to 3
    k <- 1 to 3
  } println(s"${i} -- ${j} -- ${k}")

  //Creating a two dimensional array
  val array = Array.ofDim[Int](2,2)
  array(0)(0) = 1
  array(0)(1) = 1
  array(1)(0) = 1
  array(1)(1) = 1

  for (i <- 0 to 1;
       j <- 0 to 1) println(s"array(${i},${j}) value is ${array(i)(j)}")
}
