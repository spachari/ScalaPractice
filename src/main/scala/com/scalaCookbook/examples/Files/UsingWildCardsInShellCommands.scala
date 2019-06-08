package com.scalaCookbook.examples.Files

import sys.process._

object UsingWildCardsInShellCommands extends App {

  //We can run the command in a bourne shell
  //If the -c option is present, then commands are read from string.
  val status = Seq("/bin/sh", "-c", "ls /Users/spachari/Desktop/Spark-learning/SparkScala/*.txt").!!
  //val status1 = Seq("/bin/sh", "-c", "echo *").!
  println(status)


}
