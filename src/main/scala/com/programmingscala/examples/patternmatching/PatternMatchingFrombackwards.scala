package com.programmingscala.examples.patternmatching

object PatternMatchingFrombackwards extends App {

  val nonEmptyList   = List(1, 2, 3, 4, 5)
  val nonEmptyVector = Vector(1, 2, 3, 4, 5)
  val nonEmptyMap    = Map("one" -> 1, "two" -> 2, "three" -> 3)

  def reverseSeqToString[T](seq : Seq[T]) : String = seq match {
    case everythingButLast :+ end => s"${reverseSeqToString(everythingButLast)} :+ ${end}"
    case Nil => "Nil"
  }

  for (s <- Seq(nonEmptyList, nonEmptyVector, nonEmptyMap.toSeq))
    {
      println(reverseSeqToString(s))
    }

}
