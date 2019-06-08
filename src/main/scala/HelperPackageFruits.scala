package object bobsdelight {
  def showFruit (fruit : FruitsItem.Fruit) = {
    import fruit._
    println(name + " - " + color)
  }
}
