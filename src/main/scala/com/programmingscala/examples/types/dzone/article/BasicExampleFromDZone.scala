package com.programmingscala.examples.types.dzone.article

import org.scalatest.{FlatSpec, Matchers}


//Terminology
//List[String] -------- Parameterized Type
//List  --------------- Type Constructor
//[String] ------------ Type

trait Thing
trait Vehicle extends Thing
class Car extends Vehicle
class Jeep extends Car
class Coupe extends Car
class MotorCycle extends Vehicle
class Bicycle extends Vehicle
class Tricycle extends Bicycle

class Vegetable extends Thing
class Tomato extends Vegetable


object BasicExampleFromDZone extends FlatSpec with Matchers with App
{

  class Parking[A](val place : A) //This just means that whatever we use for place should be of type A
  val motorcycle = new Parking[MotorCycle](new MotorCycle)
  //val car = new Parking[MotorCycle](new Car) //Wont compile because Car is not a motorcycle
  val jeep = new Parking[Car](new Jeep)

  class Parking2[A](val place1 : A, val place2 : A)
  //This one takes two of the same types, vehicle, car or motorcycle
  //ex
  val vehicles = new Parking2(new Jeep, new Coupe)
  //Scala infers them to two cars

  //Lower Bounds
  //Let's just keep Parking restricted to Vehicles
  class Parking3[A <: Vehicle] //This means anything less than or equal to Vehicle


  //So all these thigns will work
  val car = new Parking3[Vehicle]
  new Parking3[Vehicle] shouldBe a [Parking3[_]]
  // Wont compile
  // new Parking3[Vegetable] shouldBe a [Parking3[_]]

  //Upper Bounds
  class CarParking[A >: Jeep] //This means anything that is above Jeep
  val carParking = new CarParking[Vehicle]
  val thingParking = new CarParking[Thing] //sounds silly

  //Refned Upper bounds
  class CarParkingRefined[A >: Bicycle <: Vehicle](val place : A) //THis means anything between Bicycle and Vehicle
  //val carParkingRefined = new CarParkingRefined[Car](new Car)
  //Wont compile
  //val carParkingRefined1 = new CarParkingRefined[Thing]

  val carParkingRefined2 = new CarParkingRefined[Bicycle](new Bicycle)
  //This will work because if you can use A >: Bicycle <: Vehicle, since Bicycle is a subtype of Vehicle it will allow

  val carParkingRefined3 = new CarParkingRefined[Vehicle](new Car)
  val carParkingRefined4 = new CarParkingRefined[Vehicle](new Coupe)

  //val carParkingRefined5 = new CarParkingRefined[Car](new Car)
  //This means that only Bicycle and Vehicle are allowed as TYPE. Not Car type eventhough it is strictly Vehicle's children
  //Because vehicle is in the lower bound

  //On the other hand, this will work
  val carParkingRefined5 = new CarParkingRefined[Bicycle](new Tricycle)
  //It works because Tricycle is a Bicycle


  //Generics in class

  //1. class Parking[+A](val place : A) {
  //  def parkIt(element: A): Parking[A] = new Parking(element)
  //}

  class ParkingContra[-A] { def parkIt(element: A): ParkingContra[A] = new ParkingContra() }

  //error: covariant type A occurs in contravariant position in type A of value element

  //2. class ParkingTest[-A](val place : A) {
  //  def parkIt(element: A): ParkingTest[A] = new ParkingTest(element)
  //}

  //error: contravariant type A occurs in covariant position in type => A of value place


  //Both will not work purely because
  // 1. the method needs -A, i.e. a the method should accept super class objects so it cannot be +A
  // because if a method were expecting to use a variable  of type A
  // 2. the arguement in the constructor class ParkingTest[-A](val place : A) should be covariant. Because if there is a
  //

  //Let's first see what they should be

  class SimpleCovariantEx[+A](val a : A)

  class SimpleContravariantEx[-A] {
    def myPrint(a : A) = println(a)
  }

  //To overcome this we need to use
  //lower bounds
  class ParkingTest[+A](val place : A) {
    def parkIt[B >: A](element : B) : ParkingTest[B] = new ParkingTest[B](element)
  }
  //This means take a B upto or equal to A and we can use it

  //Usage 2: We can replicate Java's use-site variance
  //Variance that is created during the time a method is created

  class ParkingVehicles[A](val place : A) {
    def doSomething(A : ParkingVehicles[_ >: Vehicle]) = {}
  }

  //eventhough ParkingVehicles can take anything
  val testParkingVehicles = new ParkingVehicles[Thing](new Vegetable() )

  //testParkingVehicles.doSomething(new Vegetable()) //this will not work because doSomething is restricted to take only
  //anything whose upper bound is Vehicle

  testParkingVehicles.doSomething(new ParkingVehicles[Vehicle](new Car))

}
