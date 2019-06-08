package com.scalaCookbook.examples.Traits

trait Tail {
  def wagTail = { println("wagging Tail")}
  def stopTail = { println("stop Tail")}
}

abstract class Pet1 (name : String) {
  def speak (name : String)
  def ownerIsHome = { println("I am happy") }
  def jumpForJoy = { println("jumping with joy") }
}

//In summary, the MyDog class can get the behaviour of both the Pet1 abstract class and Tail trait
class MyDog  (name : String) extends Pet1 (name) with Tail {
  override def speak(name: String): Unit = { println("woof!")}
  def whenIAmHome: Unit = {
    wagTail
    jumpForJoy
  }
}

object UsingTraitsAsMixins extends App {

  val z = new MyDog("Zeus")
  z.speak("Zeus")
  z.ownerIsHome
  z.whenIAmHome
}
