package com.programmingscala.examples.patternmatching

object PatternMatchingWithRegularExpressions extends App {

  val BookMatchingExtractorRE = """Book: ([^,]+),\s+author:(.+)""".r
  val MagazineMatchingExtratorRE = """Magazine: ([^,]+),\s+issue:(.+)""".r

  val data = Seq("Book: Scala Programming, author: Martin Odernsky",
                 "Magazine: The NewYorker, issue: Number 73",
                 "Unknown: Who put this there")

  for (s <- data) {
    s match {  //Use them like case classes, where the string matched by each capture group is assigned to a variable.
      case BookMatchingExtractorRE(title, author) => println(s"Book is ${title} and author is ${author}")
      case MagazineMatchingExtratorRE(magazine, issue) => println(s"Magazine is ${magazine} and cover is ${issue}")
      case unknown => println(s"Not sure what this is ${unknown}")
    }
  }

}
