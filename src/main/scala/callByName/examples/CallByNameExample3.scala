package callByName.examples

object CallByNameExample3 extends App {


  @annotation.tailrec
  def continue(conditional: => Boolean)(body: => Unit) {
    if (conditional) {
      body
      continue(conditional)(body)
    }
  }

  var count = 5
  continue(count >= 0) {
    println(s"count = ${count}")
    count = count - 1
  }
}
