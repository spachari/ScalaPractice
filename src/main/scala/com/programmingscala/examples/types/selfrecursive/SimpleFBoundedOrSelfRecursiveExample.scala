package com.programmingscala.examples.types.selfrecursive

trait Fruit {
  def compareTo(other : Fruit) : Boolean = true
}

class Apple extends Fruit
class Orange extends Fruit
//There is no differentiation between apple and orange

//FruitRefined[T <: FruitRefined[T]] means T has to be a subtype of FruitRefined[T]
//


trait FruitRefined[T <: FruitRefined[T]] {
  def compareTo(other : FruitRefined[T]) : Boolean = true
}

//Now apples and oranges are different
class AppleRef extends FruitRefined[AppleRef]
class OrangeRef extends FruitRefined[OrangeRef]

object SimpleTyeBoundedExample extends App {

  val apple = new Apple()
  val orange = new Orange()

  apple compareTo(orange)

  val appleRef1 = new AppleRef
  val appleRef2 = new AppleRef
  val orangeRef = new OrangeRef

  //will not compile
  //appleRef compateTo(orangeRef)

  appleRef1 compareTo(appleRef2)
}
