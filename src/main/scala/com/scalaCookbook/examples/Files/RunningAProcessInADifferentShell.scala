package com.scalaCookbook.examples.Files

import sys.process._
import java.io.File


object RunningAProcessInADifferentShell extends App {

  val file = "/Users/spachari/Desktop/Spark-learning/SparkScala"
  val output = Process("ls -al",new File(file)).lineStream_!
  output.foreach(println)

}
