package com.programmingscala.examples.types.contextBound.and.viewBound.example

import com.programmingscala.examples.types.contextBound.and.viewBound.example.SerializationTest.typeWritable


object Serialization1 {
  case class Rem[A] (value : A) {
    def serialized = s" --$value-- "
  }

  type Writable[A] = A => Rem[A]

  implicit val fronInt : Writable[Int] = (i : Int) => Rem[Int](i)
  implicit val fromString : Writable[String] = (s : String) => Rem[String](s)
  implicit val fromDouble : Writable[Double] = (d : Double) => Rem[Double](d)

}

object SerializationTest {
  case class Writable1[A] (value : A) {
    def serialized = s" --$value-- "
    def myMethod = s"$value"
  }

  type typeWritable[A] = A => Writable1[A] //Note: This is a type that takes a A and gives you Writable of A
  //(Int) => Writable1[Int]

  implicit val fronInt : typeWritable[Int] = (i : Int) => Writable1[Int](i)
  implicit val fromString :  typeWritable[String] = (s : String) => Writable1[String](s)
  implicit val fromDouble : typeWritable[Double] = (d : Double) => Writable1[Double](d)

}

//Could the above be written as this



object RemoteConnection1 extends App {

  import com.programmingscala.examples.types.contextBound.and.viewBound.example.Serialization1.Writable


  def write[T : Writable](t : T) : Unit = {
    println(t.serialized)
  }

  write(10)
  write("Srinivas")
  write(10.0)

  def write1[T : typeWritable](t : T) : Unit = {
    println(t.serialized)
  }

  write1(10)
  write1("Srinivas")
  write(11.0)
}
