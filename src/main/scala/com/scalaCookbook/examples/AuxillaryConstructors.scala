package com.scalaCookbook.examples


class Pizza (var crustSize : Int, var crustType : String) {
  def this(crustSize : Int) {
    this(crustSize, Pizza.DEFAULT_CRUST_TYPE)
  }

  def this(crustType : String) {
    this(Pizza.DEFAULT_CRUST_SIZE, crustType)
  }

  def this() {
    this(Pizza.DEFAULT_CRUST_SIZE, Pizza.DEFAULT_CRUST_TYPE)
  }

  override def toString = s"A ${crustSize} pizza of type ${crustType}"
}

object Pizza {
  val DEFAULT_CRUST_SIZE = 12
  val DEFAULT_CRUST_TYPE = "Thin"
}

object AuxillaryConstructors extends App {
  val p = new Pizza()
  val q = new Pizza(8, "Deep")
  val r = new Pizza("Cheese")
  val s = new Pizza(20)

  println(p.toString)
  println(q.toString)
  println(r.toString)
}
