package com.programmingscala.examples.oopsInScala


//Points on value classes

//At compile time the type is the outer type, Dollar in this example. The runtime type is the wrapped type, e.g., Float.

//Usually the argument is one of the AnyVal types, but it doesn’t have to be. If we wrap a reference type, we still benefit
// from not allocating the wrapper on the heap, as in the following implicit wrapper for Strings that are phone numbers:

class USPhoneNumber(val s : String) extends AnyVal {
  override def toString: String = {
    val digs = digits(s)
    val areaCode = digs.substring(0,3)
    val exchange = digs.substring(3,6)
    val subnumber = digs.substring(6,12)

    s"(${areaCode})-${exchange} ${subnumber}"
  }

  private def digits(str : String) : String = str.replaceAll("""\D""","")
}

object SimpleValueClass extends App {

  val usPhoneNumber = new USPhoneNumber("987-678-123456")

  println(usPhoneNumber)
}
