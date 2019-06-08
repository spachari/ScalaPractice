package com.dickWall.scala.revision.part1

object RewritingRules extends App {


  //Re-writing rule 1:



  val array = Array("John", "Jane")

  println(array(0)) //what happens here is that array.apply(0) method s called

  //This is called re-writing rules

  array(1) = "Zoe"

  //This then calls the array.update(1) = "Zoe"
  //A singleton immedietely followed by a paranthesis generally has this apply method

}
