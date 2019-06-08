package com.scalaCookbook.examples

class PandoraBox {
  case class Thing(name : String) // We created this as inner class because we do not want the user to access the class Thing

  var things = new scala.collection.mutable.ArrayBuffer[Thing]

  things += new Thing("Evil number 1")
  things += new Thing("Evil number 2")

  def addThing(thing : Thing) = { things += thing }
}


object PandoraBoxObject extends App {
  val p = new PandoraBox
  p.things.foreach(println)

}
