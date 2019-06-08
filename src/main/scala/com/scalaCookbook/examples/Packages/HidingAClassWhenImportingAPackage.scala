package com.scalaCookbook.examples.Packages

//Hiding the List package. We cannot create a list in this class

object HidingAClassWhenImportingAPackage extends App {



  //import scala.collection.immutable.{List, List => _, Map => _, Set => _}
  val b = List(1,2,3) //Need to figure out where it is creating it from
  println(b.getClass)

  //Because of this, this wont work
  //import java.util.{List => _, Random => _}
  //import scala.util.{Random => _}
  //val c = new Random()

}
