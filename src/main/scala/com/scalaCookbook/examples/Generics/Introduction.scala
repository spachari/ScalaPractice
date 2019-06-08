package com.scalaCookbook.examples.Generics


class GrandParent
class Parent extends GrandParent
class Child extends Parent

class InvariantClass[A]
class CovariantClass[+A]
class ContravarantClass[-A]



object Introduction extends App {

  //Arrays are Invariant. We can only pass an Array[Int] when an Array[Int is required]
  //Uses Used when elements in the container are mutable.
  def printArray(array : Array[Number]) = {
    val array1 = array.map(x => x.intValue())
    array1
  }

  //For example this wont work
  //printArray(Array[Int](1,2,3))
  printArray(Array[Number](1,2,3)) //This will work

  //Seq are co-variant. We can call this function with String
  //Uses Used when elements in the container are immutable. This makes the container more flexible.
  def printSeq(seq : Seq[Any]) = {
    seq.foreach(println)
  }

  printSeq(Seq[String]("Srinivas","Pachari","Surendranath"))

  //Let's see an example

  /*
  class GrandParent
  class Parent extends GrandParent
  class Child extends Parent

  class InvariantClass[A]
  class CovariantClass[+A]
  class ContravarantClass[-A]
   */

  def invariantMethod(a : InvariantClass[Parent]) = {
    println(a)
  }

  def covariantMethod(a : CovariantClass[Parent]) = {
    println(a)
  }

  def contravariantMethod(a : ContravarantClass[Parent]) = {
    println(a)
  }

  val p = new Parent
  val g = new GrandParent
  val c = new Child

  //Invariance
  invariantMethod(new InvariantClass[Parent])
  //These two will not work
  //invariantMethod(new InvariantClass[GrandParent])
  //invariantMethod(new ContravarantClass[Child])


  covariantMethod(new CovariantClass[Child])
  covariantMethod(new CovariantClass[Parent])
  //Wont work
  //covariantMethod(new CovariantClass[GrandParent])

  contravariantMethod(new ContravarantClass[Parent])
  contravariantMethod(new ContravarantClass[GrandParent])

  //Wont work
  //contravariantMethod(new ContravarantClass[Child])


}
