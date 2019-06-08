package com.scalaCookbook.examples.Methods

class Arithmatic
{

  @throws(classOf[Exception])
  @throws(classOf[ArithmeticException])
  def divide(i : Int, j : Int) = i / j

  /*
  This is equivalent to writing this

  public void play() throws FooException {
  // code here ...
  }
  */

  //But Scala does not require us to write throws anyway
  def boom = {
    throw new Exception
  }
}

object MethodsRaisingExecptions extends App {
  val a = new Arithmatic
  println(a.divide(10,2))

  a.boom //We do not even need to enclose them in a try catch block
}
