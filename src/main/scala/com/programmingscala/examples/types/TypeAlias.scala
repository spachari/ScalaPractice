package com.programmingscala.examples.types

class Rows(xs : Int*)

object Rows {
  def apply(xs : Int*) = List(xs : _*)
}

object TypeAlias extends App {

  //When we call List(1,2,3,4) we actually call List.apply() method
  //So if we want to create types of our own, we need to create factories of our own
  type Row = List[Int] //Type alias should be created in the object
  def Row(xs : Int*) = List(xs : _*)
  //the above two lines are the same as the above class + Companion object

  type Matrix = List[Row]
  def Matrix(xs : Row*) = List(xs : _*)

  val matrix = Matrix(Row(1,2,3),
                      Row(1,2,3))

  val rows = Rows(1,2,3)

  //As programs get more complicated, it is better to use naming conventions
  type DataType = String
  type ColumnName = String

  val map = Map[ColumnName, DataType]()


}
