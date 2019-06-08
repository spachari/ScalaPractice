package com.programmingscala.examples.concurrency.sysprocess

import java.io.File
import java.net.URL

import scala.sys.process._

//Note that they are run by starting an independent synchronous processes
//These are small, synchronous processes that coordinate state

object UsingSysProcessCommands2 extends App {

  //#> is used to connect the processes. THe below method, gets data from an URL and
  // filters lines that contains scala. #> is used to pipe the output the processes. if one process is successful, it will connect the next one
  // write output to a text file. #>> is used to write the data to a file
  def getDataFromURL(url : String, filter : String) = {
    new URL(url)  #> s"grep ${filter}" #>> new File(s"/Users/spachari/IdeaProjects/untitled3/${filter}.txt")
  }

  getDataFromURL("http://scala-lang.org","scala") .!

  def openFile(s : String) = {
    val pwd = "pwd" . !
    val output =  scala.io.Source.fromFile(new File("/Users/spachari/IdeaProjects/untitled3/" + s)).getLines()
    output.foreach(println)
  }

  //openFile("scala.txt")

  def countLinesOfFile(file : String) = {
    s"ls ${file}" #&& s"wc -l ${file}"
  }

  countLinesOfFile("scala.txt") .!

  //#&& executes the command to the right when the command to the left is succeeded


}
