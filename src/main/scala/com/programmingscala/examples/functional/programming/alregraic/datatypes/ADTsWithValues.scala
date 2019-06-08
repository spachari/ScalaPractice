package com.programmingscala.examples.functional.programming.alregraic.datatypes


object Breeds extends Enumeration {
  sealed trait Breed1 {val name : String }
  case object daubermann extends Breed1 { val name = "daubermann dog" }
  case object yorkie extends Breed1 { val name = "yorkie" }
  case object scottie extends Breed1 { val name = "scotish terrier"}
}



object ADTsWithValues extends App {

  val breed = Breeds.daubermann

  println(breed.name)

}
