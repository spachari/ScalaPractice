package com.scalaCookbook.examples.Methods

class StockInfo {

  def getStockInfo(symbol : String, currentPrice : Double, bidPrice : Double) = Tuple3(symbol,currentPrice,bidPrice)
}

class Person {
  def age = 12 //This will force the caller to use only age and not age()
}

object DefiningMethodsReturningMultipleValues extends App {

  val s = new StockInfo
  val (symbol,currentPrice, bidPrice) = s.getStockInfo("BAML", 30.32, 33.52)
  println("The symbol is " + symbol)
  println("The current Price is " + currentPrice)
  println("The bid price is " + bidPrice)
  println((symbol,currentPrice, bidPrice))

  //Second way of doing is
  val output = s.getStockInfo("FB", 180.32, 183.52)
  println(output._1)
  println(output._2)
  println(output._3)

  val p = new Person
  p.age

}
