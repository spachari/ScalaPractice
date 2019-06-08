package com.programmingscala.examples.concurrency.sysprocess

import scala.sys.process._

object UsingsysProcessCommands extends App {

  val myCmd = "ls -ltr /Users/spachari".!

  println(myCmd)

  //The same command can be written by
  val myCmdInSeq = Seq("ls", "-ltr", "/Users/spachari").!!

  println(myCmdInSeq)

  //counting the number of directories in "/Users/spachari"
  def countDirectories(directoryName : String) = {
    val myCommand = Seq("ls", "-ltr", directoryName)

    val totalLines = myCommand.!!.mkString("\n").toList
    totalLines.filter(_.toString startsWith("d"))
  }

  println(countDirectories("/Users/spachari"))
}
