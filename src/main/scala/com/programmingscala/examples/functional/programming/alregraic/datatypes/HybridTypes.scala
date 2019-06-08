package com.programmingscala.examples.functional.programming.alregraic.datatypes

//The Sum and Product types are the two base ADTs; all other ADTs are hybrids created from those base types.
// As the book Essential Scala states, “An algebraic data type is any data that uses the above two patterns” (Sum and Product).

//example

sealed trait Shape
final case class Circle(point : Double) extends Shape
final case class Rectangle(lenght : Double, breadth : Double) extends Shape

//Circle and Rectange are sum types because Rectangle "is a" Shape
//Circle and Rectangle are product types because Rectangle "has a" length and breadth

//Another simple example of Hybrid types

sealed trait CrustType
case object Thin extends CrustType
case object Thick extends CrustType
case object Cheese1 extends CrustType

sealed trait CrustSize
case object Small extends CrustSize
case object Medium extends CrustSize
case object Large extends CrustSize

sealed trait Topping
case object PineApple extends Topping
case object Chicken extends Topping
case object Cheese extends Topping
case object Mozerella extends Topping
case object Mushroon extends Topping
case object Tomato extends Topping

case class Pizza
(
    crustSize: CrustSize,
    crustType: CrustType,
    toppings : Seq[Topping]
)

//Pizza is a good example of ADT because it "is" something with a CrustSize and "has a" CrustSize




object HybridTypes {


}
