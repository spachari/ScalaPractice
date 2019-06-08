package com.programmingscala.examples.scalaObjectSystem.linearization

class D1 {

  {
    println("I am the constructor")
  }
  print("D1 ")
}

trait E1 extends D1 {
  print("E1 ")
}

trait E2 extends D1 {
  print("E2 ")
}

trait E3 extends D1 {
  print("E3 ")
}

class D2 extends E1 with E2 with E3 {
  print("D2 ")
}

object LinearizationOfObjectsHierarchyPrintStmts extends App {


  val c = new D2


}


//This invocation order makes sense when you consider that the parent types need to be constructed
// before the derived types, because a derived type often uses fields and methods in the parent types during
// its construction process.


