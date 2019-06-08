package com.programmingscala.examples.scalaObjectSystem.overriding.abs.and.conc

trait Abstract1 {
  println("In Abstract1")
  val value : Int
  val inverse = 1.0 / value
  println("Abstract1: value "+value+" inverse = "+inverse)
}

trait Abstract2 {
  println("In Abstract2")
  val value : Int
  lazy val inverse = 1.0 / value
  //println("Abstract2: value"+value+" inverse = "+inverse)
}

trait Abstract3 {
  println("In Abstract3")
  val value : Int
  val inverse = 1.0 / value
  println("Abstract2: value"+value+" inverse = "+inverse)
}

object OverridingAbstractAndConcFields extends App {

  val obj = new Abstract1 {
    println("In obj")
    val value = 10
  }

  //Problem: Note that the problem is inverse is calculated too early
  println("obj value : " + obj.value + ", inverse : " + obj.inverse)

  //Solution 1. Lazy vals to the rescue
  val obj1 = new Abstract2 {
    override val value: Int = 10
  }


  println("obj value : " + obj1.value + ", inverse : " + obj1.inverse)
  //However, lazy only helps if the println statement is not used. If you remove the // and run it,
  // you’ll get Infinity again, because lazy only defers evaluation until the value is used. The println
  // statement forces evaluation too soon.

  //Note: If we use a val as lazy, make sure we have all usage of the vals are lazy as possible

  //Solution 2: Pre-initialised blocks

  val obj2 = new {
    //println("In obj2")
    val value = 10
  } with Abstract2

  println("obj value : " + obj2.value + ", inverse : " + obj2.inverse)
  //Note: Only type definition and concrete definition fields are allowed in pre-initilization fields are possible
  //in pre-initilisation blocks
}
