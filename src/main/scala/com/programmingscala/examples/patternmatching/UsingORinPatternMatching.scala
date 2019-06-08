package com.programmingscala.examples.patternmatching

object UsingORinPatternMatching extends App {

  for {
    x <- Seq(1, 2, 2.7, "one", "two", 'four)
  }
    {
      val s = x match {
        case _ : Int | _ : Double => s"found number  + ${x}"
        case "one" => "found one"
        case _ : String => "found String"
        case _ => s"Unexpected Value + ${x}"
      }
      println(s)
    }

}
