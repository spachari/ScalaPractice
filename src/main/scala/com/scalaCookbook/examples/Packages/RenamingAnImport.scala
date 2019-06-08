package com.scalaCookbook.examples.Packages

import java.lang.System.out.{println => p}

import scala.collection.mutable.{ArrayBuffer => MutableArrayBuffer}

class Arrays {

  var b : MutableArrayBuffer[String] = MutableArrayBuffer[String]()


  def addItem (item : String) = {
    this.b += item
    //b.foreach(p)
  }

  def printItems = {
    p(b.getClass)
    b.foreach(p)
  }

}

object MainClass extends App {
  var a = new Arrays

  a.addItem("Srinivas")
  a.addItem("Kirthika")
  a.addItem("Sadhana")
  a.addItem("Sadhiv")

  //a.b.foreach(p)
  a.printItems


}