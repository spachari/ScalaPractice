package com.scalaCookbook.examples.Files

import sys.process._

object RunningShellScriptsFromScalaPart2 extends App {

  //Using !! to store the results of an output
  //The output is saved as a String
  val result = "ls".!!
  println(result)

  //Output is stored as a Stream
  val results = "ls".lineStream
  results.foreach(println)

  //We can use Process or Seq with this
  val results1 = Process("ls -ltr").lineStream
  results1.foreach(println)

  val results2 = "ls" #| "grep scala" !!
  val a = "ls" #| "grep .scala" #&& Seq("sh", "-c", "scalac *.scala") #|| "echo nothing found".lineStream
  println(results2.trim)

  val pwd = Process("pwd").!!
  println(pwd.trim)

  //Remember !! will give you an output if the file does not exist. We can counter it by using lineStream_!
  //Checking if hadoop exists and if not printing None
  val hadoop = "which hadoop2".lineStream_!.headOption
  println(hadoop)

  val javaV = "which java".lineStream_!.headOption
  println(javaV.getOrElse(None))

}
