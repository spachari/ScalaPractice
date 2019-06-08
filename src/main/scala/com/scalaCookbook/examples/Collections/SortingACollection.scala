package com.scalaCookbook.examples.Collections


case class Persons1(firstName : String, lastName : String) extends Ordered[Persons1] {

  override def toString: String = s"${firstName} ${lastName}"

  //Sorting a person via firstName and lastName
  override def compare(that: Persons1) = {
    if (this.firstName == that.firstName)
    {
      if (this.lastName == that.lastName)
        {
          0
        }
      else if (this.lastName > that.lastName)
        {
          1
        }
      else {
        -1
      }
    }
    else if (this.firstName > that.firstName)
      {
        1
      }
    else
      -1
  }
}

object SortingACollection extends App {
  //Sorting a basic List with basic data types such as Int, Double and String can be done via sorted method in ascending order
  //Sorted can be used on any other type that has an implicit scala.math.Ordering

  println("Sorting an integer ... ")
  val ints = List(1,4,1,2,9,5,6,7)
  print(ints.sorted)
  println()

  val doubles = List(1.0,2.0, 10.0, 5.9, 6.2)
  print(doubles.sorted)
  println()

  val strings = List("apple", "pear", "strawberry", "avacado", "grape", "banana", "blueberry")
  println(strings.sorted)
  println()

  //SortWith is used to add small functions when we need to sort a collection. We can do sort both ways
  println("Using sortWith method")
  print(ints.sortWith(_ > _))
  println()

  print(ints.sortWith(_ < _))
  println()

  //Using two conditions
  val sortWithLength = strings.sortWith(_.length > _.length).sortWith(_.charAt(0) > _.charAt(0))
  for (x <- sortWithLength)
    {
      print(x + " | ")
    }

  println()


  val sortWithFirstLetter = strings.sortWith(_.charAt(0) > _.charAt(0))
  for (x <- sortWithFirstLetter)
    {
      print(x + " | ")
    }
  println()

  //Using a simple functionbased on first character and second character ans so on
  def sortFruitsOnAscendingOrder(s1 : String, s2 : String) = {
    val s = s1.length > s2.length && s1.charAt(0) > s2.charAt(0)
    println(s"Comparing two ${s1} and ${s2} , the value is ${s} ")
    if (s1.charAt(0) == s2.charAt(0))
      s1.charAt(1) > s2.charAt(1)
    else
      s1.charAt(0) > s2.charAt(0)
  }

  val sorted = strings.sortWith(sortFruitsOnAscendingOrder)
  for (elem <- sorted) {
    print(elem + " | ")
  }
  println()

  val srini = new Persons1("Srinivas", "Pachari")
  val kirthi = new Persons1("Kirthika", "Jeyaraman")
  val sachin = new Persons1("Sachin", "Pachari")
  val shankar = new Persons1("Shankar", "Pachari")
  val sachinGoonda = new Persons1("Sachin", "Goonda")
  val sachinAgora = new Persons1("Sachin", "Agora")

  val family = List(srini, kirthi, sachin, shankar, sachinGoonda, sachinAgora)

  //SortBy is used to sort a list of Tuples
  val sortedByfirstName =  family.sortBy(_.firstName)

  println("Sorting an element by firstName ... ")
  for (x <- sortedByfirstName)
    {
      println(x + " | ")
    }

  //Sort a class with Ordering trait
  val sortedFamily = family.sorted

  println("Using sorted via Ordering trait ... ")
  for (x <- sortedFamily)
  {
    println(x + " | ")
  }

}
