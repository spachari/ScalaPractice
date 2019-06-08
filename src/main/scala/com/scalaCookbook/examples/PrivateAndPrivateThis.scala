package com.scalaCookbook.examples


//Private variables can be accessed by any of the objects. FOr example

//Class using private variable
class Stock {
  //a private field can be seen by any Stock Instance
  private var price : Double = _ //Creates default values

  def setPrice (s : Double) = { price = s }


  def isHigher(that : Stock) : Boolean = this.price > that.price
}

//Class using private[this]. Makes the variable object private. It means it can only be accessed from the object that contains it

class Stocks {

  private[this] var price : Double = _

  def setPrice (s : Double) = { price = s }

  //def isHigher(that : Stock) : Boolean = this.price > that.price //Compilation error symbol price is inaccessible from that place


}



object PrivateAndPrivateThis extends App {
  val p = new Stock
  p.setPrice(10.0)

  val q = new Stock
  q.setPrice(11.0)


  println(p.isHigher(q)) //p = 10 and q = 11 in this one p = this and q = that
  println(q.isHigher(p))

}
