package com.programmingscala.examples.functional.programming.alregraic.datatypes

sealed trait Direction
case object North extends Direction
case object South extends Direction
case object East extends Direction
case object West extends Direction

//Sum types are typically created by sealed traits typically created with a sealed trait as the base type,
// with instances created as case objects. You use a sealed trait because you don’t want them to be extended.

//The number of enumerated types you list are the only possible instances of the base type.
// In this example, Direction has four possible values: North, South, East, or West.

//We use the phrases “is a” and “or” when talking about Sum types. For example, North is a type of Direction,
// and Direction is a North or a South or an East or a West.


//Sealed trait
//A great feature of using sealed trait is that it lets the compiler perform “exhaustiveness checking.”
// What happens is that a sealed trait can only be extended in the file in which it was defined; because it can’t be extended
// anywhere else, the compiler knows all of the subtypes of the trait that can possibly exist. Because of this, the compiler
// can exhaustively check the possible cases in match expressions, and it will emit a warning if the match expression isn’t
// exhaustive. This makes your programming life easier, and your code safer.

//case objects
//The reason Sum types use the case object declaration is that they only require singleton instances, and the Scala object
// provides that functionality. For instance, with the Bool example it makes sense to have only one True instance in all of your
// code. There’s no need to create new True and False instances every time you work with boolean values. Scala’s object gives
// you this singleton functionality.

//As Scala/FP developers, we further use case object — as opposed to object — because it provides important additional functionality,
// with the most important feature being support for pattern matching; its automatically-generated unapply method lets case objects
// work easily in match expressions.


//We use the phrases “is a” and “or” when talking about Sum types. For example,
// North is a type of Direction, and Direction is a North or a South or an East or a West.

sealed trait Bool
case object True extends Bool
case object False extends Bool


object SumType extends App {

}
