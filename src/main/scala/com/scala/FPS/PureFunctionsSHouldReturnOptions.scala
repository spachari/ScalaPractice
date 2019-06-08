package com.scala.FPS

object PureFunctionsShouldReturnOptions extends App {

  //Pure functions never throw Exceptions. Use Option[]

  def makeInt (s : String) : Option[Int] = {
    try {
      Some(s.trim.toInt)
    }
    catch {
      case e : Exception => None
    }
  }

  def printOutput(i : Option[Int]) : Unit = i match {
    case Some(x) => println(s"i = ${x}")
    case None => println("Because of bad input, we cannot print output ... ")
  }

  val output = for {i <- makeInt("1")
                    j <- makeInt("2")
                    k <- makeInt("3")} yield i + j + k

  printOutput(output)

  val output1 = for {
    i <- makeInt("1")
    j <- makeInt("Srinivas")
    k <- makeInt("Pachari")
  } yield i + j + k

  printOutput(output1)

}
