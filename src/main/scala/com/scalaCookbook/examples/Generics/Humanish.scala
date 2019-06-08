package com.scalaCookbook.examples.Generics

object Humanish {

  //The type class
  //defines the abstract method named 'speak'
  trait HumanLike[A] {
    def speak(speaker: A) : Unit
  }

  object HumanLike {

    //implement the behaviour for each desired type. In this case
    //only for a Dog
    implicit object DogIsHumanLike extends HumanLike[Dogs] {
      override def speak(dog: Dogs): Unit = println(s"I am a dog and my name is ${dog.name}")
    }

  }
}
