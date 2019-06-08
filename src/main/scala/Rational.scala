class Rational (n: Int, d: Int) extends Ordered[Rational] {
  require(d != 0)

  private val g = gcd(n , d)

  val numer: Int = n / g
  val dinom: Int = d / g

  def this(n : Int) = this(n,1) //auxillary constructor

  override def toString = numer + "/" + dinom

  def + (tha: Rational) : Rational = {
    new Rational(this.numer * tha.dinom + this.dinom * tha.numer, this.dinom * tha.dinom)
  }

  def + (i : Int) : Rational = {
    new Rational(this.numer + i, dinom)
  }

  def * (that: Rational) : Rational = {
    new Rational(this.numer * that.numer, this.dinom * that.dinom)
  }

  def * (i : Int) : Rational = {
    new Rational(this.numer * i, dinom)
  }

  def - (that:Rational) : Rational = {
    new Rational(this.numer * that.dinom - that.numer * this.dinom, this.dinom * that.dinom)
  }

  def - (i : Int) : Rational = {
    new Rational(this.numer - i * this.dinom, dinom)
  }

  def / (that: Rational) : Rational = {
    new Rational( this.numer * that.dinom, this.dinom * that.numer)
  }

  def / (i : Int) : Rational = {
    new Rational(this.numer, this.dinom * i)
  }

  def lessThan(that: Rational) : Boolean = {
    if (this.numer * that.dinom > that.numer * this.dinom) true else false
  }

  def gcd (a : Int, b: Int) : Int = {
    //println(a + " " + b)
    if (b == 0) a else gcd(b, a % b)
  }

  override def compare(that: Rational): Int = {
    (this.numer * that.dinom) - (that.numer * this.dinom)
  }
}


object Mains{
  def main(args: Array[String]): Unit = {
    val twoThird = new Rational (2,3)
    val oneHalf = new Rational (1,2)
    val output = oneHalf + twoThird
    print(output)
    println(twoThird > oneHalf)
  }
}


//