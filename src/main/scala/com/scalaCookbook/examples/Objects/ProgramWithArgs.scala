package com.scalaCookbook.examples.Objects

object ProgramWithArgs extends App { //scala programs should always start with an object not class

  if (args.length == 1)
    println(s"Hello ${args(0)}")
  else
    println(s"Hello unknown visitor")
}
