package com.programmingscala.examples.collections.useful.design.idioms

import scala.collection.mutable

object CanBuildFromTutorials extends App {


  //: Seq[(String, Seq[String])]

  val familyMember = Seq(("Pachari","Srinivas"),
    ("Pachari","Sachin"),
    ("Pachari","Shankar"),
    ("Pachari","Surendranath"),
    ("Ambani", "Mukesh"),
    ("Ambani", "Dhirubhai"),
    ("Ambani", "Anil")
  )

  def buildSeqFrom(keyValuePair : Seq[(String, String)]) : Seq[(String, Seq[String])] = {
    val result = new mutable.LinkedHashMap[String, List[String]]()

    for ((familyname, member) <- keyValuePair) {
      result += familyname -> (member :: result.getOrElse(familyname, Nil))
    }
    result.toList
  }


  println(buildSeqFrom(familyMember))

  //What if we want to get a return type of Seq[String, Array[String]]

  trait Functor [F[_]] {
    def map[A,B] (fn: A=>B)(fa: F[A]): F[B]
  }

  //A brief test aboutT[_]


}
