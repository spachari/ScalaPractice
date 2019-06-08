package com.programmingscala.examples.types.path.dependent.types.neophytes.guide.toscala


object Franchise {
  case class Character (name : String)
}

class Franchise (name : String) {
  import Franchise.Character
  def createFanFiction (loveStruck: Character, objectOfDesire: Character) : (Character, Character) = {
    (loveStruck, objectOfDesire)
  }
}



object PoorExample {
  //With this example anyone from a franchise can be with anyone
  val batmanSeries = new Franchise("Batman Series")
  val wonderWomanSeries = new Franchise("WonderWoman Series")

  val batmanHero = Franchise.Character("Batman")
  val batmanHeroine = Franchise.Character("Bat Girl")
  val wonderWomanHero = Franchise.Character("Wonder Woman")
  val wonderWomanHeroine = Franchise.Character("Wonder Woman Boy Friend")

  batmanSeries.createFanFiction(batmanHero, wonderWomanHero)
  //This should not be allowed

  val starTrek = new Franchise("Star Trek")
  val starWars = new Franchise("Star Wars")

  val quark = Franchise.Character("Quark")
  val jadzia = Franchise.Character("Jadzia Dax")

  val luke = Franchise.Character("Luke Skywalker")
  val yoda = Franchise.Character("Yoda")

  starTrek.createFanFiction(jadzia, luke)
  //This again should not be allowed



}
