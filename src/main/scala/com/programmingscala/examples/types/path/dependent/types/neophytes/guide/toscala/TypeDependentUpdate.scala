package com.programmingscala.examples.types.path.dependent.types.neophytes.guide.toscala


case class FranchiseTypeDependent(name : String) {
   case class Character1(name : String)
    def createFanFiction(loveStruck : Character1, objectOfDesire : Character1)
    : (Character1, Character1) = {
      (loveStruck, objectOfDesire)
    }
}

class SetUpCharacters{
  def createFanFiction(f : FranchiseTypeDependent)
                      (loveStruck : f.Character1, objectOfDesire : f.Character1) = {
    (loveStruck, objectOfDesire)
  }

  def createCrossSeriesFanFiction(f : FranchiseTypeDependent)
                      (loveStruck : FranchiseTypeDependent#Character1, objectOfDesire : FranchiseTypeDependent#Character1) = {
    (loveStruck, objectOfDesire)
  }
}



object PathDependentWayUpdate extends App {

  val batmanSeries = FranchiseTypeDependent("Batman Series")
  val wonderWomanSeries = FranchiseTypeDependent("WonderWoman Series")

  val batmanHero = batmanSeries.Character1("Bat Man")
  val batmanHeroine = batmanSeries.Character1("Bat Woman")
  val wonderWomanHero = wonderWomanSeries.Character1("Wonder Woman")
  val wonderWomanHeroine = wonderWomanSeries.Character1("Wonder Woman Boy friend")

  batmanSeries.createFanFiction(batmanHero, batmanHeroine)
  //batmanSeries.createFanFiction(batmanHero, wonderWomanHeroine)
  //This will not work



  val s = new SetUpCharacters
  s.createFanFiction(batmanSeries)(loveStruck = batmanHero, objectOfDesire = batmanHeroine)
  s.createCrossSeriesFanFiction(batmanSeries)(loveStruck = batmanHero, objectOfDesire = wonderWomanHeroine)

  case class A (a : String) {
    case class B (a : String)
    def getB (a : String) = B
  }

  val a = A("Srini")
  val b = new a.B("Srini")



}
