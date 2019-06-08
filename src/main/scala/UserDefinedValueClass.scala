
//Rules of building your own value class
//1. It can only get 1 value
//It should contain only defs (methods)
class Dollars (val amount: Int) extends AnyVal {
  override def toString: String = "$ " + amount
}


class Francs (val amount: Int) extends AnyVal{
  override def toString: String = amount + " CHF"
}


object MainObject{
  def main(args: Array[String]): Unit = {
    val d = new Dollars(10)
    //Scala treats this d.amount as integer
    println(d.amount + 100)
    //Scala treats d as String
    println(d)

    val francs = new Francs(100)
    println(francs)
  }
}
