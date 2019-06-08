package com.mylearning.lists

class ListFunctions {
  def listnormal (l : List[Int]) : List[Int] = {
    l match {
      case List() => List()
      case x :: rest => println(x , rest)
        x + 1 :: listnormal(rest)
    }
  }

  def listtailRec (l : List[Int]) : List[Int] = {
    import scala.annotation.tailrec
    @tailrec
    def listadd(l : List[Int], accum : List[Int] ): List[Int] = {
      l match {
        case x :: Nil => x + 1 :: accum
        case x :: rest => listadd(rest, x + 1 :: accum)
      }
    }
    listadd(l, List()).reverse
  }

  def thisExample (list : List[Int]) : Unit = {
    var these = this
    for (i <- list) {
      println(i)
    }
  }
}


//private
class Animal {
  private[this] def name : Boolean = true

  def printName(other : Animal) =
    {
      //if (other.name)            //this will not work
      //  {
      //    println(other)
      //  }
      println(name)
    }

}



object ListChapterAnalysis extends App {
val l = List(1,2,3,4,5)
  val o = new ListFunctions()
  //print(o.listnormal(l))

  print(o.listtailRec(l))

  print(o.thisExample(l))
}
