val list = List(1,2,3)

def addNewList(list: List[Int]) = {
  val newList = List()
  for (l <- list) yield {
    l * 2
    l :: newList
  }
}

val test = addNewList(list).flatMap(x => x)


class Persons(id: Int, name: String)
{
  val this.id = id
  val this.name = name
  def getId = id
  def getName = name
}


val customerlist = List((35966,"123@gmail.com","xyz@gmail.com"),
  (35969,"xyz@gmail.com","abc@gmail.com"),
  (35972,"abc@gmail.com","srinivaspach@gmail.com"),
  (35973,"srinivaspach@gmail.com","srinivaspach@hotmail.com"))

val a = new Persons(1, "Srinivas")

val b = new Persons(2, "Kirthika")

val c = new Persons(3, "Sadhana")

val d = new Persons(4, "Sadhiv")

val family = List(a,b,c,d)

for (l <- family)
{
  print(l.getId)
  print("\t" + l.getName)
  println()
}

val list1 = List(1,2,3)

def getTuple (list : List[Int],i : Int) =
  list.filter(x => x == i).map(x => (i,x))

getTuple(list1,2)



case class idAddress (customeraccountid : Int,
                      old_primaryemailaddress : String)

def getID (id : idAddress) : Int =
{
  id.customeraccountid
}

def getOld_primaryAddress (id : idAddress) : String =
{
  id.old_primaryemailaddress
}

def getId (list : List[(Int, String)]) : (Int, String) = list match {
  case x :: Nil => (x._1,x._2)
  case (0,"") :: Nil => (0,"")
  case (0,null) :: Nil => (0,"")
  case Nil =>  (0,"")
}


def getRecursiveList (id: (Int, String)) : (Int, String) = {
  import scala.annotation.tailrec
  @tailrec
  def getPreviousID(id: (Int, String)) : (Int, String) = {
    val currentCustomerDetails = List(id)
    import scala.util.Sorting.stableSort
    val oldCustomerDetails =
      customerlist.filter(x => x._3 == id._2 && x._1 < id._1).map(x => (x._1, x._2)).toList

    println("currentCustomerDetails " + getId(currentCustomerDetails))
    println("oldCustomerDetails " + getId(oldCustomerDetails))

    getId(oldCustomerDetails) match {
      case (0, "") => getId(currentCustomerDetails)
      case (_, _) => getPreviousID(getId(oldCustomerDetails))
    }
  }
  getPreviousID(id)
}



try
  {
    val output = getRecursiveList(35973,"srinivaspach@gmail.com")._1
  } catch
{
  case e : Exception => println ("Exception cannot be obtained for output")
} finally
{

}


//val primaryOutput = output._1

import scala.util.Sorting.stableSort

//scala.util.Sorting.stableSort(customerlist,
//  (e1 : (Int,String,String),
//   e2 : (Int,String,String)) => e1._1 > e2._1)


val range = 1 to 1000

val rangeArray = range.toArray

for (item <- rangeArray zip customerlist)
{
  println( item._1 )
}

case class Amount(Rupee : Int, Paise : Int)
val amt = new Amount(100,10)

amt.Rupee


import org.apache.spark._
import org.apache.spark.sql._

val allRecordsDF  =
  sc.parallelize(List((35966,"123@gmail.com","xyz@gmail.com"),
  (35969,"xyz@gmail.com","abc@gmail.com"),
  (35972,"abc@gmail.com","srinivaspach@gmail.com"),
  (35973,"srinivaspach@gmail.com","srinivaspach@hotmail.com"))).toDF


val allRecordsList = customerRDD.select("customerprofilechangeid","old_primaryemailaddress","new_primaryemailaddress").collect.map(x => (x.getLong(0),x.get(1).toString,x.get(2).toString)).toList



for (col <- customerRDD.collect()) yield
  {
    val dataset = (col.getInt(0), col.getString(1), col.getString(2))
    dataset :: allRecordsList
  }