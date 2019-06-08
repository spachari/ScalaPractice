package com.scalaCookbook.examples.Files

object ReadingACSVFile extends App {

  val fileName = "/Users/spachari/Desktop/Spark-learning/SparkScala/textFile.dat"
  val file = scala.io.Source.fromFile(fileName)

  for (lines <- file.getLines().drop(1))
    {
      val Array(month, sales1, sales2, sales3) = lines.split(",").map(_.trim)
      println(s"Month  + $month sales 1 = + $sales1, sales 2 = + $sales2, sales 3 = + $sales3")
    }

  file.close()

  //The other way of doing this would be

    val file1 = scala.io.Source.fromFile(fileName)

    for (lines <- file1.getLines().drop(1))  {
      val record = lines.split(",").map(_.trim)
      println(s"${record(0)} | ${record(1)} | ${record(2)} | ${record(3)}")
    }

  file1.close()

  //file1.close()

  //Try and create an using method
  def using [A <: {def close() : Unit}, B] (resource : A)(f : A => B) : B = {
    try {
      f(resource)
    } finally {
      resource.close()
    }
  }

  var rows = scala.collection.mutable.ArrayBuffer[Array[String]]()

  using(scala.io.Source.fromFile(fileName)){source =>
    for (c <- source.getLines().drop(1))
      {
        rows += c.split(",").map(_.trim)
      }
  }

  for (c <- rows)
    {
      println(c(0) + c(1) + c(2) + c(3))
    }


  //Add the element in a two dimensional array
  val row = 3
  val col = 4

  val multiArray = Array.ofDim[String](row,col)

  var count = 0
  for(c <- scala.io.Source.fromFile(fileName).getLines().drop(1))
    {
      multiArray(count) = c.split(",").map(_.trim)
      count += 1
    }

  for (c <- 0 until multiArray.length)
    {
      println(s"${multiArray(c)(0)} | ${multiArray(c)(1)} | ${multiArray(c)(2)} | ${multiArray(c)(3)}")
    }

  //Printing the index of the file as row numbers

  val bufferedResource1 = scala.io.Source.fromFile(fileName)

  val multiArray1 = Array.ofDim[String](row,col)
  for ((line,count) <- bufferedResource1.getLines().drop(1).zipWithIndex)
    {
      multiArray1(count) = line.split(",")
    }

  for (c <- 0 until multiArray1.length)
    {
      println(s"${multiArray1(c)(0)} ${multiArray1(c)(1)} + ${multiArray1(c)(2)}  + ${multiArray1(c)(2)}")
    }

}
