package com.scalaCookbook.examples.Files

import java.io.File

object ListingSubDirectoriesInADirectory extends App {

  def printSubDirectoriesOnly (s : String) = {
    val file = new File(s)

    val directoryList = for(i <- file.listFiles()
    if i.isDirectory) yield
      {
        i
      }
    directoryList.toList
  }

  val output = printSubDirectoriesOnly("/Users/spachari/Desktop/Spark-learning/SparkScala")
  output.foreach(println)

  def isDirectory (f : File) = f.isDirectory

  def directoryChecker (s : File) : File = s match {
    case s if s.isDirectory => println(s.listFiles()); directoryChecker(s)
    case _ => new File("out")
  }

  def checkSubDirectories (f : File) = {
    for (c <- f.listFiles())
      {
        directoryChecker(c)
      }
  }

  //checkSubDirectories(new File("/Users/spachari/Desktop/Spark-learning/SparkScala"))
  //recursiveDirectoryFinder(new File("/Users/spachari/Desktop/Spark-learning/SparkScala"))
}
