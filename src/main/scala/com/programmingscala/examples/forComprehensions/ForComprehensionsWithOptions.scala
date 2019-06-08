package com.programmingscala.examples.forComprehensions

object ForComprehensionsWithOptions extends App {

  //any types that implement foreach, map, flatMap, and withFilter can be used
  // in for comprehensions.

  //In other words, any type that can be considered a container could support these methods
  // and allow us to use instances of the type in for comprehensions.

  //Option is a container returning binary output, either yes or no

  val optList = List(Some(10), None, Some(20))

  val output = for {
    Some(l) <- optList
    o = l * 10
  } yield o

  println(output)

  //Let's convert the for comprehension to basic rules

  val output1 = for {
    Some(ls) <- optList withFilter {
      case Some(i) => true
      case None => false
    }
  }
    yield ls * 10

  println(output1)
  //Next we will convert the yield and remove for

  val output2 = optList withFilter {
      case Some(i) => true
      case None => false
    } map {
      case Some(i) => i * 10
    }

  println(output2)


  //Normally we will get an MatchError error when the map get's a None. But in this case, it's ok
  //because the parital function removes the None

  //2. When multiple generators in for comprehension is used, if we get a None in any of the values
  // (let's say we have to get multiple outputs from various nodes and compute output ), when a Some() is expected, the for
  //will not fail, instead it will result in None

  def isPositive(x : Int) = if (x > 0) Some(x) else None

  //In a normal path there will be no issues

  val outputInNormalPath = for {
    i <- isPositive(5)
    j <- isPositive(i * 10)
    k <- isPositive(j * 2)
    l <- isPositive(k * 20)
  } yield i * j * k * l

  println(outputInNormalPath)

  //In an abnormal path we will just get None, we do not need to check everytime the value we get is not None

  val outputInNotNormalPath = for {
    i <- isPositive(5)
    j <- isPositive(i * -6)
    k <- isPositive(j * 10)
    l <- isPositive(k * 2)
  } yield i * j * k * l

  println(outputInNotNormalPath)

}
