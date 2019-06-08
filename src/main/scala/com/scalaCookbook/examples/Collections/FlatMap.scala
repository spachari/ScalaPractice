package com.scalaCookbook.examples.Collections

object FlatMap extends App {
  //FlatMap is nothing but map + flatten
  val bag = List(1 ,2, 3, "String", "my String")

  //This is using for/yield and flatten
  val output = for (c <- bag) yield
    {
      val output = try {
        Some(c.asInstanceOf[Int])
      }
      catch {
        case e : Exception => None
      }
      //println(output)
      output
    }

  val intSum = output.flatten.foldLeft(0)((x,acc) => x + acc)
  println(intSum)

  val stringList = List("1","2","3", "string", "is", "this")

  def toInt (x : String) = {
    try{
      Some(Integer.parseInt(x))
    }
    catch {
      case e : Exception => None
    }
  }

  val output1 = stringList.flatMap(toInt).sum

  println(output1)

}
