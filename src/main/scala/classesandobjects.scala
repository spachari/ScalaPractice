import Rocket.{goHome, pickStar}

class Rocket {
  import Rocket.fuel
  private def canGoHomeAgain = fuel > 20

  def chooseStrategy(rocket : Rocket) = {
    if (rocket.canGoHomeAgain)
      goHome()
    else
      pickStar()
  }


}

object Rocket {
  private def fuel = 10

  def goHome() = { println("going home") }
  def pickStar() = { println("pickign a star") }
}

object RocketTest {
  def main(args: Array[String]): Unit = {
    val r = new Rocket
    r.chooseStrategy(r)

  }
}