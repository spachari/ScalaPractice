package com.scalaCookbook.examples.Methods

class Connection {
  def makeConnection(timeout : Int = 1000 , protocols : String = "https"): Unit =
  {
    println(s"timeout = ${timeout} and protocol = ${protocols}")
  }
}

//If we are using defaults, we need to use the defaults in the last
//Wrong way
class WrongConnection {
  def makeConnection(timeout : Int = 10, protocols : String) = {
    println(s"timeout = ${timeout} and protocol = ${protocols}")
  }
}

class RightConnection {
  def makeConnection(timeout : Int, protocols : String = "https") = {
    println(s"timeout = ${timeout} and protocol = ${protocols}")
  }
}


object SettingDefaultValuesForMethodParameters extends App {
  val p = new Connection
  p.makeConnection()
  p.makeConnection(10)
  p.makeConnection(10,"TCP")

  val q = new WrongConnection
  //q.makeConnection(10) Both will not work
  //q.makeConnection("TCP")
  q.makeConnection(timeout = 1, protocols = "tcp") //this way will work , even you can jumble the order

  val r = new RightConnection
  r.makeConnection(10)
  r.makeConnection(10,"tcp")

  r.makeConnection(protocols = "dfg", timeout = 100) //even you can jumble the order
}
