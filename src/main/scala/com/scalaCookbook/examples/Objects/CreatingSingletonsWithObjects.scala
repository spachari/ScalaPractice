package com.scalaCookbook.examples.Objects

import java.text.SimpleDateFormat
import java.util.Calendar



object CashRegister {
  def open = { println("open") }
  def close = { println("close") }
}

object DateUtils {

  private def getCurrentDateTime(dateTimeFormat: String) = {
    val dateFormat = new SimpleDateFormat(dateTimeFormat)
    val cal = Calendar.getInstance()
    dateFormat.format(cal.getTime)
  }

  def getCurrentDate : String = getCurrentDateTime("EEEE, MMMM d")

  def getCurrentTime : String = getCurrentDateTime("K:m aa")

}


object CreatingSingletonsWithObjects extends App {
  CashRegister.open
  CashRegister.close

  println(DateUtils.getCurrentDate)
  println(DateUtils.getCurrentTime)
}
