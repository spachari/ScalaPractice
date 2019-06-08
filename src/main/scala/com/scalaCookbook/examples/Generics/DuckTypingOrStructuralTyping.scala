package com.scalaCookbook.examples.Generics


class Dog { def speak() { println("woof") } }
class Klingon { def speak() { println("Qapla!") } }

object DuckTypingOrStructuralTyping extends App {

  def callSpeak[A <: { def speak(): Unit }] (elem : A) = {
    elem.speak()
  }

  val dog = new Dog
  val klingon = new Klingon

  callSpeak(dog)
  callSpeak(klingon)


}
