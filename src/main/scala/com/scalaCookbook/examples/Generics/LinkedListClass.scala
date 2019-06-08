package com.scalaCookbook.examples.Generics

class LinkedListClass[A] {

  private class Node[A] (elem : A) {
    var next : Node[A] = _

    override def toString: String = elem.toString
  }

  private var head : Node[A] = _

  def add (elem : A) = {
    val n = new Node(elem)
    n.next = head
    println("============Start================")
    println(s"${n.next}")
    head = n
    println(s"${head}")
    println("============Complete================")
  }

  var counter = 0
  private def printNodes(n : Node[A]): Unit = {
    if (n != null) {
      counter += 1
      println(n + " " + counter)
      printNodes(n.next)
    }
  }

  def printAll(): Unit = {
    printNodes(head)
  }

}

object Test extends App {

  val n = new LinkedListClass[String]

  n.add("Srinivas")
  n.add("Pachari")
  n.add("Surendranath")

  n.printAll()

  trait Animal
  class Dog extends Animal { override def toString: String = "Dog" }
  class SuperDog extends Animal { override def toString: String = "SuperDog" }
  class FunnyDog extends Animal { override def toString: String = "FunnyDog" }

  val dogs = new LinkedListClass[Dog]
  val fido = new Dog
  val scooby = new Dog
  val snowy = new Dog

  dogs.add(fido)
  dogs.add(scooby)
  dogs.add(snowy)

  dogs.printAll()

}
