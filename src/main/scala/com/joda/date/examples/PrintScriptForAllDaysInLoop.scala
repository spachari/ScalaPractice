package com.joda.date.examples

import org.joda.time.LocalDate

object PrintScriptForAllDaysInLoop extends App {

  val dateTime = LocalDate.parse("2017-01-01")



  for (i <- 0 to 60) {
    val string = "alter table roads.hcom_clickstream_visits drop partition (acquisition_instant='2017-01-01');"
    println(s"alter table roads.hcom_clickstream_visits drop partition (acquisition_instant='${dateTime.plusDays(i)}');" )
  }





}
