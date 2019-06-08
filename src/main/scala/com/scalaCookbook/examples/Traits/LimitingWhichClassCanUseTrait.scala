package com.scalaCookbook.examples.Traits


//Use the following syntax to declare a trait named TraitName, where TraitName can only be mixed into classes that
// extend a type named SuperThing, where SuperThing may be a trait, class, or abstract class:

//trait [traitName] extends [SuperThing]

//class StarFleetComponent
//trait StarFleetWrapCore extends StarFleetComponent
//class Starship extends StarFleetComponent with StarFleetWrapCore

class StarFleetComponent
trait StarFleetWrapCore extends StarFleetComponent
class RomanStuff extends StarFleetWrapCore

class Warbird extends RomanStuff with StarFleetWrapCore

//Just class RomanStuff will not work

//Error:(11, 39) illegal inheritance; superclass RomanStuff
//is not a subclass of the superclass StarFleetComponent
//of the mixin trait StarFleetWrapCore
//class Warbird extends RomanStuff with StarFleetWrapCore

//Another example
abstract class Employee
trait StoreEmployee extends Employee
trait CorporateEmployee extends Employee

trait DeliversFood extends StoreEmployee

class DeliveryPerson extends DeliversFood with StoreEmployee
//THis is ok because they both share the common superclass


class Receptionist extends CorporateEmployee with DeliversFood





object LimitingWhichClassCanUseTrait extends App{
  val v = new Warbird
  val r = new Receptionist
}
