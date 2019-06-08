package com.scalaCookbook.examples.Traits


class Application {
  override def toString: String = s"The object is created"
}

trait Logger {
  def log = println("Log created")

  def printThis = println(this)

  printThis
}



object AddingATraitToAnObjectInstance extends App {
  val a = new Application with Logger
  //a.log

}
