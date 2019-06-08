//Without having an object class
class Pizza {
  var pizzaId = 1
  var pizzaCrust = "Vegetarian"

  def this (pizzaId : Int, pizzaCrust : String) {
    this()
    this.pizzaCrust = pizzaCrust
    this.pizzaId = pizzaId
  }


  def this(pizzaId : Int) {
    this()
    this.pizzaId = pizzaId
    this.pizzaCrust = pizzaCrust
  }

  def this(pizzaCrust : String) {
    this()
    this.pizzaId = pizzaId
  }

  override def toString: String = s"The id is $pizzaId and it's crust is $pizzaCrust"

}

object auxillaryConstructorWithoutObject {
  def main(args: Array[String]): Unit = {
    val p = new Pizza()
    println(p)

    val q = new Pizza(2, "Margareta")
    println(q)

    val r = new Pizza(3)
    println(r)
  }
}
