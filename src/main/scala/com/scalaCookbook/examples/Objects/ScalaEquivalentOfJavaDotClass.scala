package com.scalaCookbook.examples.Objects

//When a API requires you to use a class in a variable, we can do like this

//Scala
//val info = new DataLine.Info(classOf[TargetDataLine], null)

//java
//info = new DataLine.Info(TargetDataLine.class, null)

object ScalaEquivalentOfJavaDotClass extends App {

  val a = List(new Fruits("Apple"),new Fruits("Banana"),new Fruits("Grape"), 1,2 )

  a.map(_.getClass).foreach(println)

  val b = a flatMap {
    case a : Fruits => Some(a)
    case _ => None
  }



  val stringclass = classOf[String]
  println(stringclass)
  println(stringclass.getMethods)

  //Printing only fruits
  println("Printing only fruits")
  b.foreach(println)

  echo

}
