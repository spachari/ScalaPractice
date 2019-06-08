package com.neophytes.guide

object OptionsInScala extends App {

  //Creating a simple Option
  val greeting : Option[String] = Some("Hello Srinivas")

  val greeting1 : Option[String] = None

  //We can also do the java way
  val greeting2 : Option[String] = Option("Srinivas")
  val greeting3 : Option[String] = Option("null")

  println(greeting)
  println(greeting1)
  println(greeting2)
  println(greeting3)

  //Using Options in our code

  case class User(
                   id: Int,
                   firstName: String,
                   lastName: String,
                   age: Int,
                   gender: Option[String])

  private val users = Map(1 -> User(1, "John", "Doe", 32, Some("male")),
    2 -> User(2, "Johanna", "Doe", 30, None),
    3 -> User(3, "Matt", "Smith", 34, Some("Male")))

  def findByID(x : Int) : Option[User] = users.get(x)
  def findAll(x : Map[Int, User]) = x.values

  //Providing a default value
  val user2 = findByID(2)
  val user1 = findByID(1)

  //get will always give you an option
  val user3 = user2.get.gender

  user2.get.gender match {
    case Some("male") => println("Gender is Male")
    case None => println("Gender is Unknown")
  }

  //Options can be viewed as a collection
  //So we can use foreach to do side effect functions

  println("Using foreach ...")
  user2.foreach(x => println(x.gender))

  println("Using map ...")
  val userAgeMap = findByID(1).map(_.age)
  println(userAgeMap)

  //Let's do the same for gender
  val userGenderMap = findByID(1).map(_.gender)
  println(userGenderMap)

  println("Using flatMap ...")
  val userGenderFlatMap = user2.flatMap(x => x.gender)
  println(userGenderFlatMap)

  val names: List[List[String]] =
    List(List("John", "Johanna", "Daniel"), List(), List("Doe", "Westheide"))

  println(names.map(x => x.map(x => x.toUpperCase)))

  println(names.flatMap( x=> x.map(x => x.toUpperCase)))

  //Filtering an option
  println(user2.filter(x => x.gender == Some("male")))
  println(user1.filter(x => x.gender == Some("male")))


  val genderForUser1 = for {
    x <- user1
    gend <- x.gender
  } yield gend

  println(genderForUser1)

  val genderForAll = for {
    x <- findAll(users)
    gend <- x.gender
  } yield gend

  println(genderForAll)

}
