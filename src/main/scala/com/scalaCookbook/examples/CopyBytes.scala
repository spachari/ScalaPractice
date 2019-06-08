package com.scalaCookbook.examples

import java.io.{FileInputStream, FileOutputStream, IOException}

object CopyBytes extends App {

  var in = None : Option[FileInputStream]
  var out = None : Option[FileOutputStream]

  try {
    in = Some(new FileInputStream("/Users/spachari/scala-learning/Hello.scala"))
    out = Some(new FileOutputStream("/Users/spachari/scala-learning/outputFile.dat"))

    var c = 0
    while ( {
      c == in.get.read; c != -1
    }) {
      out.get.write(c)
      println(c)
    }
  }
    catch {
    case e : IOException => println("File count not be found")
  }
    finally {
    println("Entered Finally")
      if (in.isDefined) in.get.close()
      if (out.isDefined) out.get.close()
  }
}

