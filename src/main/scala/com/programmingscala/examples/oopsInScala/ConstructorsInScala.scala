package com.programmingscala.examples.oopsInScala

//Style one 1. one with companion object apply
case class Person1(name : String, street : String, zip : String)

object Person1 {
  def apply(name : String) = new Person1(name, "default street", "default zip")

  def apply(name : String, street : String) = new Person1(name, street, "default zip")
}

//Style 2 : In case class with this in auxillary functions
case class Student(id : Int, name : String, std : String) {
  def this(name: String, std: String) = this(100, name, std)

  def this(std: String) = this(100, "default", std)
}

//Style 3 : getting values from the object as methods. It is like static values
//object Animal will be available when the first instance is created already.
case class Animal(name : String, animalType : String, typeOfFood : String)
{
  def this(name : String) = this(name, Animal.defaultAnimalType, Animal.defaultFood)

  def this(name : String, animalType: String) = this(name, animalType, Animal.defaultFood)
}

object Animal {
  def defaultAnimalType : String = "pet"
  def defaultFood : String = "vegetables"
}

//Style 4 : The Person1 constructor has a lot of boiler plate just to assign default values.
//Let's fix it in person 2

case class Person2(name : String, street : String = "default street", zip : String = "default zip")

object ConstructorsInScala extends App {

  val person1 = Person1("Srinivas")
  println(person1)

  val person2 = Person1("Srinivas", "86, Ridge Langley")
  println(person2)

  val person3 = Person1("Srinivas", "86, Ridge Langley", "CR20AR")
  println(person3)

  //Despite the fact that Student is a case class, we are having to use new for the calling the auxillary constructors
  val student1 = Student(1,"Srinivas", "5th std")
  println(student1)

  val student2 = new Student("Sadhana", "7th std")
  println(student2)

  val student3 = new Student("10th standard")
  println(student3)

  //Note that an auxiliary constructor is named this and it must call the primary constructor or another auxiliary
  // constructor as its first expression. The compiler also requires that the constructor called is one that appears earlier
  // in the source code. So, we must order secondary constructors carefully in our code.

  val animal1 = new Animal("dog", "pet", "biscuits")
  println(animal1)

  val animal2 = new Animal("cow")
  println(animal2)

  val person2_1 = Person2("Srinivas", "21, Buckfast Road", "morden")
  println(person2_1)

  val person2_2 = Person2("Sachin")
  println(person2_2)


}
