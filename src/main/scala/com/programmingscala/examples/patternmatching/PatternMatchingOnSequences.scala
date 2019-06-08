package com.programmingscala.examples.patternmatching

object PatternMatchingOnSequences extends App {

  val nonEmptySeq    = Seq(1, 2, 3, 4, 5)
  val emptySeq       = Seq.empty[Int]
  val nonEmptyList   = List(1, 2, 3, 4, 5)
  val emptyList      = Nil
  val nonEmptyVector = Vector(1, 2, 3, 4, 5)
  val emptyVector    = Vector.empty[Int]
  val nonEmptyMap    = Map("one" -> 1, "two" -> 2, "three" -> 3)
  val emptyMap       = Map.empty[String,Int]

  def seqToString[T](seq : Seq[T]): String = seq match {
    case head +: tail => s"${head} :+ " + seqToString(tail)
    case Nil => "Nil"
  }

  for {seq <- Seq(nonEmptySeq, emptySeq, nonEmptyList,
    emptyList, nonEmptyVector, emptyVector,
    nonEmptyMap.toSeq, emptyMap.toSeq)}
  {
    println(seqToString(seq))
  }

  def seqToString2[T](seq : Seq[T]): String = seq match {
    case head +: tail => s"($head :+ ${seqToString2(tail)})"
    case Nil => "(Nil)"
  }

  //Remember
  //1 :+ Seq(1,2,3)
  //Seq(1,2,3) :+ 4

  println("")
  for {seq <- Seq(nonEmptySeq, emptySeq, nonEmptyList,
    emptyList, nonEmptyVector, emptyVector,
    nonEmptyMap.toSeq, emptyMap.toSeq)}
  {
    println(seqToString2(seq))
  }

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

}
