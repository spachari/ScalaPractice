package com.scalaCookbook.examples.Generics

import scala.collection.mutable.ArrayBuffer

class Person {
  def speak = println("this is my life")
}

class CrewMember1 extends Person {
  def beamDown = println("beaming down")
}

class RedShirt1 extends CrewMember1 {
  def putOnRedShirt = println("putting on red shirt")
}


object UpperBoundsWhenMethodCalling extends App {

  class Crew1[A <: CrewMember1] extends ArrayBuffer[A]


  //This method can only take a Crew1 of less than or equal to CrewMember1
  def beamDown[A <: CrewMember1](crew : Crew1[A]) = {
    crew.foreach(_.beamDown)
  }

  val crew = new Crew1[CrewMember1]()
  val srini = new CrewMember1
  val sadhana = new CrewMember1
  val kirthika = new RedShirt1

  crew += srini
  crew += sadhana
  crew += kirthika //Red shirt is converted into a crewmember1

  //But we cannot add a person above he leve l of Crew Memner

  beamDown(crew)

  //When we try to add a person it will not work
  val p = new Person
  //crew += p


  def putRedShirtOn[A <: RedShirt1](crew : Crew1[A]) = {
    crew.foreach(_.putOnRedShirt)
  }

  //Create a class that can take only a few elements of type RedShirt
  class RedShirtCrew[A <: RedShirt1] extends ArrayBuffer[A]

  //Create an object
  val redShirtCrew = new Crew1[RedShirt1]()

  //Now load the array with redshirts and use the method
  val sadhiv = new RedShirt1

  redShirtCrew += sadhiv
  redShirtCrew += kirthika

  putRedShirtOn(redShirtCrew)


  //In both cases, you control which type can be passed into the method
  // using an appropriate upper bound definition on the method’s type parameter.
}
