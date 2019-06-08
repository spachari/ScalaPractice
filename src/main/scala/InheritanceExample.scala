abstract class Elements {
  def demo() = {
    println("Element's implementation invoked")
  }
}

class ArrayElements extends Elements {
  override def demo () = {
    println("Array Element's implementation invoked")
  }
}


class LineElements extends Elements {
  override def demo () = {
    println("Line Element's implementation invoked")
  }
}

class UniformElements extends Elements

object InheritanceExample {
  def main(args: Array[String]): Unit = {
    val e : Elements = new ArrayElements
    e.demo()

  }
}