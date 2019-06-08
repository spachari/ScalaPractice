package com.scala.FPS

object FlatMapAdvancedExamples extends App {

  val outputOption = for {
    i <- Option(3)
    j <- Option(4)
  } yield i * j

  println(outputOption)

  val flatMapOutputOption = Option(3) flatMap { x =>
                                    Option(4) map(y =>
                                         x * y
                                      )
  }

  println(flatMapOutputOption)

  val outputList = for {
    i <- List(1,2,3)
    j <- List(1,2,3)
    if (i != j)
  } yield i.toString + j.toString

  println("Output list with for comprehension " + outputList)

  val outputListWithFlatMap = List(1,2,3) flatMap( x =>
                                        List(1,2,3) flatMap(y =>
                                                  if (x != y) Some(x.toString + y.toString) else None))

  println("Output list with flatmap " + outputListWithFlatMap)

  val map = Map(1 -> "Srinivas", 2 -> "Shankar", 3 -> "Sachin")



  println(map.get(1))

  val mapValues = 1 to map.size map(map.get(_))
  mapValues.foreach(println)

  val mapValuesFlatMap = 1 to map.size flatMap(map.get(_))
  mapValuesFlatMap.foreach(println)

  //Following FPS book
  def makeInt(s : String) = {
    try{
      Some(s.trim.toInt)
    }
    catch {
      case e : Exception => None
    }
  }

  val aValue = makeInt("1")
  val bValue = makeInt("2")

  //This wont compile a + b because the output's are options
  //SO we can do one of these things
 val outputs =  aValue match {
    case Some(x) => {
      bValue match {
        case None => 0
        case Some(i) => i + x
      }
    }
    case None => {
      bValue match {
        case None => 0
        case Some(i) => i
      }
    }
  }

  println("Option 1 " + outputs)

  val outputs2 = aValue.getOrElse(0) + bValue.getOrElse(0)

  println("Option 2 " + outputs2)

  //We can do the below because Options come with map and flatMap implemented
  val outputs3 = aValue map { x => bValue map {y => x + y}}

  println("Option 3 " + outputs3)


  val output4 = aValue flatMap { x => bValue map {y => x + y }}

  println("Option 4 " + output4)

  val output5 = for{
    i <- aValue
    j <- bValue
  } yield i * j

  println("Option 5 " + output5)

  val output6 = for {
    i <- makeInt("1")
    j <- makeInt("2")
    k <- makeInt("3")
    l <- makeInt("4")
    m <- makeInt("5")
  } yield i * j * k * l * m

  println("Option 6 " + output6)

  //Why have a for comprehension instead of getOrElse, on a happy path getORElse works fine
  def methodsOnFourStrings(a : Option[Int],
                           b : Option[Int],
                           c : Option[Int],
                           d : Option[Int])(f : (Option[Int],Option[Int],Option[Int],Option[Int]) => Option[Int]) = {
    f(a,b,c,d)
  }

  val output7 = methodsOnFourStrings(makeInt("1"), makeInt("2"),makeInt("3"), makeInt("4"))((a : Option[Int],b : Option[Int],c : Option[Int],d : Option[Int]) => for {
                                      i <- a
                                      j <- b
                                      k <- c
                                      l <- d
                                    } yield i + j + k + l)

  println("Output 7 " + output7)

  val output8 = methodsOnFourStrings(makeInt("1"), makeInt("2"),makeInt("3"), makeInt("4"))((a : Option[Int],b : Option[Int],c : Option[Int],d : Option[Int]) =>
  Some(a.getOrElse(0) + b.getOrElse(0) + c.getOrElse(0) + d.getOrElse(0)))

  println("Output 8 " + output8)

  //But on an unhappy path, there are differences
  val output9 = methodsOnFourStrings(makeInt("ka-boom"), makeInt("2"),makeInt("3"), makeInt("4"))((a : Option[Int],b : Option[Int],c : Option[Int],d : Option[Int]) => for {
    i <- a
    j <- b
    k <- c
    l <- d
  } yield i + j + k + l)

  println("Output 9 " + output9)

  val output10 = methodsOnFourStrings(makeInt("ka-boom"), makeInt("2"),makeInt("3"), makeInt("4"))((a : Option[Int],b : Option[Int],c : Option[Int],d : Option[Int]) =>
    Some(a.getOrElse(0) + b.getOrElse(0) + c.getOrElse(0) + d.getOrElse(0)))

  println("Output 10 " + output10)


  //The above can be written (painfully as)
  val output11 = makeInt("1") flatMap { x =>
    makeInt("2") flatMap { y =>
      makeInt("3") flatMap { z =>
        makeInt("4") map { a =>
          x * y * z * a
        }
      }
    }
  }

  //Understand that val length = "Srinivas".map{x => x.length}
}
