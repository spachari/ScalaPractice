package com.programmingscala.examples

package object packageobject {

  trait RedApples {
    val red1, red2 = "red"
  }

  trait GreenApples {
    val green1, green2 = "Green"
  }

  trait apples extends RedApples with GreenApples {
    val redApples = List(red1, red2)

    val greenApples = List(green1, green2)
  }

  val family = List("Srinivas","Kirhtika","Sadhana", "Sadhiv", "Mummy")

}

