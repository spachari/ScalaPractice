package com.programmingscala.examples.types

class Thatha {
  def didNotHaveCurrent() = println("Did not ahve current ... ")
}

class Dad extends Thatha {
  override def didNotHaveCurrent() = println("had some current ... ")
}

class Me extends Dad {
  def hadSmartPhones() = println("Did not have smart phones, but had mobile phones ... ")
}

class MySon extends Me {
  override def hadSmartPhones(): Unit = println("Had a lot of smart Phones ")
}



object TypeBounds extends App {

  def checkSmartPhone[T >: Me](T : MySon) = {
    T.hadSmartPhones()
  }

  def checkCurrent[T <: Dad](T : Thatha) = {
    T.didNotHaveCurrent()
  }

  val srinivasan = new Thatha
  val surendranath = new Dad
  val srinivas = new Me
  val sadhiv = new MySon

  srinivasan.didNotHaveCurrent()
  surendranath.didNotHaveCurrent()
  srinivas.hadSmartPhones()
  sadhiv.didNotHaveCurrent()

  checkCurrent(sadhiv)

}