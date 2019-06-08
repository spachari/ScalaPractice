package com.programmingscala.examples.types.contextBound.and.viewBound.example

case class MyList[A](list : List[A]) {
  def sortBy1[B : Ordering](f : A => B) : List[A] = {
    list.sortBy(f)(implicitly [Ordering[B]])
  }

  def sortBy2[B](f : A => B)(implicit ord : Ordering[B]) : List[A]= {
    list.sortBy(f)
  }
}

object ContextBoundsExample extends App {

  val myList = MyList(List(13,1,2,3,5))

  val outputList1 = myList.sortBy1(i => -i)
  val outputList2 = myList.sortBy1(i => -i)

  println(outputList1)
  println(outputList2)

}
