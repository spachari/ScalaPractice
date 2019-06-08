package com.scalaCookbook.examples.Files

import java.io.{BufferedWriter, File, FileWriter, PrintWriter}

object WritingAFile extends App
{

  val fileName = "/Users/spachari/Desktop/Spark-learning/SparkScala/tweets.txt"
  val newFile = "/Users/spachari/Desktop/Spark-learning/SparkScala/test.txt"
  val pw = new PrintWriter(new File(newFile))

  pw.write("Hello, World\n")

  val bufferedWriter = new BufferedWriter(new FileWriter(newFile))

  for (c <- scala.io.Source.fromFile(fileName))
    {
      pw.append(c)

    }

  pw.close

}
