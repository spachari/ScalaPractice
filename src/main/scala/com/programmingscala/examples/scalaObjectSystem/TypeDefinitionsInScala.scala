package com.programmingscala.examples.scalaObjectSystem

object TypeDefinitionsInScala extends App {

  //To encourage the use of immutable collections, Predef defines aliases
  // for the most popular, immutable collection types:

  //type Map[A, +B]       = collection.immutable.Map[A, B]
  //type Set[A]           = collection.immutable.Set[A]
  //type Function[-A, +B] = Function1[A, B]

  //This is the reason we get an immutable Map whenever we create a Map we get an immutable Map

  val m = Map(1 -> "Srinivas", 2 -> "Kirthika")

  println(m.getClass.getName)

}
