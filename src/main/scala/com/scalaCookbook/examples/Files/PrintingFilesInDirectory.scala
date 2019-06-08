package com.scalaCookbook.examples.Files

import java.io.File


object PrintingFilesInDirectory extends App {

  def listFilesInDirectory (s : String) = {
    val file = new File(s)

    val listOfFiles = if (file.isDirectory && file.exists())
      {
        file.listFiles().filter(x => x.isFile).toList
      }
    else //if (file.isFile && file.exists())
    {
      file
    }
    listOfFiles
  }

  val checkFilesInDirectory = listFilesInDirectory("/Users/spachari/Desktop/Spark-learning/SparkScala")
  println(checkFilesInDirectory)
  val outputAsList = checkFilesInDirectory.toString.split(",")
  outputAsList.foreach(println)

  def printTextFilesIntheDirectory (s : String) = {
    val file = new File(s)

    if (file.isDirectory && file.exists())
      {
        file.listFiles().filter(x => x.getName.endsWith("txt")).toList
      }
    else if (file.isFile && file.getName.endsWith("txt"))
      {
        file
      }
    else if (file.exists() && !file.getName.endsWith("txt"))
      {
        println("Cannot find File" + file.toString)
      }

  }

  val x = printTextFilesIntheDirectory("/Users/spachari/Desktop/Spark-learning/SparkScala/SparkScalaCode")
  println(x)

  //Printing all files in the list
  val myExensions = List("scala","txt")
  def getFilesWithMyExtensions (dirName : String, extensions : List[String]) = {
    val dir = new File(dirName)
    dir.listFiles().filter(_.isFile).toList.filter { file =>
      extensions.exists(x => file.getName.endsWith(x))  //This is a neat way to filter on two lists
    }
  }

  val y = getFilesWithMyExtensions("/Users/spachari/Desktop/Spark-learning/SparkScala/SparkScalaCode", myExensions)
  y.foreach(println)

}
