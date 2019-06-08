package com.programmingscala.examples.implicits.implicitsForAllowedInstances

object implicits {

  //implicit class must have a primary constructor with exactly one argument in the first parameter list
  implicit class SRow(row : JRow) {

    //This method simply takes matching type of (JRow, String) => T as toT and executes it
    def get[T](colName: String)(implicit toT: (JRow, String) => T): T = {
      toT(row, colName)
    }

    def getWithColName(colName : String) = {

    }

  }

  //For implicit toT: (JRow, String) the declaration should be implicit in order to be passed to the caller get[T]
    implicit val jRowToInt : (JRow, String) => Int = (row : JRow, colName : String) => row.getInt(colName)

    implicit val jRowToDouble : (JRow, String) => Double = (row : JRow, colName : String) => row.getDouble(colName)

    implicit val jRowToString : (JRow, String) => String = (row : JRow, colName : String) => row.getString(colName)

}



object ConstrainingAllowedInstances extends App {

  import implicits._

  val row = JRow(Map("one" -> 1, "two" -> 2.2, "three" -> "THREE"))

  val oneValue1 : Int = row.get("one")

  val twoValue1 : Double = row.get("two")

  val threeValue1 : String = row.get("three")

  println(oneValue1)

  println(twoValue1)

  println(threeValue1)

  val oneValue2 = row.get[Int]("one")

  val twoValue2 = row.get[Double]("two")

  val threeValue2 = row.get[String]("three")

  println(oneValue2)

  println(twoValue2)

  println(threeValue2)


}
