package com.scalaCookbook.examples.Implicits

object ImplicitInDefDeclarationTest {
  def main(args: Array[String]): Unit = {
    import implicitConversions.doubleToInt

    val x : Int = 1.7
    println(x)

    import com.srinivas.utils.StringUtils._
    val output = "HAL".increment
    println("HAL".decrement)

    println(output)

  }
}
