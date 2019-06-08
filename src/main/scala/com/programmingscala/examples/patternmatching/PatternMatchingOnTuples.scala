package com.programmingscala.examples.patternmatching

object PatternMatchingOnTuples extends App {

  val seq = Seq(("Scala","Srinivas","Pachari"),("Lisp","Martin","Singh"),("Haskell","Frazer","Clayton"))

  for { s <- seq} {
    s match {
      case ("Scala", x, y) => println(s"Found scala by ${x}, ${y}")
      case (_,_,_) => println(s"Found other language")
    }

  }



}
