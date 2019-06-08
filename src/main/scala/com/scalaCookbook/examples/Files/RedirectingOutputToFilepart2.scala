package com.scalaCookbook.examples.Files

import java.io.File
import sys.process._

object RedirectingOutputToFilepart2 extends App {

  //Writing output of a command into a file
  val result = ("ls /Users/spachari/Desktop/Spark-learning/SparkScala/" #> new File("/Users/spachari//Desktop/Spark-learning/SparkScala/outputFile.txt")).!
  println(result)

  val contents = ("cat" #< new File("/Users/spachari//Desktop/Spark-learning/SparkScala/outputFile.txt")).!!
  println(contents)

  //This means we can use #> as a pipe too
  val fileRecords = ("cat /Users/spachari//Desktop/Spark-learning/SparkScala/outputFile.txt" #> "wc -l").!!.trim
  println(fileRecords)

  //Appending something to a file
  val totalLinesInFile = ("ls /Users/spachari/Desktop/Spark-learning/SparkScala/" #| "wc -l" #>> new File("/Users/spachari/Desktop/Spark-learning/SparkScala/outputFile.txt")).!!.trim
  println(totalLinesInFile)

  val contents1 = ("cat" #< new File("/Users/spachari//Desktop/Spark-learning/SparkScala/outputFile.txt")).!!
  println(contents1)

  val file = new File("/Users/spachari//Desktop/Spark-learning/SparkScala/allProcesses.txt")
  //adding all processes into a file
  val processes = ("ps -ef" #| "grep java" #> file).!
  println(processes)

  //Now Read the file and the number of lines in the file
  val lines = ("cat" #< file #| "wc -l").!!.trim
  println(lines)

  val printFiles = ("cat" #< file).lineStream
  printFiles.foreach(println)

  //We can use #> as a #| too
  //Basically all these #| and #< and #> are building two ProcessBuilder objects together
  val lines1 = ("cat" #< file #> "wc -l").!!.trim
  val result1 = (s"cat ${file}" #> "wc -l").!
  println("result1 = " + result1)

  println("lines 1 " + lines1)

}
