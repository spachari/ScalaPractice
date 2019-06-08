package com.programmingscala.examples.forComprehensions

import com.programmingscala.examples.forComprehensions.RegularExpressionsInForComprehension.kvRegex

object RegularExpressionsInForComprehension extends App {

  val ignoreRegex = """^\s*(#.*|\s*)$""".r
  val kvRegex = """^\s*([^=]+)\s*=\s*([^#]+)\s*.*$""".r

  val properties = """
                     |# Book properties
                     |
                     |book.name = Programming Scala, Second Edition # A comment
                     |book.authors = Dean Wampler and Alex Payne
                     |book.publisher = O'Reilly
                     |book.publication-year = 2014
                     |""".stripMargin

  val output = for {
    prop <- properties.split("\n")
    if ignoreRegex.findFirstIn(prop) == None
    kvRegex(key, value) = prop
  } yield (key.trim, value.trim)

  output.foreach(println)

}
