package callByName.examples

import callByName.examples.NonByNameExample.time

object NonByNameExample extends App {

  def time(): Long = {
    println("In Time")
    System.nanoTime()
  }

  def exec(t : Long) : Long = {
    println("Entered Exec, calling t.... ")
    println( "t - " + t)
    println("Calling t again .... ")
    t
  }

    println("Non By Name example")
    println(exec(time()))

}

object ByNameExample extends App {

  def time(): Long = {
    println("In Time")
    System.nanoTime()
  }

  def exec(t : => Long) : Long = {
    println("Entered Exec, calling t.... ")
    println( "t - " + t)
    println("Calling t again .... ")
    t
  }

    println("By Name example")
    println(exec(time()))
}



object Main {
  def main(args: Array[String]): Unit = {
    println("ByNameExample ... ")
    val t = ByNameExample.exec(time())
    println("Output is " + t)

    println("NonByNameExample ... ")
    val ti = NonByNameExample.exec(time())
    println("Output is " + ti)

  }
}