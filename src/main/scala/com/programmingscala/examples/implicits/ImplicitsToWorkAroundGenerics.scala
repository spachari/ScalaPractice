package com.programmingscala.examples.implicits

//This object will not compile as the compiler will not know which method to get
/*
object Implicits {
  def m(seq : Seq[String]) = println(s"seq = ${seq}")
  def m(seq : Seq[Int]) = println(s"seq = ${seq}")
}
*/

object Implicits {
  implicit object Cat
  implicit object Donkey

  //Do not do the below
  //implicit object String
  //def m(seq : Seq[String])(implicit s : String) = println(s"seq = ${seq}")


  def m(seq : Seq[String])(implicit s : Donkey.type //This is how we can get an object's type
   ) = println(s"seq = ${seq}")
  def m(seq : Seq[Int])(implicit i : Cat.type ) = println(s"seq = ${seq}")
}

object ImplicitsToWorkAroundGenerics extends App {

  import Implicits._

  val intSeq = List(1,2,3,4)

  val intOutput = m(intSeq)


  val stringSeq = List("Srinivas", "Pachari")

  val stringOutput = m(stringSeq)


}
