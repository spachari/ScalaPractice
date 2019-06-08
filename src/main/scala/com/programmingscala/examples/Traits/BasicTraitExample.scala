package com.programmingscala.examples.Traits

class ServiceImportante(name : String) {
  def work(i : Int) : Int = {
    println(s"ServiceImportante : Doing important work ${i}")
    i
  }
}

trait Logging {
  def info (message : String) : Unit
  def warning (message : String) : Unit
  def error (message : String) : Unit
}

trait StdOutLogging extends Logging {
  def info(message : String) = println(s"INFO : ${message}")
  def warning(message : String) = println(s"WARNING : ${message}")
  def error(message : String) = println(s"ERROR : ${message}")
}

object BasicTraitExample extends App {

  val s = new ServiceImportante("Srinivas")
  (0 to 3) foreach (x => s.work(x))

  val sWithLogging = new ServiceImportante("dos") with StdOutLogging {

    override def work(i: Int): Int = {
      info(s"starting work ${i}")
      val result = super.work(i)
      info(s"Completing work ${i}")
      result
    }
  }

  (0 to 3) foreach (x => sWithLogging.work(x))

}
