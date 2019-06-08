package com.programmingscala.examples.oopsInScala

import com.programmingscala.examples.oopsInScala.UniversalTraitInAction.USPhoneNumber1

//Scala's rule for inheritance do not permit value classes to extend traits that extend from AnyRef .
// To permit value classes to extend traits, we introduce universal traits, which extend from Any . A universal trait T
// needs to explicitly extend class Any .



object UniversalTraitInAction  extends App {
  trait Ditgitizer extends Any {
    def digit (s : String) = s.replaceAll("""\D""","")
  }

  trait USPhNoFormatter extends Any {
    def format(areaCode : String, exchange : String, subnumber : String) = {
      s"(${areaCode})-${exchange} ${subnumber}"
    }
  }

  class USPhoneNumber1(val s : String) extends AnyVal with USPhNoFormatter with Ditgitizer {
    def digs : String = digit(s)



    override def toString: String = {
      def areacode = digs.substring(0,3)
      def exchange = digs.substring(3,6)
      def subnumber = digs.substring(6,12)


      format(areacode, exchange, subnumber)
    }
  }

  trait IndianPhNoFormatter extends Any {
    def format(areaAndExcahngeCode : String, subnumber : String) = {
      s"$areaAndExcahngeCode-$subnumber"
    }
  }

  class IndianPhoneNumber(val s : String) extends AnyVal with Ditgitizer with IndianPhNoFormatter {
    def digs = digit(s)

    override def toString: String = {
     val areaCode = digs.substring(0,6)
      val subNumber = digs.substring(6)
      format(areaCode, subNumber)
    }
  }



  val usPhoneNumber1 = new USPhoneNumber1("987-678-123456")

  println(usPhoneNumber1)

  val indianPhoneNumber1 = new IndianPhoneNumber("987-678-123456")

  println(indianPhoneNumber1)


  //However there are times where value classes has to be instantiated. i.e stored in the heap (allocation) instead of stack

  //When a value class instance is passed to a function expecting a universal trait implemented by the instance.
  // However, if a function expects an instance of the value class itself, instantiation isn’t required.

  //The following will need instantiation
  def toDigits(d: Ditgitizer, str: String) = d.digit(str)

  val digs = toDigits(new USPhoneNumber1("987-678-123456"),"123-Hello-345") //Note that when a new trait is needed
  //you can call it with an instance that is created from a class that inherits it

  println(digs)

  //A value class instance is assigned to an Array.

  val arr = Array(new  USPhoneNumber1("987-678-123456"),  new USPhoneNumber1("987-678-123456"))

  //The type of a value class is used as a type parameter.
  def myPrint[T](t : T) = println(t)

  myPrint(new USPhoneNumber1("987-678-123456"))


  //The term value type refers to the Short, Int, Long, Float, Double, Boolean, Char, Byte, and Unit types Scala has had
  // for a long time. The term value class refers to the new construct for defining custom classes that derive from AnyVal.


}
