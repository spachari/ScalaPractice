package com.programmingscala.examples.patternmatching

object Op extends Enumeration {
  type Op = Value

  val GT = Value(">")
  val LT = Value("<")
  val EQ = Value("==")
  val LE = Value("<=")
  val GE = Value(">=")
  val NE = Value("!=")
  val LTGT = Value("<>")
}

import Op._
case class WhereIn[T](col : String, in : String, vals : T*)

case class WhereOp[T](col : String, op : Op, value : T)

object DesignsUsingPatternMatchingCreatingSQLlikeFilters extends App {

  val countryColName = "country"
  val valueDateColName = "value_date"
  val nameColName = "name"
  val lastNameColName = "last_name"

  val seq = Seq(WhereIn(countryColName, "in", "India", "America","Canada", "GB"),
                WhereOp(valueDateColName, EQ, "2018-07-14"),
                WhereOp(nameColName, LTGT, "Srinivas pachari") ,
                WhereIn(lastNameColName, "in", "Srinivas","Kirthika","Sadhana"))

  seq.foreach(println)

  def convertStringToFilterItem [T](s : T) = {
    s"'${s}'"
  }

  for (s <- seq) {
    s match {
      case WhereIn(colName, filter, items @ _*) => {
        val itemsString = items.map(x => convertStringToFilterItem(x)).mkString(",")
        println(s"${colName} ${filter} (${itemsString})")
      }
      case WhereOp(colName, filter, item) => println(s"${colName} ${filter} '${item}'")
      case _ => println("Not a valid input")
    }
  }




}
