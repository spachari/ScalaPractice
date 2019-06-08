package com.joda.date.examples

import org.joda.time.LocalDate

object JodaConversionExamples extends App {

  val process_date = LocalDate.parse("2018-06-05")

  val process_date_plus_1 = process_date.plusDays(1)

  println()

}
