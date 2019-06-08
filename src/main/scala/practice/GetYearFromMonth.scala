package practice

import java.time.LocalDate

object GetYearFromMonth extends App {

  def getStartDatesAndEndDatesForYear(year : String) = {
    val listOfMonths = List("01","02","03","04","05","06","07","08","09","10","11","12")

    val startDates = listOfMonths.map(x => LocalDate.parse(year + "-" + x + "-01"))

    def endDateMonth(month : String, year : String) = (month,year) match {
      case (("01"|"03"|"05"|"07"|"08"|"10"|"12"),_) => "31"
      case (("04"|"06"|"10"|"09"|"11"),_) => "30"
      case ("02",year) if (year.toInt % 4 == 0) => "29"
      case ("02",year) if (year.toInt % 4 != 0) => "28"
      case _ => "Undefined"
    }

    val endDates = listOfMonths.map(x => LocalDate.parse(year + "-" + x + "-" + endDateMonth(x, year)))

    startDates zip endDates
  }


  val startDateEndDateForEachMonth = getStartDatesAndEndDatesForYear("2017")

  println(startDateEndDateForEachMonth)

  for (i <- startDateEndDateForEachMonth) println(i)

  def compareDates(startEndDate : (java.time.LocalDate,java.time.LocalDate), checkDate : java.time.LocalDate) = {
    startEndDate._2.isBefore(checkDate.plusDays(1))
  }

  println("remaining dates")
  val datesToRun = startDateEndDateForEachMonth.dropWhile( (x : (java.time.LocalDate,java.time.LocalDate)) => { compareDates(x, LocalDate.parse("2017-02-28"))})

  datesToRun.foreach(println)
}
