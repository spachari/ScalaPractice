import scala.io.StdIn
import scala.util.{Try, Success, Failure}

class TryTest {
  def divide: Try[Int] = {
    val dividend = Try(StdIn.readLine("Enter the number you want to divide it by").toInt)
    val divisor = Try(StdIn.readLine("Enter the number you want to divide by").toInt)

    val problem = dividend.flatMap(x => divisor.map(y => x/y))

    problem match {
      case Success(v) => println("Result of " + dividend.get + "/" + divisor.get + " is: " + v)
        Success(v)
      case Failure(e) => println("Cannot do the division in this way. Try again !!!")
        Failure(e)
        divide
    }
  }
}

class TryGetArrayElement {
  def getItem = {
    val list = Try(StdIn.readLine("Enter the list").toList)
    val element = Try(StdIn.readLine("Enter the nth element to retrieve").toInt)

    //val item = list.flatMap(x => item.map(y => x.contains(y)))

    //item match {
    //  case Success(v) => println("Congrats, the item you requested is in the list" + item)
    //    Success(v)
    //  case Failure(v) => println("Oops the length of the list is only " + list.length +
    //    "Enter one within 0 to " + list.length)
    //    Failure(v)
    //    getItem

    }
}

object MainTry {
  def main(args: Array[String]): Unit = {
    val test = new TryTest
    test.divide

    //val getList = new TryGetArrayElement
    //getList.getItem
  }
}