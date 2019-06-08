package com.scalaCookbook.examples.Files

import sys.process._
import java.io.File

object RedirectingOutputToFile extends App {

  val fileName = "/Users/spachari/IdeaProjects/untitled3/Input.txt"

  val result = ("ls" #> new File(fileName)).!
  val setFilePermission = Seq("chmod", "777", fileName).!
  println(result)
  println(setFilePermission)


  if (result == 0 && setFilePermission == 0)
    {
      val contents = ("cat " #< new File(fileName)).lineStream
      contents.foreach(println)
    }
  else
    {
      println("Could not write file")
    }

}
