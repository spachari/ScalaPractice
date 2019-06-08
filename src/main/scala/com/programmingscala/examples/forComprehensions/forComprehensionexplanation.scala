package com.programmingscala.examples.forComprehensions

object forComprehensionexplanation extends App {

  val list = List("Apple","Banana","Carrot","Donkey")

  //basic for loop is syntactic sugar for foreach
  for(l <- list) println(l)

  //same as

  list.foreach(println)

  //basic yield is syntactic sugar for map

  val line = for (l <- list) yield l.toUpperCase

  //OR

  val line2 = for {
    l <- list
    v = l.toUpperCase
  } yield v
  //this creates a container of whatever container you have given, like map

  val line1 = line.map(x => x.toUpperCase)


  //more than one generator

  val line3 = for {
    fruits <- list
    s <- fruits
  } yield s"$s-${s.toUpper}"


  //this is equal to flatmap


  //When there are multiple generators, all but the last are converted to flatMap invocations. The last is a map invocation.
  val line4 = list.flatMap(x => x.toSeq map(x => s"$x-${x.toUpper}"))

  println(line3)

  println(line4)

  val line5 = list.flatMap(x => x.toSeq)

  println(line5)

  //Guards in for comprehension

  val line6 = for {
    fruits <- list
    s <- fruits
    if s.toUpper == 'A'
  } yield s

  println(line6)

  //this is equal to flatMap and withFilter

  val line7 = list.flatMap(x => x.toSeq withFilter(x => x.toUpper == 'A') map(x => x))

  println(line7)

  //All of them put together with our own alphabet function
  val line8 = for {
    fruits <- list
    s <- fruits
    if s.isLower
    f = s"${s}-${s.toUpper}"
  } yield f

  println(line8)

  val line9 = list.flatMap(x => x.toSeq withFilter (_.isLower) map(x => x))

  println(line9)

  val vowels = List('a','e','i','o','u')

  def isConsonant(s : Char) : Boolean = if (vowels.contains(s.toLower)) false else true

  val line10 = for {
    fruits <- list
    s <- fruits
    if isConsonant(s) == true
    f = s"${s}-${s.toUpper}"
  } yield f

  println(line10)

  //Same thing in normal format
  val line11 = list.flatMap(x => x.toSeq withFilter(x => isConsonant(x)) map(x => s"${x}-${x.toUpper}"))

  println(line11)

  //How a for comprehension is interpreted
  //1. this line
  // pat <- expr
  // is converted to
  // pat => expr.withFilter { case pat => true; case _ => false}

  //2. The subsequent yield is converted into a map
  //For example for(pat <- expr1) yield pat
  //is converted to
  //expr map(x => x)

  //3. Without yield it will be a side effect statement
  //for(pat <- expr1) println(pat)
  //is converted to
  //expr foreach(println)

  //4. A pattern followied by yield is converted to pattern followed by withFilter
  //pat <- expr1 if guard
  //is converted to
  //pat <- expr1 withFilter ((arg1,arg2,arg3 ... ) => guard)
  //arg1,arg2,arg3 are the arguments passed to the withFilter

  //5. A generator followed by a statement is a little bit complex.

  //Note : We need to understand the @ pattern
  val z @ (x,y) = (1,2)

  println(z, x, y)


  //Eventhough it only generates a value, the explanation goes like this
  val line12 = for { f <- list
                     s = f} yield s

  println(line12)

  //pat <- expr1 expr2 = pat
  //is converted to
  //(x1, x2) <- for {
  // val x1 @ pat1 <- expr } yield for {
  //             val x2 @ pat2 = expr
  //             (x1, x2)



  //Let's look at a solid example
  val map = Map("one" -> 1, "two" -> 2)

  val line13 = for {
    z @ (key,value) <- map
    newValue = value + 10
  } yield newValue

  println(line13)

  //Translation is

  val line14 = for {
    (i, newValue) <- for {
      x1@(key, value) <- map
    } yield {
      val x2@newValue = value + 10
     (x1, x2)
    }
  } yield (newValue)

  println(line14)


}
