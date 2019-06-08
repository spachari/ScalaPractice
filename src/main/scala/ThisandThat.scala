
class number(a : Int)
{
  val b = this.a

  def addition ( that: number) : Int =
  {
    this.b * that.b
  }
}



object ThisandThat {
  def main(args: Array[String]): Unit = {
    val a = new number(1)
    val b = new number(2)

    println(a.addition(b))
  }

}
