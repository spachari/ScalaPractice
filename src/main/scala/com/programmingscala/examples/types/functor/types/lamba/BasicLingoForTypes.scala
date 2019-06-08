package com.programmingscala.examples.types.functor.types.lamba

class Container[F[_]](a : F[_]) {
  def getItems() = {
    println(a)
  }
}

object BasicLingoForTypes extends App {

  val list : List[Int] = List(1,2,3,4)
  //in List[Int],
  // List - type constructor
  // Int - type parameter to the type constructor and make it a
  // List[Int] - parameterized type

  //type parameter can be another type constructor
  val listOfOptions : List[(Option[(String, Int)])] = Nil
  //List - type constructor
  //Option[(String, Int)] - type parameter, which is a type constructor taking (String, Int)
  //List[(Option[(String, Int)])] - paramterized type

  //When we declare a type variable that is a type constructor, we write F[_] indicating that F needs to be provided with a
  //type constructor to make it a parameterized type.
  def getContainer[F[_]](container : F[_]) = {
    println(container)
  }

  val seq = List(1,2,3,4)
  getContainer(seq)
  getContainer(Some(10))


}
