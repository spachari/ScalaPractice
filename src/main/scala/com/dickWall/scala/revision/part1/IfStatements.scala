package com.dickWall.scala.revision.part1

object IfStatements extends App {

  //In Scala if can be used as an expression or a statement.
  //As expression
  val defaultName = "Default.txt"
  val arg : Array[String] = Array.empty
  val x : String = if (arg.length < 0) arg(0) else defaultName
  println(x)

  //As Statement
  var generatedName : String = ""

  if (arg.length < 0) {
    println("File found")
    generatedName = arg(0)
  } else {
    println("File not found")
    generatedName = defaultName
  }

  println(generatedName)
}
