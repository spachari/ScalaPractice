package com.scalaCookbook.examples.Generics

object CreatingMethodThatTakesSimpleGenericTypes extends App {
  
  def getRandomItem(seq : Seq[String]) : String = {
    val randomNum = util.Random.nextInt(seq.length)
    seq(randomNum)
  }
  
  //Same function written generically
  def getRandomItemFromGeneric[A] (seq : Seq[A]) : A = {
    val randomNum = util.Random.nextInt(seq.length)
    seq(randomNum)
  }
  
  val numList = List(1,2,3,4,5)
  val stringList = List("apples", "grapes", "bananas")
  println(getRandomItemFromGeneric(numList))
  println(getRandomItemFromGeneric(stringList))


}
