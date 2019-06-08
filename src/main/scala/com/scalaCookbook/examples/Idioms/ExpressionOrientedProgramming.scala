package com.scalaCookbook.examples.Idioms

object ExpressionOrientedProgramming extends App {

  //Statements do not return results and are executed solely for their side effects.
  //Expressions always return a result and often do not ahve side effects at all.

  //Statements are like this
  //order.calculateTaxes()
  //order.updatePrices()

  //Expressions are like this
  //val tax = calculateTax(order)
  //val price = calculatePrice(order)

  //An expression-oriented programming language is a programming language where every (nearly) every construction is an expression and
  //it yields a value



  //Poor design
  class Stock (var symbol: String,
               var company: String,
               var price: String,
               var volume: String,
               var high: String,
               var low: String)
  {
    var html: String = _
    //def buildUrl(stockSymbol: String): String = { println() }
    //def getUrlContent(url: String):String = { ... }
    //def setPriceUsingHtml() { this.price = ... }
    //def setVolumeUsingHtml() { this.volume = ... }
    //def setHighUsingHtml() { this.high = ... }
    //def setLowUsingHtml() { this.low = ... }
  }

  // The way of writing in Expression-oriented programming
  //val url = StockUtils.buildUrl(symbol)
  //val html = NetUtils.getUrlContent(url)
  //val price = StockUtils.getPrice(html)
  //val volume = StockUtils.getVolume(html)
  //val high = StockUtils.getHigh(html)
  //val low = StockUtils.getLow(html)
  //val date = DateUtils.getDate
  //val stockInstance = StockInstance(symbol, date, price, volume, high, low)

  //In scala everything is expression oriented programming or we can write everything as expressions

  val a = 2 + 2

  val b = List(1,2,3).map(x => x * 4)

  val greater = (a : Int, b : Int) => if (a > b) a else b

  val oddOrEven = (x : Int) => x match {
    case 1 | 3 | 5 | 7 | 9 => println("odd")
    case 2 | 4 | 6 | 8 | 10 => println("even")
    case _ => "Dont know man"
  }

  //Even try catch blocks can be written as expression oriented programming
  val output = try {
    "1".toInt
  } catch {
    case _ => 0
  }

  //Benefits
  //The code is easier to reason about. Inputs go in, a result is returned, and there are no side effects.

  //The code is easier to test.

  //Combined with Scala’s syntax, EOP also results in concise, expressive code.

  //Although it has only been hinted at in these examples, expressions can often be executed in any order. This subtle feature lets you
  // execute expressions in parallel, which can be a big help when you’re trying to take advantage of modern multicore CPUs.

}


