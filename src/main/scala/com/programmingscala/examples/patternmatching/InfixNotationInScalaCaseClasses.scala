package com.programmingscala.examples.patternmatching

import com.programmingscala.examples.patternmatching.PatternMatchingOnSequences._

object InfixNotationInScalaCaseClasses extends App {

  val nonEmptySeq    = Seq(1, 2, 3, 4, 5)
  val emptySeq       = Seq.empty[Int]
  val nonEmptyList   = List(1, 2, 3, 4, 5)
  val emptyList      = Nil
  val nonEmptyVector = Vector(1, 2, 3, 4, 5)
  val emptyVector    = Vector.empty[Int]
  val nonEmptyMap    = Map("one" -> 1, "two" -> 2, "three" -> 3)
  val emptyMap       = Map.empty[String,Int]

  //We can write head +: tail another way also
  def seqToString3[T](seq : Seq[T]) : String = seq match {
    case +: (head, tail) => s"${head} +: ${seqToString3(tail)}"
    case _ => "Nil"
  }

  println("")
  for {seq <- Seq(nonEmptySeq, emptySeq, nonEmptyList,
    emptyList, nonEmptyVector, emptyVector,
    nonEmptyMap.toSeq, emptyMap.toSeq)}
  {
    println(seqToString3(seq))
  }

  //Infix in simple case classes

  case class With[A, B](a : A, b : B)

  val with1:With[String, Int] = With("Foo", 1)

  val with2:String With Int = With("Bar", 2)

  Seq(with1, with2) foreach { x =>
    x match {
      case str With int => println(s"Found string ${str} and int ${int}")
      case _ => println("FOund something else ... ")
    }
  }

  //We can write the signature of With in two ways //With[String, Int] and String With Int

  //But this will nto work

  //val s = "Foo" With 1

}
