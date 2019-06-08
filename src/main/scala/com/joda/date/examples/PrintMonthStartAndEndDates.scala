package com.joda.date.examples

import java.time.Year

object PrintMonthStartAndEndDates extends App {

  def getStartDateAndEndDateForAllMonthsOfYear(year : String) = {
    val startDateOfYear = Year.parse(year).atDay(1)
    val listOfMonths = for (i <- 0 to 11) yield {
      (startDateOfYear.plusMonths(i), startDateOfYear.plusMonths(i + 1).minusDays(1))
    }
    listOfMonths
  }

  def addstartDateAndEndDateforSparkJob(s : String, year: String) = {
    for (i <- getStartDateAndEndDateForAllMonthsOfYear(year)) {
      println(s + " --reportStartDate " + i._1 + " --reportEndDate " + i._2)
    }
  }
  addstartDateAndEndDateforSparkJob("spark-submit --class com.hotels.hde.visitsummary.history.backfill.VisitSummaryHistoricBackFillDriver " +
    "/tmp/hde-cas-visit-summary-historic-backfill-spark.jar --configFile file:///tmp/application_prod.conf  " +
    "--hcomClickstreamCloverLeafTable  roads_etl.hcom_clickstream_by_timestamp " +
    "--whiteListTable bix_clickstream.omniture_guid_list --visitSummaryStagingTable roads.hcom_clickstream_visits ", "2014")

}
