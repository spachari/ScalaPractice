package com.programmingscala.examples.types.typeProjections

//Path dependent types problem

class ServiceTest {
  class Logger {
    def log (message : String) : Unit = println(s"log : $message")
  }

  val logger = new Logger
}

object ProblemExample extends App {

  val s1 = new ServiceTest
  //val s2 = new Service { override val logger = s1.logger} //Does not work
  //s2 object cannot use s1's logger


}
