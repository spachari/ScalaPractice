package com.scalaCookbook.examples.Generics

import scala.collection.mutable.ArrayBuffer

trait CrewMember
class Officer extends CrewMember
class RedShirt extends CrewMember

trait Captain
trait FirstOfficer
trait ShipsDoctor
trait StarfleetTrained


object CollectionWhoseElementsAreOfSomeBaseType extends App {

  //Let's create a few instances
  val kirk = new Officer with Captain
  val spock = new Officer with FirstOfficer
  val bones = new Officer with ShipsDoctor


  //Given this setup, we can create a collection of officer (only) on a ship like this
  class Crew[A <: CrewMember] extends ArrayBuffer[A]

  val crewOfOfficers : Crew[Officer] = new Crew[Officer]()
  crewOfOfficers += kirk
  crewOfOfficers += spock
  crewOfOfficers += bones


  //We cannot create
  //val strings = new Crew[String]()

  //we get a runtime error
  //Error:(33, 7) type arguments [String] do not conform to class Crew's type parameter bounds
  // [A <: com.scalaCookbook.examples.Generics.CrewMember]
  //val strings = new Crew[String]()

  //We can also create one for Redshirts
  val crewOfRedShirts = new Crew[RedShirt]

  val red = new RedShirt with StarfleetTrained
  val stallone = new RedShirt with Captain
  val bing = new RedShirt with StarfleetTrained

  crewOfRedShirts += red
  crewOfRedShirts += stallone
  crewOfRedShirts += bing

  //Upperbound with multiple classes/traits

  class StarFleetTrainedCrew[ A <: CrewMember with StarfleetTrained] extends ArrayBuffer[A]
  val starfleetTrainedCrew = new StarFleetTrainedCrew[CrewMember with StarfleetTrained]

  //Create a few objects that are CrewMember with StarfleetTrained

  val srini = new Officer with CrewMember with StarfleetTrained
  val sadhana = new Officer with CrewMember with StarfleetTrained

  starfleetTrainedCrew += srini
  starfleetTrainedCrew += sadhana

}
