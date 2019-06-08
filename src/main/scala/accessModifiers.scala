//1. A class cannot access it's inner class private methods
class Outer1 {
  class Inner1 {
    private def f (i : Int) = println(i)
    class InnerMost {
      f (1)
    }
  }
  //not allowed
  // (new Inner).f(1)
}


//2. A protected method can only be accessed from it's sub class from it's same package. It cannot even be accessed from other classes from it's same package
package p {
  class Super {
    protected def f () = println("Hello")
  }

  class Sub extends Super {
    f()
  }

  class NonSuper {
    // not allowed
    // (new Super).f()
  }
}




object MainAccessProgram {
  def main(args: Array[String]): Unit = {
    val o : Outer = new Outer
    val i = new o.Inner
    //not allowed. cannot call a private method
    //println("Inner class i" + i.f(10))

    val s = new p.Super
    //not allowed. cannot call a protected method outside of the package
    //print("Super class method")
    //s.f()

    println("Sub class method")
    val sub = new p.Sub
    //this is not possible either
    //sub.f()

    println("")

    println("Non super class method")
    val ns = new p.NonSuper



  }
}