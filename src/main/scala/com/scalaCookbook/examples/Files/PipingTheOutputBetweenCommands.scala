package com.scalaCookbook.examples.Files

import sys.process._

object PipingTheOutputBetweenCommands extends App  {

  val numProcs = ("ps -ef" #| "wc -l").!!.trim

  println(numProcs)

  val sparkProcesses = ("ps -ef" #| "grep spark").!!.trim
  println(sparkProcesses)

  //#\ should be used instead of |

  //If we want to use | it could be done in a Seq
  val pwd = Seq("ls","-ltr").lineStream
  pwd.foreach(println)

  val scalaFiles = ("ls /Users/spachari/IdeaProjects/untitled3/src/main/scala/com/scalaCookbook/examples/Files/" #| "grep .scala").lineStream
  scalaFiles.foreach(println)


  //val scalaFiles1 = Seq("/Users/spachari/IdeaProjects/untitled3/src/main/scala/com/scalaCookbook/examples/Files", "-c", "ls | grep .scala").!!
  //println(scalaFiles1)

  //val r = Seq("/bin/sh", "-c", "ls | grep .scala").!!
}
