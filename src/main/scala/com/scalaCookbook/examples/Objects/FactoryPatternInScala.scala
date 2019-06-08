package com.scalaCookbook.examples.Objects

trait Animal {
  def speak
}


object Animal {
  private class Dog extends Animal {
    override def speak: Unit = println("I say woof")
  }

  private class Cat extends Animal {
    override def speak: Unit = println("I say meow")
  }

  private class Def extends Animal {
    override def speak: Unit = println("Invalid option, please provide dog or cat")
  }

  //Option 1
   def apply (s : String) : Animal = {
     if (s.toUpperCase() == "CAT")
       new Cat
     else if (s.toUpperCase() == "DOG")
       new Dog
     else
       new Def
   }

  //Option 2
  def getAnimal (s : String) : Animal = {
    if (s.toUpperCase() == "CAT")
      new Cat
    else if (s.toUpperCase == "DOG")
      new Dog
    else new Def
  }
}

object FactoryPatternInScala extends App {
  val p = Animal("cat")
  p.speak

  val q = Animal("dog")
  q.speak

  val z = Animal("lion")
  z.speak

  val a = Animal.getAnimal("Cat")
  a.speak
}
