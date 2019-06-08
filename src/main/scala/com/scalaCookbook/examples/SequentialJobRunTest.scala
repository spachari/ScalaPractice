package com.scalaCookbook.examples

object SequentialJobRunTest extends App {

  def sleepAndPrint(int : Int) = {
    Thread.sleep(4000)
    println(int)
  }

  (0 to 0) foreach(i => sleepAndPrint(i))

}
