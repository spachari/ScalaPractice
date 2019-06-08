package com.programmingscala.examples.implicits

//Sometimes implicits can be used to constrain the allowed types and not provide additional processing capability
//Put another way, we need “evidence” that the proposed types satisfy our requirements.

case class Id(i : Int)

case class Name(i : String)

case class Address(street : String, city : String)

case class NameIdCombo(id : Id, name : Name) {
  def myMap[A](a : A)(implicit ev : <:<[A,(Id,Name)]) = {
    NameIdCombo(id,name)
  }
}


object ImplicitAsEvidenceInScala extends App {

  val i = Id(10)
  val j = Name("Srinivas")

  val k = NameIdCombo(i,j)

  val l = k.myMap(i,j)

  println(l)

  //With implicit evidence, we didn’t use the implicit object in the computation.
  // Rather, we only used its existence as confirmation that certain type constraints were satisfied.
}
