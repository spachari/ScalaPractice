package com.scalaCookbook.examples.Files

import java.io.{FileNotFoundException, IOException}

import com.scalaCookbook.examples.Files.OpenAndReadATextFile.fileName

import scala.io.Source

object OpenAndReadATextFile extends App {


  //There are two primary ways to open and read a text file:

  //1. Use a concise, one-line syntax. This has the side effect of leaving the file open, but can be useful in short-lived programs,
  // like shell scripts.

  val fileName = "/Users/spachari/Desktop/Spark-learning/SparkScala/twitter.txt"
  for (line <- Source.fromFile(fileName).getLines) {
    println(line)
  }

  //The fromFile method returns a BufferedSource, and its getLines method treats “any of \r\n, \r, or \n as a
  // line separator (longest match),” so each element in the sequence is a line from the file.

  val list = Source.fromFile(fileName).getLines.toList
  val array = Source.fromFile(fileName).getLines.toArray

  //But this will nto close the resource that opens the file. A proper way of doing this


  //Use a slightly longer approach that properly closes the file.
  val bufferedResource = Source.fromFile(fileName)

  for (line <- bufferedResource) {
    if (line == "\n") {
      println()
    }
    else {
      print(line)
    }
  }

  bufferedResource.close()

  //Automatically closing a file

  //Opening a file in try/catch block and catching exceptions
  try {
    val bufferedResource = Source.fromFile(fileName).getLines.toList
    var lineNo = 1
    for (line <- bufferedResource) {
      lineNo += 1
      println(line)
    }
  }
  catch {
    case x: FileNotFoundException => println("File not present")
    case x: IOException => println("java IO Exception")
    case x: Exception => println("Something has happened")
  } finally {
    bufferedResource.close()
  }


  //THis will automatically close the
  import resource._

  def readFile(string: String) = {
    for (source <- managed(scala.io.Source.fromFile(fileName))) {
      val list = for (lines <- source.getLines()) yield {
        lines
      }
    }
    Some(list)
  }

  def printFile(file: Option[List[String]]) = {
    file match {
      case x: Some[line] => x.get.foreach(println)
      case _ => println("file not found")
    }
  }

  val result = readFile(fileName)
  printFile(result)

  /*
  import scala.io.Source

  for (line <- Source.fromFile("/Users/spachari/Desktop/Spark-learning/SparkScala/twitter.txt").getLines) {
    val fields = line.split(" ")
    if (fields.length == 2) {
      println("twitter4j.oauth." + fields(0), fields(1))
    }
  }
  */


}
