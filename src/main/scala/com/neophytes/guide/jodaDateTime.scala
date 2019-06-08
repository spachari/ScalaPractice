package com.neophytes.guide

import org.joda.time.DateTime

object jodaDateTime extends App {

  val dateString = "2018-01-01"

  val date = new DateTime("2018-01-01")

  println(date)

  import org.joda.time.format.DateTimeFormat

  val formatter = DateTimeFormat.forPattern("yyyy-MM-dd")
  val dt = formatter.parseDateTime(dateString)



  println(s"${dt} --- ${dt.plusDays(10)}")

  //Using LocalDate
  import org.joda.time.LocalDate

  val d = LocalDate.parse("2018-01-01")

  println(s"${d} --- ${d.plusDays(10)}")

}
