package com.programmingscala.examples.patternmatching

//We can directly use the variable that was used in match alogn with _
object UsingVariableusedinMatchExpressionForCaseStatement extends App {

  for {x <- Seq(1, 3, 2.7, "one", "two", 'plus)}
    {
      val s = x match {
        case 1 => "int 1"
        case _ : Int => s"int ${x}"
        case _ : Double => s"double ${x}"
        case "one" => "string one"
        case _: String => "other string " + x
        case _ => "unexpected error"
      }
      println(s)
    }


}
