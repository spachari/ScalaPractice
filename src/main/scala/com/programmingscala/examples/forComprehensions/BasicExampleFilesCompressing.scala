//package com.programmingscala.examples.forComprehensions

import java.io.File

object BasicExampleFilesCompressing {

  def apply(path : String, compressionNeeded : Boolean) : Seq[String] =
    for {
      line <- scala.io.Source.fromFile(path).getLines().toSeq
      if line.matches("""^\s*$""") == false //Filter in for loop
      line2 = line //Just to prove that we can assign local variables in for loop
      ints = 100 //Just to prove that we can assign local variables in for loop
      line3 = if (compressionNeeded) line2 replaceAll("""\\s+""","")
        else line2
    } yield line3


  def main(args: Array[String]): Unit = {
    for {
      arg <- args
      (path, bool) = if (arg.startsWith("-")) (arg, true) else (arg, false)
      line <- apply(path, bool)
    } println(line)

    //Another test for filtering items in for loop
    val list = List(1,2,3,4)

   val output =  for {
      l <- list
      if (l % 2 == 0) == false
    } yield l

    println(output)
  }

}
