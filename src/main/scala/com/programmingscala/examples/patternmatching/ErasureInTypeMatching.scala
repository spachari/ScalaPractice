package com.programmingscala.examples.patternmatching

object ErasureInTypeMatching extends App {

  for (s <- Seq(Seq(2.3,4,5,6.7), Seq("fruits","apple"))) {
    s match {
      case _ : Seq[Double] => println("Found a double list " + s)
      case _ : Seq[String] => println("Found a string list " + s)
      case _ => println("Unknown type ...")
    }
  }

  //Wrong output
  //Found a double listList(2.3, 4.0, 5.0, 6.7)
  //Found a double listList(fruits, apple)

  //This can be gotten around by using ClassTag or TypeTag

  import scala.reflect.{ClassTag, classTag}

  def matchListClassTagWay [A : ClassTag] (seq : Seq[A]) = {
    seq match {
      case s : Seq[Double @unchecked] if classTag[A] == classTag[Double] => println("Found a double list " + seq)
      case s : Seq[String @unchecked] if classTag[A] == classTag[String] => println("Found a string list " + seq)
      case _ => println("Unknown list " + seq.getClass.getCanonicalName)
    }
  }

  matchListClassTagWay(Seq(2.3,4,5,6.7))
  matchListClassTagWay(Seq("fruits","apple"))

  import scala.reflect.runtime.universe._
  //Using TypeTags
  def matchListTypeTagWay [A : TypeTag] (seq : Seq[A]) = {
    seq match {
      case _ : Seq[Double @unchecked] if typeOf[A] =:= typeOf[Double] => println("Found a double list " + seq)
      case _  : Seq[Double @unchecked] if typeOf[A] =:= typeOf[String] => println("Found a string list " + seq)
      case _ => println("Unknown list " + seq.getClass.getCanonicalName)
    }
  }

  matchListTypeTagWay(Seq(2.3,4,5,6.7))
  matchListTypeTagWay(Seq("fruits","apple"))

  //Even these will not work in a Seq because as soon as you add them to a

  def checkType[T](seq : Seq[T]) = seq match {
    case head +: tail => head match {
      case _: Int => "Int"
      case _: Double => "Double"
      case _: String => "String"
      case _ => "Unknown"
    }
    case _ => "Unknown"
  }

  for (s <- Seq(Seq(2.3,4,5,6.7), Seq("fruits","apple"))) {
    s match {
      case seq : Seq[_] => println(checkType(seq))
      case _ => println("Unknown")
    }
  }

  def checkType[T](t : T) = t match {
      case _: Int => "Int"
      case _: Double => "Double"
      case _: String => "String"
      case _ => "Unknown"
  }



}
