package com.scalaCookbook.examples.Files

import sys.process._

object ProcessLoggerSavingOutput extends App {

  val stdOut = new StringBuilder
  val stdErr = new StringBuilder

  val output = Process("ls -ltr Fred") ! ProcessLogger(stdOut append _, stdErr append _)
  println(output)
  println("stdOut : " + stdOut)
  println("stdErr : " + stdErr)

  val output1 = Process("pwd") ! ProcessLogger(stdOut append _, stdErr append _)
  println(output1)
  println("stdOut : " + stdOut)
  println("stdErr : " + stdErr)

  val output2 = Process("ls -ltr build.sbt") ! ProcessLogger(stdOut append _, stdErr append _)
  println(output1)
  println("stdOut : " + stdOut)
  println("stdErr : " + stdErr)

  //THis technique is very useful when we hva both ooutput and err
  val output3 = Seq("find","/Users/spachari","-name","hello.sh") !
    ProcessLogger(stdOut append _, stdErr append _)
  println("stdOut : " + stdOut)
  println("stdErr : " + stdErr)
}
