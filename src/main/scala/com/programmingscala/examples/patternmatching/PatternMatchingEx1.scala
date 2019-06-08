package com.programmingscala.examples.patternmatching

object PatternMatchingEx1 extends App {

  for {x <- Seq(1,3,2.7, "one", "two", 'plus)}
    {
     val s =  x match {
        case 1 => "int 1"
        case i : Int => s"int ${i}"
        case d : Double => s"double ${d}"
        case s : String => s"other string ${s}"
        case unexpected => s"Cannot identify"
      }
      println(s)
    }

}
