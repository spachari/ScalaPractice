package com.programmingscala.examples.implicits.implicitsForAllowedInstances

case class InvalidColumnName(name : String) extends RuntimeException (s"Invalid column name ${name}")

trait Row {

  def getInt(colName : String) : Int
  def getString(colName : String) : String
  def getDouble(colName : String) : Double
}

case class JRow(representation : Map[String, Any]) extends Row {

  private def get(colName : String) = {
    representation.getOrElse(colName, throw InvalidColumnName(colName))
  }

  override def getInt(colName: String) = get(colName).asInstanceOf[Int]

  override def getString(colName: String) = get(colName).asInstanceOf[String]

  override def getDouble(colName: String) = get(colName).asInstanceOf[Double]

}

