package com.neophytes.guide

import java.net.URL

import com.neophytes.guide.EitherLeftOrRight.{Cigarette, Customer, UnderAgeException}

object ExceptionsWithEitherLeftOrRight extends App {

  def buyCigarette (customer : Customer, cigarette : Cigarette) : Either[UnderAgeException, Cigarette] = {
    if (customer.age <= 20)
    {
      Left(throw new UnderAgeException)
    }
    else
    {
      Right(cigarette)
    }
  }

  val cust1 = Customer(5)
  val cust2 = Customer(25)

  println(buyCigarette(cust2, new Cigarette))
  println(buyCigarette(cust1, new Cigarette))


  //Either used in collections
  type Citizen = String
  case class BlackListedResource(url : URL, visitors : Set[Citizen])

  val blackListSitesAndCitizens : List[BlackListedResource] = List(
    BlackListedResource(new URL("http://yahoo.com"),Set("John Smith", "Srinivas Pachari")),
    BlackListedResource(new URL("http://gmail.com"),Set("Jane Doe", "Rishab Pant")),
    BlackListedResource(new URL("http://cricinfo.com"),Set("Sachin Tendulkar", "Rishab Pant"))
  )

  val blackListedList : List[Either[URL, Set[Citizen]]] = {
    blackListSitesAndCitizens.map(resource =>
    if (resource.visitors.isEmpty)
      {
        Left(resource.url)
      } else
      {
        Right(resource.visitors)
      })
  }

  println("Users in balcklisted options are " + blackListedList.flatMap(x => x.right.toOption).flatten.toSeq)
  println("Users in balcklisted options are " + blackListedList.flatMap(x => x.left.toOption))

}
