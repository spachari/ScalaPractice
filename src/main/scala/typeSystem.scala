import java.util.Calendar

import org.joda.time.LocalDate

class Food {
  def thing = { println ("Anything")}
}

abstract class Animals {
  def eat (food : Food)
}

class Grass extends Food {
  override def thing: Unit = { println("Herbivores eat me")}
}

class Cow extends Animals {
  //override def eat (food : Grass)  = { println("Eating grass") } //will not work. You cannot use polymorphism in a signature. When you override, you have to use
  // the actual signature
  override def eat(food: Food): Unit = println("can be anything") //
}


//However if they allow this, we will get into problems like this
class Fish extends Food {
  override def thing : Unit = { println ("Carnivores eat me")}
}

//class CarnivoreCowSuchATHingDoesNotExist extends Animal {
//  override def eat(food : Fish) = { println ("Can eat Fish")}
//}

//=============================================================================================
//So when it comes to inheritance, the inheriting method signature, should be exactly the same


//So Animals eat food, but they only eat specific type of food. That is very important for modellling

//With the new class definition, an animal can only eat food that is suitable. Wht food an animal can eat cannot be determined at that level.
//That is why SuitableFood is abstract. It has an upper bound Food. It is mentoned by <:
//Any concrete instantiation of SuitableFood must be subclass of Food.
//


abstract class Animals1 {
  type SuitableFood <: Food
  def eat (food : SuitableFood)
}

class CorrectCow extends Animals1 {
  type SuitableFood = Grass
  def eat (food : SuitableFood) = println("Grass")
}

class Shark extends Animals1 {
  override type SuitableFood = Fish
  def eat (food : Fish) = println("fish")
}

object typeSystem {

}


//type can also be written to mention primitives like this
trait AnimalType {
  type T

  type FunctorType = (LocalDate, Calendar, Int, Boolean) => String

  type IntType = (Int) => Int

  def eat (t : T) = {println(s"I can eat ${t}")}
}

class FoodType(name : String)

class DogType extends AnimalType {
  type FoodType

def printDate (t : FunctorType) = { println(s"Functor Type is just a alias for (LocalDate, Calendar, Int, Boolean) => String")}

  def eats( t : FoodType) = {println(s"I can eat ${t}")}

  def printInt (i : IntType) = i.toString



  type person12 = (String)

  /*
  def returnPerson (name : String) : person12 {
      return (name)
  }
  */

}

object Mains1 extends App {

  val d = new DogType

  val incrementInt = (i : Int) => i + 10

  val a = incrementInt(10)

  //Let's look back at this later
  d.printInt(incrementInt)



}
