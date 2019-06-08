package com.general.data.structures.and.algorithms

import java.time.{LocalDate, Year}


object CreateMonthsOfYear extends App {


  val year = "2017"
  //(1 to 11).foldRight(List[LocalDate](Year.parse(year).atDay(1)))((initialDate,dateList) => dateList :+ dateList.map(x => x.plusMonths(1)) )

  def compareDates(startEndDate : (LocalDate,LocalDate), checkDate : LocalDate) = {
    startEndDate._2.isBefore(checkDate.plusDays(1))
  }



  def getStartDatesAndEndDatesForYear(year : String) = {
    val startDateOfYear = Year.parse(year).atDay(1)
    val monthStartAndEndDateTuple = for (i <- 0 to 11) yield {
      val monthStartDate = startDateOfYear.plusMonths(i)
      (monthStartDate, monthStartDate.plusMonths(1).minusDays(1))
    }
    monthStartAndEndDateTuple.toList
  }

  val list = getStartDatesAndEndDatesForYear(year)


  println("---------------")
  list.dropWhile( (x : (LocalDate,LocalDate)) => { compareDates(x, LocalDate.parse("2017-03-31"))}).foreach(println)
}
