package com.scalaCookbook.examples.Files

object DifferenceBetweenfromStringAndfromFile extends App {

  val fileName = "/Users/spachari/Desktop/Spark-learning/SparkScala/textFile.dat"

  def printSource(source : scala.io.Source) = {
    for(c <- source.getLines())
      {
        println(c)
      }
  }

  val line = scala.io.Source.fromFile(fileName)
  printSource(line)

  val line1 = scala.io.Source.fromString("/Users/spachari/Desktop/Spark-learning/SparkScala/textFile.dat")
  printSource(line1)

}
