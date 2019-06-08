package com.joda.date.examples

import org.joda.time.LocalDate

object ConvertStringToPartition extends App {

  def convertDateToString (processDateString : String) = {

    var hoursInSeq : Seq[String] = Seq.empty

    def getHourlyPartitions(dateString : String) = {
      println(s"Processing ${dateString}")
      val year = dateString.substring(2, 4)
      val month = dateString.substring(5, 7)
      val date = dateString.substring(8, 10)
      val dayInString = s"$year$month$date"

      val stringAsVector = for (i <- 0 to 23) yield {
        s"'" + s"$dayInString" + f"${i}%02d".toString + s"'"
      }

      hoursInSeq = hoursInSeq ++ stringAsVector
    }

    val process_date = LocalDate.parse(processDateString)

    val datesToProcess = Seq(
      process_date.minusDays(1),
      process_date,
      process_date.plusDays(1),
      process_date.plusDays(2))


    datesToProcess.foreach(x => getHourlyPartitions(x.toString))

    println("Printing hourly sequence ... ")
    val allPartitionsString = hoursInSeq.mkString(",")

    println(allPartitionsString)
    allPartitionsString
  }

  println(convertDateToString("2018-07-16"))

}
