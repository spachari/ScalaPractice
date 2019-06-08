package com.programmingscala.examples.types.selftype.annotations

trait Persistence {
  def startPersistence() : Unit
}

trait MidTier {
  def startMidTier() : Unit
}

trait UI {
  def startUI() : Unit
}

trait Database extends Persistence {
  override def startPersistence(): Unit = { println("Start Database") }
}

trait BizLogic extends MidTier {
  override def startMidTier(): Unit = { println("Starting MidTier") }
}

trait WebUI extends UI {
  override def startUI(): Unit = { println("Starting UI") }
}

trait StartApp {
  self : Database with BizLogic with WebUI => //This means whoever uses StartApp, should mix it in with
                                              //Database with BizLogic with WebUI traits

  def run() = {
    startPersistence()
    startMidTier()
    startUI()
  }

}

trait StartAppInheritance extends Database with BizLogic with WebUI {
  //StartAppInheritance can use all these methods too
  def run = {
    startMidTier()
    startUI()
    startPersistence()
  }
}



object SelfTypeAnnotationsUsedAsMixinComposition extends StartApp with Database with BizLogic with WebUI  with App {

  val myApp = new StartApp with Database with BizLogic with WebUI {} //even when object creation
  myApp.run()

  //val startAppInheritance = new StartAppInheritance {}
  //startAppInheritance.run

}
