package com.scalaCookbook.examples



class CreateFileIO {
  lazy val test  = {
    var lines = ""
    try {
      lines = scala.io.Source.fromFile("/Users/spachari/scala-learning/DefaultValues.scala").getLines().mkString("")
    }
    catch {
      case e : Exception => s"File not found"
    }
    lines
  }
  println(test)
}


object ReadFileAssignBlockOfTextToCluster extends App {
  val p = new CreateFileIO

}
