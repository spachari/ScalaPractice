import FruitsItem.Fruits.{Apple => a,Orange}


//excluding pear from the import, but import all other items
import FruitsItem.Fruits.{Pear => _, _}


class printFruits {
  def print (fruit : FruitsItem.Fruit) = {
    import fruit._ //imports all of the variables such as name and color of the fruit
    println(name + " - " + color)
  }
}

class printOrange {
  import FruitsItem.Fruits.Orange //import a static field
  def print = println(FruitsItem.Fruits.Orange.name)
}




object MainFruits {
  def main(args: Array[String]): Unit = {
    val p = new printFruits
    p.print(FruitsItem.Fruits.Apple)

    val v = new printOrange
    v.print

    println("Calling apple by it's alias")
    p.print(a)
  }
}