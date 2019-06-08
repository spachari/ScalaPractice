case class Persons private (id : Int, name : String)

object Persons {
  def apply(name: String): Persons = new Persons(10000, name)
  def apply(): Persons = new Persons(10000, "Srinivas")
}

object AuxillaryConstructorForCaseClass {
  def main(args: Array[String]): Unit = {
    val p = Persons("Sadhana")
    println(p)
    val q = Persons()
    println(q)
  }
}
