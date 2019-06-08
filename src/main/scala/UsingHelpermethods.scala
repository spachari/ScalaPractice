package printMenu

import bobsdelight.showFruit //imported from the package
import FruitsItem.Fruits    //imported from the object

object MainFruitsProgram {
  def main(args: Array[String]): Unit = {
    for (fruit <- Fruits.menu)
      {
        showFruit(fruit)
      }
  }
}