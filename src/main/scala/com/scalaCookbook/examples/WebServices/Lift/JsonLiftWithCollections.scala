package com.scalaCookbook.examples.WebServices.Lift

import net.liftweb.json.JsonDSL._
import net.liftweb.json.{compactRender, prettyRender}

object JsonLiftWithCollections extends App {

  //compactrender is used for communicating with other systems
  val list = List(1,2,3)
  println(compactRender(list))

  val map = Map("Srinivas" -> "Kirhtika", "Sidharth" -> "Smitha")
  println(compactRender(map))

  //prettyrender is used for printing them in nicer format

  println(prettyRender(list))

  println(prettyRender(map))


}
