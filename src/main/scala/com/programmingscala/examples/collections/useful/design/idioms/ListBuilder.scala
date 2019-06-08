package com.programmingscala.examples.collections.useful.design.idioms

import scala.collection.mutable

class ListBuilder[T] extends mutable.Builder[T, List[T]] {

  //mutable collections are an appropriate compromise for performance when used carefully.
  private var storage = Vector.empty[T]

  //collection.mutable.Builder trait are used internally to construct new instances during
  // operations like map. It is used by CanBuilfFrom in Map
  override def +=(elem: T): ListBuilder.this.type //One way to get the return type as this object
  = { //The unusual Builder.this.type signature is a singleton type. It ensures that the += method can only return the Builder
    // instance it was called on, i.e., this.
    storage = storage :+ elem
    this //One way to get the same type
  }

  override def clear(): Unit = {
    storage = Vector.empty[T]
  }

  override def result(): List[T] = storage.toList
}

object ListBuilderTest extends App {
  val stringListBuilder = new ListBuilder[String]()

  stringListBuilder.+=("Srinivas")
  stringListBuilder.+=("Kirthika")

  println(stringListBuilder.result())

  println(stringListBuilder.clear())
}
