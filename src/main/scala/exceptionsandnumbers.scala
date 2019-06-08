object exceptionsandnumbers extends App {
  def myToInt(s : String) : Any = s.toInt + 1
  val numberInString = "10"
  val stringInString = "Srinivas"

  println(myToInt(numberInString))

  //This will throw an error
  //println(myToInt(stringInString))

  //Java way of dealing with this
def toIntWithException (s : String) : Option[Any] = {
  try {
    Some(myToInt(s))
  } catch {
    case e: NumberFormatException => None
  }
}
  println(toIntWithException(numberInString))
  println(toIntWithException(stringInString))

  def toIntInPatternMatching (s : String) = {
    Some(toIntWithException(s)).getOrElse() match {
      case x => x
      case x : NumberFormatException => 0
      case _ => println("None")
    }
  }

println("In toIntInPatternMatching function")
  println(toIntInPatternMatching(numberInString))
  println(toIntInPatternMatching(stringInString))
}
