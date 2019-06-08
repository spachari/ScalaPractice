package com.scalatests.examples.sharing.tests

import scala.collection.mutable.ListBuffer

class Stack[T] {

  val MAX = 10
  private val buf = new ListBuffer[T]

  def push(x : T) = {
    if (!isFull) {
      buf.prepend(x)
    } else {
      throw new IllegalStateException(s"Cannot insert more than ${MAX} items")
    }
  }

  def pop() = {
    if (!isEmpty()) {
      buf.remove(0)
    } else {
      throw new IllegalStateException(s"Cannot pop an empty Stack")
    }
  }

  def peek : T = {
  if (!isEmpty) {
    buf(0)
  } else {
    throw new IllegalStateException(s"Cannot pop an empty Stack")
  }
  }

  def isEmpty() = if (buf.length == 0) true else false
  def isFull() = if (buf.toList.length == MAX) true else false

  override def toString: String = buf.mkString("Stack(",",",")")
}

object Test extends App {
  val familyStack = new Stack[String]()

  familyStack.push("Srinivas")
  familyStack.push("Kirthika")
  familyStack.push("Sadhiv")
  familyStack.push("Sadhana")

  println(familyStack)

  println(familyStack.pop())
  println(familyStack.pop())
  println(familyStack.pop())
  println(familyStack.pop())

}
