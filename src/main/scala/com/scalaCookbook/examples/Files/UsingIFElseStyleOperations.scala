package com.scalaCookbook.examples.Files

import sys.process._

object UsingIFElseStyleOperations extends App {

  //Use the Scala operators #&& and #||, which mirror the Unix && and || operators:

  val result = ("ls temp" #&& "rm temp" #|| "echo 'File not found'").!!.trim
  println(result)

  val scalaFiles = ("ls *.scala" #&& "scalac *.scala" #|| "echo 'No scala files found'").!!.trim
  println(result)

  val pwd = ("pwd").!!
  println(pwd)


  //A cleaner way of doing this is
  val listScalaFiles = Seq("/bin/sh","-c","ls tweets.txt")
  val compileScalaFiles = Seq("/bin/sh","-c","cat tweets.txt")
  val results = (listScalaFiles #&& compileScalaFiles #|| "echo 'No scala files found'").!!.trim
  println(results)


}
