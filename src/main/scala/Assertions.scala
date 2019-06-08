class numbers {

  //assert example
  val rnd = Math.random()
  val absolute = rnd.abs
  assert(absolute > 0)
  //asseting a condition is true

  //ensuring example. It checks the output of the method passes a condition
  def halfaNumber (i : Int) = {
    require(i > 8) //checks the input
    val j = i / 2
    j
  } ensuring (j => j > 0 && i / 2 > 0) // checks the output and the input
}

object Assertions {
  def main(args: Array[String]): Unit = {
    val n = new numbers
    println(n.rnd)

    println(n.halfaNumber(10))
  }
}
