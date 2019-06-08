class Outer {
  class Inner {
    var x = 1
  }}


object MainInnerOuter {
  def main(args: Array[String]): Unit = {
    val o = new Outer
    val i = new o.Inner
    println(i.x)
  }
}
