abstract class Pets(name : String) {
  val greeting : String
  var age : Int
  def friendliness : Boolean

  def sayHello = {println("Say Hello")}

  override def toString: String = s"I say $greeting and I am $age old"
}

class Dogs(name : String) extends Pets(name : String) {
  val greeting  = "Woof!"
  var age = 3

  def friendliness : Boolean = true
}

class Cats(name : String) extends Pets(name : String) {
  val greeting = "Meow!"
  var age = 4

  override def friendliness: Boolean = false
}

object MainPetProgram extends App {
  val d = new Dogs("Timmy")
  d.sayHello
  println(d.toString)

  val c = new Cats("pussy")
  c.sayHello
  println(c.toString)
  c.age = 10

  println(c.toString)
}