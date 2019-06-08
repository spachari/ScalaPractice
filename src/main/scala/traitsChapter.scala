class Animal {
  override def toString: String = "any animal"
}

class Dog extends Animal{
  override def toString: String = super.toString
}

trait Philosophical {
  def philosophize () = {
    println("I consume memory, therefore I am")
  }
}

trait HasLegs

class Frog extends Animal with Philosophical with HasLegs {
  override def toString: String = "green"
}

class Cat extends Animal with Philosophical {
  override def toString: String = "blue"

  override def philosophize(): Unit = { println("It is not easy being " + toString + " !") }
}

object MainObjects {
  def main(args: Array[String]): Unit = {
    val frog = new Frog
    println(frog)
    println(frog.philosophize())

    val phil : Philosophical = frog
    phil.philosophize()

    val cat = new Cat
    println(cat)
    cat.philosophize()

    val dog = new Dog
    println(dog)
  }
}