package com.programmingscala.examples.types.selftype.annotations


case class Button(val label : String) {
  def click(): Unit = {}
}

object ButtonSubjectObserver extends SubjectObserver1 {
  type S = ObservableButton
  type O = ButtonObserver

  class ObservableButton (label : String) extends Button(label) with Subject1 {
    override def click(): Unit = {
      super.click()
      notifyObservers()
    }

  }

  trait ButtonObserver extends Observer1 {
    override def receiverUpdate(button: ObservableButton)
  }
}

import ButtonSubjectObserver._

import scala.collection.mutable

class ButtonClickObserver extends ButtonObserver {

  val clicks = new mutable.HashMap[String, Int]()
  override def receiverUpdate(button: ObservableButton): Unit = {

    val count = clicks.getOrElse(button.label,0) + 1
    clicks.update(button.label, count)

  }
}

object Test extends App {

  val buttons = Vector(new ObservableButton("one"), new ObservableButton("two"))

  val observer = new ButtonClickObserver

  buttons.foreach(_.addObservers(observer))

  val testButton = new ObservableButton("one")

  testButton.click()

  for(i <- 0 to 2) {
    buttons(0).click()
  }

  for(i <- 0 to 4) {
    buttons(0).click()
  }

}