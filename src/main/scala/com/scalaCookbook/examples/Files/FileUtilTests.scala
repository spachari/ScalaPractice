package com.scalaCookbook.examples.Files

import org.scalatest.{BeforeAndAfter, FunSuite}

class FileUtilTests extends FunSuite with BeforeAndAfter {

  var source : scala.io.Source = _
  after{ source.close() }

  test("testing function with a string") {
    source = scala.io.Source.fromString("/Users/spachari/Desktop/Spark-learning/SparkScala/textFile.dat")

    val lines = FileUtils.getFileAsList(source)

    assert(lines(0) == "/USERS/SPACHARI/DESKTOP/SPARK-LEARNING/SPARKSCALA/TEXTFILE.DAT")
  }

  test("testing function with a file") {
    source = scala.io.Source.fromFile("/Users/spachari/Desktop/Spark-learning/SparkScala/textFile.dat")

    val lines = FileUtils.getFileAsList(source)

    assert(lines(0) == "MONTH, REVENUE1, REVENUE2, REVENUE3")
  }

}
