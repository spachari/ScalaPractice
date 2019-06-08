#!/bin/sh
exec scala "$0" "$@"
!#

case class Person(name : String)

object MyFile {
  def main (args : Array[String]) = {
    val al = new Person("Srinivas")
    println(al)
  }
}

MyFile.main(args)
