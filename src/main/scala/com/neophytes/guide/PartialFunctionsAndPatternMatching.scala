package com.neophytes.guide

object PartialFunctionsAndPatternMatching extends App {


  //Pattern matching within anomyous functions
  val wordFrequencies = ("habitual", 6) :: ("and", 56) :: ("consuetudinary", 2) ::
    ("additionally", 27) :: ("homely", 5) :: ("society", 13) :: Nil

  //A pattern matching anonymous function is an anonymous function that is defined as a block consisting of a sequence of cases,
  // surrounded as usual by curly braces, but without a match keyword before the block.

  def wordsWithoutOutliers(seq : Seq[(String, Int)]) = {
    val result = seq.filter { case (word, frequency) => frequency > 3 && frequency < 25 }
      .map {case (word, freq) => word}
    result
  }

  val result6 = wordsWithoutOutliers(wordFrequencies)

  println(result6)


  //So what is a partial function? In short, it’s a unary function that is known to be defined only for certain input values
  // and that allows clients to check
  // whether it is defined for a specific input value.

  //To this end, the PartialFunction trait provides an isDefinedAt method. As a matter of fact, the PartialFunction[-A, +B]
  // type extends the type (A) => B (which can also be written as Function1[A, B]), and a pattern matching anonymous function
  // is always of type PartialFunction.

  val wordFrequenciesjumpled = ("habitual", 6) ::
                               ("and", 56) ::
                               ("consuetudinary", 2) ::
                               ("and", 56) ::
                               ("additionally", 27) ::
                               ("additionally","Srinivas", 27) ::
                               ("homely", 5) ::
                               ("society", 13) :: Nil

  val pf = new PartialFunction[(String,Int), String] {

    override def isDefinedAt(x: (String, Int)) = x match {
      case (word, freq) if freq > 3 && freq < 25 => true
      case _ => false
    }

    override def apply(v1: (String, Int)) = v1 match {
      case (word, freq) if freq > 3 && freq < 25 => word
    }
  }


  val result = wordFrequencies.collect(pf)

  //Another example of partialFunction

  val divideBy42 = new PartialFunction[Int,Int] {
    override def isDefinedAt(x: Int) : Boolean = x match {
      case x if x != 0 => true
      case _ => false
    }

    override def apply(v1: Int) = {
      42 / v1
    }
  }

  //Now let's sue them
  println(divideBy42.isDefinedAt(0))

  println(divideBy42.isDefinedAt(2))

  //Let's apply the function in a def
  def divideByzero(i : Int) = {
    if (divideBy42.isDefinedAt(i) == true)
      divideBy42.apply(i)
    else
    {
      println(s"42 cannot be divided by ${i}")
      0
    }
  }

  println(divideByzero(0))

  println(divideByzero(3))

  val list = 0 to 10

  val outputList = list.collect(divideBy42)

  outputList.foreach(println)

  //Another example
  val convertStringToInt1to5 = new PartialFunction[Int, String] {
    val nums = Array("one", "two", "three","four", "five")
    override def isDefinedAt(x: Int) = x match {
      case x if x >= 1 && x <= 5 => true
      case _ => false
    }

    override def apply(v1: Int) = {
      nums(v1 - 1)
    }
  }

  val outputList1 = list.collect(convertStringToInt1to5)
  outputList1.foreach(println)

  val convertStringToInt6to10 = new PartialFunction[Int, String] {
    val nums = Array("six", "seven", "eight","nine", "ten")

    override def isDefinedAt(x: Int) = x match {
      case x if x >= 6 && x <= 10 => true
      case _ => false
    }

    override def apply(v1: Int) = {
      println(nums(v1 - 6))
      nums(v1 - 6)
    }
  }


  println("Starting nums 6 to 10 ... ")
  val outputList2 = list.collect(convertStringToInt6to10)
  outputList2.foreach(println)

  val total10 = convertStringToInt1to5 orElse(convertStringToInt6to10)

  val outputList3 = list.collect(total10)
  outputList3.foreach(println)

}
