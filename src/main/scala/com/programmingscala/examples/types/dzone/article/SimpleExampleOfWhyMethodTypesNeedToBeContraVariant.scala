package com.programmingscala.examples.types.dzone.article

object SimpleExampleOfWhyMethodTypesNeedToBeContraVariant extends App {

  trait Animal
  trait Cow extends Animal
  def iNeedACowHerder(herder: Cow => Unit, c: Cow) = herder(c)
  def iNeedAnAnimalHerder(herder: Animal => Unit, a: Animal) = herder(a)
  iNeedACowHerder({ a: Animal => println("I can herd any animal, including cows") }, new Cow {})

  //is okay, as our animal herder can herd cows, but
  //iNeedAnAnimalHerder({ c: Cow => println("I can herd only cows, not any animal") }, new Animal {})

}
