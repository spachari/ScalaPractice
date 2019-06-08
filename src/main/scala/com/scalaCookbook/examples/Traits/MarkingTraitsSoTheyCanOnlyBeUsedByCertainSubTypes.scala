package com.scalaCookbook.examples.Traits



class BaseType1

trait MyTrait {
  this: BaseType1 =>
}
//MyTrait can only be extended by any class or trait that extends BaseType1

//This approach is known as self type
//Scala definition
//A concrete class that mixes the interface must ensure that it's type will be of the same type as the trait's self type
class Test extends BaseType1 with MyTrait

//THis will not work
//class Test extends BaseType1


//Another Example
class StarShip
trait EjectorCore
trait HansSolo
trait MyShip extends StarShip

//If you are to use me (StarFleetWrapCore) you have to use StarShip
trait StarFleetWrapCores {
  this: StarShip  =>
  def printName = {println(this)}
}

class Enterprise extends StarShip with StarFleetWrapCores  {
   override def printName = println(this)
}

//Making a few classes/traits mandatory to be used along with a trait
trait StarFleetWrapCoreMovie {
  this: StarShip with EjectorCore with HansSolo with MyShip =>
}

//It is mandatory we need to use StarShip, Movies, HansSolo, MyShip along with StarFleetWrapCoreMovie
class Galaxy extends StarShip with EjectorCore with HansSolo with MyShip with StarFleetWrapCoreMovie

object MarkingTraitsSoTheyCanOnlyBeUsedByCertainSubTypes extends App {
val e = new Enterprise
  e.printName
}
