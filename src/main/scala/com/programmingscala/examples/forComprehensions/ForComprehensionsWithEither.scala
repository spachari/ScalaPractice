package com.programmingscala.examples.forComprehensions

object ForComprehensionsWithEither extends App {

  //One disadvantage of Option is that we get a value of a type or we get None.
  //Problem is we do not know why a failure occured. In this case we can use Either

  //It's syntax is Either[+A,+B]

  //This means it's co-variant. that means if we create out class as type Either[Any,Any],
  //it can take Either[Int, String] because Int and String are subtypes of Any

  //Historically Either has been used to get output value in the Right side and error messages in the left side
  //But we can use Either to store any two types

    //Let's re-write the for loop containing multiple generators using Either

  def isPositive(x : Int) = if (x > 0) Right(x) else Left(s"nonpositive number ${x}")

  val output = for {
    x <- isPositive(5).right
    y <- isPositive(x * 10).right
    z <- isPositive(y * 10).right
  } yield x + y + z

  println(output)

  //In a not so positive case

  val output1 = for {
    x <- isPositive(5).right
    y <- isPositive(x * -6).right //Note: the output is Left(nonpositive number -30). That means after this point, no computations will happen
    z <- isPositive(y * -10).right
  } yield x + y + z

  println(output1)

  //Note that we have to call the right method to see the values returned from isPositive

  //Create simple Either class
  val l : Either[String, Int] = Left("Srinivas")

  val r : Either[String, Int] = Right(20)

  println(l)
  println(r)

  //We can use infix way of mentioning Either too
  val l3 : String Either Int = Left("Better?")

  //Let's do some Type stuff
  type Or[A,B] = Either[String,Int]

  //Now this is very very clear
  val l4 : String Or Int = Left("How is this?")

  //Next the combinators (map, fold etc) are not used in Either, they are in Either.Left or Either.Right
  //That is the reason we have to use left or right

  println(l.left)
  println(l.right)

  println(r.right)
  println(r.left)

  //Note that we can call right and left on either of them

  //val l : Either[String, Int] = Left("Srinivas")

  //val r : Either[String, Int] = Right(20)

  //Let's not try using map on them
  println(l.left.map(_ * 20))
  println(l.left.map(x => "Hello " + x))


  //Right on LeftProjection will just pass on the value and do nothing
  println(l.right.map(_ * 20))
  println(l.right.map(x => "Hello " + x))


  //When you call LeftProjection.map and it holds a Left instance, it calls the function on the value held by the Left,
  // analogous to how Option.map works with a Some. However, if you call LeftProjection.map and it holds a Right, it passes
  // the Right instance through without modification, analogous to how Option.map works with None.

  //THe same is for types
  println(l.left.map(_.size).getClass) //THis will conver the Either[String, Int] and result in Either[Int,Int]
  println(l.right.map(_ * 20).getClass)
  println(r.right.map(_ * 2.0)) //THis will convert the Either[String, Int] to Either[String, Double]

  //Finally we can use for comprehensions on the as well
  val forCompOnLeft = for (s <- l.left) yield s.size

  println(forCompOnLeft)

}
