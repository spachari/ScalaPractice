package com.programmingscala.examples.patternmatching

object UsingWildCardsInPatternMatching extends App {

  //def apply[A](elems: A*): Seq[A]
  //def unapplySeq[A](x: Seq[A]): Some[Seq[A]]

  //unapplySeq i sused in this example
  val nonEmptyList   = List(1, 2, 3, 4, 5)
  val emptyList      = Nil
  val nonEmptyMap    = Map("one" -> 1, "two" -> 2, "three" -> 3)


  def windows1[T](seq : Seq[T]) : String = seq match {
    case Seq(head1, head2, _*) => s"(${head1},${head2})" + windows1(seq.tail) //It looks like we’re calling Seq.apply(…),
                                                                              // but in a match clause, we’re actually
                                                                              // calling Seq.unapplySeq. We grab the first two elements and ignore
                                                                              // the rest of the variable arguments with _*. Think of the * as matching zero to many, like in regular expressions.
    case Seq(head, last) => s"(${head},${last})"
    case Seq(head) => s"(${head})"
    case Nil => "Nil"
  }

  //Another way of writing this
  def windows[T](seq : Seq[T]) : String = seq match {
    case Seq(head1, head2, _*) => s"(${head1},${head2})" + windows(seq.tail)
    case Seq(head, _*) => s"(${head},${windows(seq.tail)})"
    case Nil => "Nil"
  }

  for (s <- Seq(nonEmptyList, emptyList, nonEmptyMap.toSeq))
    {
      println(windows(s))
    }

  for (s <- Seq(nonEmptyList, emptyList, nonEmptyMap.toSeq))
  {
    println(windows1(s))
  }

  def windows3[T](seq : Seq[T]) : String = seq match {
    case head1 :+ head2 :+ body => s"(${head1}, ${head2})" + windows3(seq.tail)
    case head :+ body => s"(${head})" + windows3(seq.tail)
    case Nil => "Nil"
  }

  for (s <- Seq(nonEmptyList, emptyList, nonEmptyMap.toSeq))
  {
    println(windows3(s))
  }

}
