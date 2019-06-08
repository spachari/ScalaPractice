package com.scalaCookbook.examples

//If you want to override Scala's getter and setter this is wrong
//class Animal (name : String) {
//  def name = name //setter
//  def name (name_ : String) : String = { name = name_ }
//}

//ForExample
/*
class Stock (var symbol: String)

This code compiles to

spachari@LONC02SR01DG8WN:~/scala-learning$ scalac StockClass.scala
spachari@LONC02SR01DG8WN:~/scala-learning$ javap Stock
Compiled from "StockClass.scala"
public class Stock {
  public java.lang.String symbol(); //THis is the getter
  public void symbol_$eq(java.lang.String); //This is the setter. Your variable symbol = "GBP" is syntactic sugar for symbol_$eq("GBP")
  public Stock(java.lang.String); //This is your constructor
}

//This code compiles to

class Stock (private var symbol: String) //No getter and setter created

spachari@LONC02SR01DG8WN:~/scala-learning$ javap StockClassPrivateVar
Error: class not found: StockClassPrivateVar
spachari@LONC02SR01DG8WN:~/scala-learning$ javap Stock
Compiled from "StockClassPrivateVar.scala"
public class Stock {
  public Stock(java.lang.String);
}

*/

//To override the getter and setter, we need to do this

class Animal (private var _name : String) { //private is very important
  def setName = _name //getter
  def getName = this._name
}




object GettersAndSetters {

}
