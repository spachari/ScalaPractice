package com.scala.FPS

import scala.annotation.tailrec

case class Sequence[A](initialElems : A*) {

  private val elems = scala.collection.mutable.ArrayBuffer[A]()

  elems ++= initialElems  //In scala, when a constructor is created, all the lines of code that are not in a method will be executed
  println("Collection created")
  println(elems)


  def foreach(f : A => Unit) : Unit = {
    elems.foreach(f)
  }

  def getOneValue(f : A => Unit) = {
    val heads = elems.toList.head
    f(heads)
  }


  def myForEachPM(f: A => Unit) {
    @tailrec
    def myForEach1(f: A => Unit, elem: List[A]) : Unit = {
      val elemList = elem.toList
      elemList match {
        case Nil => Unit
        case x :: xs => {
          f(elemList.head)
          myForEach1(f, elemList.tail)
        }
      }
    }
    myForEach1(f: A => Unit, elems.toList)
  }


  def myForEach(f : A => Unit) : Unit = {

    @tailrec
    def myForEach1(f: A => Unit, elem: List[A]) : Unit = {
      val elemList = elem.toList
      if (!elemList.isEmpty) {
        f(elemList.head)
        myForEach1(f, elemList.tail)
      }
      else {
        Unit
      }
    }
    myForEach1(f: A => Unit, elems.toList)
  }

  def map[B](f : A => B) : Sequence[B] = {
    val outputs = elems.map(f)
    new Sequence(outputs : _*) //This basically converts the ArrayBuffer[B] to normal varargs
  }

  /*
  def myMap[B](f : A => B) : Sequence[Int] = {
    //val outputs = elems.map(f)
    val elemsList = elems.toList
    def myMap1(f : A => B, elemsList : List[A]) : B = {
      if (!elemsList.isEmpty) {
        f(elemsList.head)
        myMap1(f,elemsList.tail)
      }
      else
        {
          Nil
        }

    }
    val outputs = myMap1(f,elems.toList)

    new Sequence(outputs : _*) //This basically converts the ArrayBuffer[B] to normal varargs
  }
  */

  def withFilter(p : A => Boolean) : Sequence[A] = {
    val output = elems.filter(p)
    new Sequence[A](output : _*)
  }

  private def flattenLike[B](seq : Sequence[Sequence[B]]) : Sequence[B] = {
    var array = scala.collection.mutable.ArrayBuffer[B]()
    val output = for (lists <- seq) {
      for (i <- lists){
        array += i
      }
    }
    new Sequence[B](array : _ *)
  }


  def flatMap[B](f : A => Sequence[B]) : Sequence[B] = {
    val output : Sequence[Sequence[B]] = map(f)
    flattenLike(output)
  }

}


object Test extends App {

  val ints = Sequence(1,2,3,4,5,6)

  val strings = Sequence("a","b","c")

  //for (i <- strings) println(i)

  ints.getOneValue(println)

  ints.myForEach(println)

  ints.myForEachPM(println)

  val doubles = for (i <- ints) yield i * 2

  ints.myForEachPM(println)

  val evens = for (
    i <- ints
    if (i % 2 == 0)
  ) yield i * 2

evens.foreach(println)

  val myFamily = Sequence(Name("Vangipurappu","VenkataSai","Laxman"),
                           Name("Sachin","Rohan","Tendulkar"),
    Name("Shankar","Surendranath","Pachari"))

  val myFriends = Sequence(Name("Shane","Keith","Warne"),
                           Name("Steve","Roger","Waugh"),
                           Name("Vishnu","Ravindranath","Pachari"))

  val myFriendsAndFamily = for {myFam <- myFamily
                                myFri <- myFriends
                                if (myFam.lastName == myFri.lastName)
  } yield myFri

  println("output")
  myFriendsAndFamily.foreach(println)

  case class Person(name : String)

  val srinivasFriends = Sequence(Person("Srinivas"),Person("Adam"),Person("Sid"))

  val kirthikaFriends = Sequence(Person("Wong"),Person("Smitha"),Person("Sid"))

  val ourFriends = for {m <- srinivasFriends
                        n <- kirthikaFriends
                        if (m.name == n.name)} yield m

}