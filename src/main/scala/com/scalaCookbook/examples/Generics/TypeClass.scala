package com.scalaCookbook.examples.Generics

import com.scalaCookbook.examples.Generics.Humanish.HumanLike


trait Animals
final case class Dogs(name : String) extends Animals
final case class Cats(name : String) extends Animals



object TypeClass extends App {

  def add[A](x: A, y: A)(implicit numeric: Numeric[A]): A = numeric.plus(x, y)

  println(add(1,1))
  println(add(1.5,1.5))
  println(add(1, 1.5F))

  def makeHumanLikeThingSpeak[A](animal : A)(implicit humanlike : HumanLike[A]) = {
    humanlike.speak(animal)
  }

  //Because a speak method is defined in the DogIsHumanLike implicit object, which extends HumanLike[Dog],
  // a Dog can be passed into the makeHumanLikeThingSpeak method. But because a similar implicit object has not been
  // written for the Cat class, it can’t be used.

  makeHumanLikeThingSpeak(Dogs("Rover"))


}
