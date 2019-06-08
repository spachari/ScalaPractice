package com.scalaCookbook.examples.Files

import java.io.{FileInputStream, FileOutputStream, IOException} //Used for opening binary files

object ReadingAndWritingABinaryFile extends App {

  var in : Option[FileInputStream] = None
  var out : Option[FileOutputStream] = None

  try
  {
    in = Some(new FileInputStream("/Users/spachari/Desktop/Spark-learning/SparkScala/twitter.txt"))
    out = Some(new FileOutputStream("/Users/spachari/Desktop/Spark-learning/SparkScala/binaryOutput.txt"))

    var c = 0
    while({c = in.get.read; c != -1})
    {
      out.get.write(c)
    }
  }
  catch {
    case e : IOException => println("Something has gone wrong ... ")
  }
  finally {
    if (in.isDefined) in.get.close()
    if (out.isDefined) out.get.close()
  }
}
