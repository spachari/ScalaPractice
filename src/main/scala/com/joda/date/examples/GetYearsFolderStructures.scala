package com.joda.date.examples

import org.joda.time.LocalDate

object GetYearsFolderStructures extends App {



  val startDate = LocalDate.parse("2018-01-01")
  val folderStructure = "s3://big-data-analytics-prod/ODS/project_ldt_xlr/source/hcom/gmt_date="

  def getYearsFolderStructure(folderStructure : String) = {
    val listofFolders = for (i <- 1 to 365) yield {
      val currentDate = startDate.plusDays(i)
      folderStructure + currentDate
    }
    listofFolders.toList
  }

  val allFolders = getYearsFolderStructure(folderStructure)

}
