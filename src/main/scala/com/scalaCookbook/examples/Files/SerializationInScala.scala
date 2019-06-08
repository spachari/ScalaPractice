package com.scalaCookbook.examples.Files

import java.io.{FileInputStream, FileOutputStream, ObjectInputStream, ObjectOutputStream}

@SerialVersionUID(100L)
class Stock (val stockId : Int, val stockName : String, val stockPrice : BigDecimal) extends Serializable {
  override def toString: String = s"Id is ${stockId}, name is ${stockName} and it's price is ${stockPrice}"
}

object SerializationInScala extends App {

  val fileLocation = "/Users/spachari/Desktop/Spark-learning/SparkScala/obj"
  val nflx = new Stock(100, "NetFlix", 123.45)

  //Serializing the object. Object will be written to here
  val oos = new ObjectOutputStream(new FileOutputStream(fileLocation))
  oos.writeObject(nflx)
  oos.close()

  val ois = new ObjectInputStream(new FileInputStream(fileLocation))
  val stock = ois.readObject.asInstanceOf[Stock]

  println(s"${stock}")

}
