package com.programmingscala.examples

object MakingAnArrayOfStrings {

  def main(args : Array[String]): Unit = {
    def upper(args : String*) = {
      args.map(_.toUpperCase())
    }

    val strings = ("hello", "World")

    println(upper("hello", "World"))
  }
}
