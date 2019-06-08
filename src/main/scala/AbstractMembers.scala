trait Abstract {
  type T
  def transform (x : T) : T
  val initial : T
  val current : T
}

class ConcreteString extends Abstract {
  type T = String
  def transform (x : String) : String = x + x
  val initial : String = "hi"
  val current : String = initial
}

class ConcreteInteger extends Abstract {
  type T = Integer
  def transform (x : Integer) : Integer = x
  val initial : Integer = 1
  val current = initial
}

trait RationalTrait {
  val numerArg : Int
  val dinomArg : Int
  //require (dinomArg != 0)// it will fail because the anonymous class is initialised after the trait is initialised. SO at that time the trait is initialised,
  //the values 3 and 2 are not available
  println("trait initialisation complete")

  override def toString: String = numerArg + "/" + dinomArg
}

trait RationalTraitWithRequire {
  val numerArg: Int
  val denomArg: Int
  //require(denomArg != 0)
  private val g = gcd(numerArg, denomArg)
  val numer = numerArg / g
  val denom = denomArg / g
  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
  override def toString = numer + "/" + denom
}

class RationalClass1(val numberArg : Int = 0, val dinomArg : Int = 0) {

  require(dinomArg != 0) // this will have no issues because when the object is initialised, it will resolve the values for a class
}


trait LazyRationalTrait {
  val numerArg : Int
  val denomArg : Int

  lazy val g = {
    require(denomArg!= 0)
    gcd(numerArg, denomArg)
  }

  lazy val numer = numerArg / g
  lazy val denom = denomArg / g

  private def gcd (a : Int, b : Int) : Int =
    if (b == 0) a else gcd(b, a % b)

  override def toString: String = numer + "/" + denom
}



object AbstractMembers extends App {
  val p = new ConcreteInteger

  println(new RationalTrait {
    println("anonymous class starting")
    val dinomArg: Int = 2
    val numerArg: Int = 3
  }.toString)

  println(new RationalTrait {
    println("anonymous class starting")
    val dinomArg: Int = 2
    val numerArg: Int = 3
  }.toString)

  val q = new RationalClass1(3,2)

  println("anonymous class overriding a trait")
  println(new {
    val numerArg = 2
    val dinomArg = 3
  } with RationalTraitWithRequire {
    override val denomArg: Int = dinomArg
  }.toString)

  println("anonymous class overriding a trait pre-initilisation")
println(new {
    val numerArg = 2
    val denomArg = 3
  } with RationalTraitWithRequire{

}.toString)


  object oneThirds extends {
    val numerArg = 1
    val denomArg = 3
  } with RationalTraitWithRequire

  println("Printing lazy val")
  val x = 2
  println(new LazyRationalTrait {override val denomArg: Int = 3
    override val numerArg: Int = 2
  }.toString)

}
