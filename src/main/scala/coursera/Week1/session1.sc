object session1 {
  1 + 2

  def abs(x : Double) = if (x > 0) x else -x
  abs(-10)

  def sqrt (x : Double) = {

    println(s"passing ${x}")
    //The value of x is visible in all the below functions
    def sqrtIter(guess: Double): Double =
      if (isGoodEnough(guess)) guess
      else sqrtIter(improve(guess))

    def isGoodEnough(guess: Double) =
      (abs(guess * guess - x)) / x < 0.001

    def improve(guess: Double) =
      (guess + x / guess) / 2

    sqrtIter(1.0)
  }

  sqrt(2)
  sqrt(4)
  sqrt(16)
  sqrt(1e60)

  println(10 % 20)

  def gcd (a : Int, b : Int) : Int = {
    if (b == 0) a else gcd(b, a % b)
  }

  gcd(21, 14)
  gcd(32, 16)

  def factorial(x : Int) : Int = {
    if (x == 1) x else x * factorial(x - 1)
  }

  factorial(5)


  def countChange(money: Int, coins: List[Int]): Int = {
    var numWays = 0
    var total = 0

    def addSameElementFromList( coins : Int) : Int = {
      if (total != money)
      {
        total = coins + addSameElementFromList(coins)
        println(total)
      }
      total
    }
    addSameElementFromList(coins.head)
  }
  countChange(4,List(1,2))

}