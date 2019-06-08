package com.scalaCookbook.examples.Files

object FileUtils {

  def getFileAsList(source : scala.io.Source) : List[String] = {
    val lines = for (c <- source.getLines()) yield { c.toUpperCase }
    lines.toList
  }

  val source = scala.io.Source.fromString("/Users/spachari/Desktop/Spark-learning/SparkScala/textFile.dat")
  println(getFileAsList(source))

}
