abstract class Shape {
  def paint()
}

class Red extends Shape {
  def paint = println("Red")
}

class Green extends Shape {
  def paint = println("Green")
}

class Blue extends Shape {
  def paint = println("Blue")
}


class ShapeCreator private (val s : String) {
 //def getShape (s : String) : Shape = if (s == "Red") new Red

}

object factoryMethods {
  def main(args: Array[String]): Unit = {
    //val shape = new ShapeCreator(1,2)
  }
}
