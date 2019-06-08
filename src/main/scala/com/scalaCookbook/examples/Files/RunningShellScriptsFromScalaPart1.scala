package com.scalaCookbook.examples.Files

import sys.process._

object RunningShellScriptsFromScalaPart1 extends App {

  //Using the ! method, we can execute scripts and get return code
  val shellScript = "/Users/spachari/Desktop/Spark-learning/SparkScala/hello.sh"
  val variable = "Srinivas"

  def executeScript (script : String, variable: String ) : Int = {
    val cmd = script + " " + variable
    val exitCode = cmd.!
    println(exitCode)
    exitCode
  }

  def executeScriptAsSequence (script : String, variable: String ) : Int = {
    val cmd = Seq(script," ",variable)
    val exitCode = cmd.!
    println(exitCode)
    exitCode
  }


  executeScript(shellScript, variable)
  executeScriptAsSequence(shellScript, variable) //Did not work for as variables.

  val process = Process(shellScript + " " + variable)
  println(process.!)


  //Using the lines method, we can get the output of the command as a Stream
  val pwd = Process("pwd").lineStream
  pwd.foreach(println)

  val buildFile = Process("find . -name build.sbt").lineStream
  buildFile.foreach(println)

  //This does not work
  val buildFile1 = Process("find . -name \"build.sbt\"").lineStream
  buildFile1.foreach(println)
}
