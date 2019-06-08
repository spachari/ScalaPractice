package com.scalaCookbook.examples

object RegexFinder extends App {

  //Normal way of finding the first match in string
    val string = "101 is in 123"
    val numPattern = "[0-9]+".r
  val numPatternLast = "[0-9]+".r
  println(numPattern.findFirstIn(string))

  //Normal way of finding all matches in string
  numPattern.findAllIn(string).foreach(println)

  //replaceAll usage
  val replacedString = string.replaceAll("[0-9]","x")
  println(replacedString)
  println("101 is in 123".replaceAll("[0-9]","x"))

  //anotherway of doing the same thing by creating
  // a regular expression and then call replaceAllIn on that expression, again remembering to assign the result to a new string:
  val replacedString2 = numPattern.replaceAllIn(string,"x")
  println(replacedString2)

  println("Hello World".replaceFirst("H+","J"))


  val pattern = "([0-9]+) ([A-Za-z]+) ([A-Za-z]+) ([A-Za-z]+)".r
  //same thing can be done the other way also
  val pattern(output1,output4,output2,output3) = "101 is not a"
  println(output1,output4,output2,output3)

  val array = Array(
    "movies near 80301",
    "movies 80301",
    "80301 movies",
    "movie: 80301",
    "movies: 80301",
    "movies near boulder, co",
    "movies near boulder, colorado")


  val moviesZipRe = "movies (\\d{5})".r

  val moviesNearCityStateZE = "movies near ([a-z]+), ([a-z]{2})".r

  val moviesZipRe(zip) = "movies 80301"
  println("find " + numPatternLast.findFirstIn("movies 80301"))

  val moviesNearCityStateZE(city, state) = "movies near boulder, co"
  println(city, state)

  def getPostCodeFromString (s : String) = numPattern.findFirstIn(s)

  def getPostCode (s :String) = s match {
    case moviesZipRe(zip) => getPostCodeFromString(s)
    case moviesNearCityStateZE(city, state) => (city,state)
    case _ =>
  }

  println("This is array in the case statement")
  val arrayoutput = array.map(c => getPostCode(c)).toList
  arrayoutput.filter(c => c != ())

  for(c <- array)
    yield
      getPostCode(c)

  val output = array.map(c => numPattern.findFirstIn(c)).map(_.getOrElse("Null")).filter(_ != "Null")

  output.foreach(println)

}
