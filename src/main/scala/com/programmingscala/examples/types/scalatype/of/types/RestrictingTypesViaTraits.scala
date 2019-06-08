package com.programmingscala.examples.types.scalatype.of.types


trait SimpleContainer {
  type A //THis is syntactical sugar for A >: Nothing <: Any

  def value : A
}

trait NumberContainer {
  type A >: Int <: AnyVal

  //val value : A
}

trait StringContainer {
  type A <: String
}


object RestrictingTypesViaTraits extends App {

val test = new SimpleContainer with NumberContainer {

  type A = Int
  def value = 100
}

  println(test.value)

  val stringTest = new SimpleContainer with StringContainer {
    type A = String
    def value = "Srinivas"
  }

  println(stringTest.value)

}
