package com.programmingscala.examples.types.path.dependent.types.neophytes.guide.toscala

object FranchiseUpdated {
  case class Character(name : String, franchise : FranchiseUpdated)
}

class FranchiseUpdated(name : String) {

  import FranchiseUpdated.Character
  def createFanFiction(loveStruck : Character, objectOfDesire : Character) : (Character, Character) = {
    require(loveStruck.franchise == objectOfDesire.franchise)
    (loveStruck, objectOfDesire)
  }
}

object NeophytesGuideToScalaUpdated extends App {

  val batmanSeries = new FranchiseUpdated("Batman Series")
  val wonderWomanSeries = new FranchiseUpdated("WonderWoman Series")

  val batmanHero = FranchiseUpdated.Character("Batman", batmanSeries)
  val batmanHeroine = FranchiseUpdated.Character("Bat Girl", batmanSeries)
  val wonderWomanHero = FranchiseUpdated.Character("Wonder Woman", wonderWomanSeries)
  val wonderWomanHeroine = FranchiseUpdated.Character("Wonder Woman Boy Friend", wonderWomanSeries)

  batmanSeries.createFanFiction(batmanHero, wonderWomanHero)
  //this will fail, but at run time, not during compile time

}
