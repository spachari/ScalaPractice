package com.scalaCookbook.examples.Packages




object StaticImportsInScala extends App {



  val c = Math.sin(30)


  //We can use imports to import static classes in scala
  import java.lang.Math._
  val b = sin(30)

  //This technique is very useful when we want to use enums.
  import com.srinivas.utils.Day._


  val day = "Monday"
  if (MONDAY.toString.equals(day.toUpperCase) || day.toUpperCase() == TUESDAY ) {
    println("it's boring")
  }
  println(MONDAY.toString)

}
