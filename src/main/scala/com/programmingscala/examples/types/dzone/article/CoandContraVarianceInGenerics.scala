package com.programmingscala.examples.types.dzone.article



object CoandContraVarianceInGenerics extends App {

  sealed abstract class Vehicle
  case class Car() extends Vehicle
  case class Motorcycle() extends Vehicle

  val k : (Vehicle => Vehicle) = l => new Vehicle {}
  val vehicleIdentity = (k : Vehicle => Vehicle)

  val i : (Int => Int) = i => i * 2

  val j = (i : Int => Int)


  //Let's use vehicleIdentity
  val output = vehicleIdentity(new Car())

  //Good

  //In generic types, the variance is the correlation between the inheritance relationship of the abstract types and how it is
  // “transmitted” to the inheritance in the generic classes.

  //In other words, given a class Thing [A], if A inherits from B (A <: B), then is Thing [A] <: Thing [B]?

  //Invariance
  case class Parking[A](value: A)

  //But we cannot do
  //val parking : Parking[Vehicle] = Parking[Car1](new Car1)

  //Covariance
  case class ParkingCo[+A](value : A)

  val parkingCo : ParkingCo[Vehicle] = ParkingCo[Car](new Car)

  //Notes:
  //Covariance allows you to type p1 as Parking[Vehicle] and assign it a Parking[Car].
  //But do not forget that, although p1 is typed as Parking[Vehicle], it is actually a Parking[Car].

  //For Parking[+A]
  //If Car <: Vehicle
  //Then Parking[Car] <: Parking[Vehicle]

  //Contravariance
   class ParkingContra[-A]

  val parkingContra : ParkingContra[Car] = new ParkingContra[Vehicle]

  //For Parking[-A]
  //if Car >: Vehicle
  //Then Parking[Vehicle] <: Parking[Car]


  sealed abstract class Animal
  class Cat extends Animal
  //Co-variant and contra variant positions
  //class Pets[+A](val pet : A) {
  //  def addIt(pet : A) = "Done"
  //}

  //We get this error
  //<console>:12: error: covariant type A occurs in contravariant position in type A of value pet
  //  def addIt(a : A) = "Done"
  //            ^

  //Error is in addIt when we try to use pet (A) which is covariant

  //But why
  //Look at the following example
  class Pets[+A](a : A)
  val pets: Pets[Animal] = new Pets[Cat](new Cat)

  //Although pets are typed as Pets[Animal], it is actually a Pets[Cat]. Therefore, because pets are typed as
  // Pets [Animal], pets.add() will accept Animal or any subtype of Animal. But this does not make sense, since,
  // in fact, pets is a Pets [Cat] and add() can only accept Cats or a Cat subtype.
  // The compiler prevents us from falling into the absurdity of calling pets.add(Dog ()), since it is a set of Cat.
  //A cat can have a drink milk method, where as a tiger which can also be subtyped from an Animal
  // will not have it. SO a method's postition is contra variant

  //Also we cannot do thsi as well
  //class PetsCo[-A](val pet:A)

  //We will get this error
  //contravariant type A occurs in covariant position in type => A of value pet
  //class PetsCo[-A](val pet:A)

  //If that was allowed
  //we can do this
  //val pets: Pets[Cat] = Pets[Animal](new Animal)

  //Even though pets is an Animal, it is infact a cat an obnject able to do pets.meow(). but pets is a cat not an animal

  //And although Pets[-A] is contravariant over A, the value pet: A is not. Once its type is defined (pets val: Pets [Cat]
  // implies that pets.pet will be Cat), this type is definitive.


  //For this same reason, this will not work
  //abstract class Pets2[-A]{
  //  def show(): A
  //}

  //The return type of methods will also have to be covariant, because if the
  // we do
  // val pets : Pets[Cats] = Pets[Animal](new Animal)
  // caller is expecting a cat and will have a method called drinkMilk()
  // The caller will be surprised if there is no drinkMilk() for a cat object



}
