package com.scalaCookbook.examples.Methods

class Foo {
  private[this] def isFoo = true //This can be used only in the current instance.

  def checkIfFoo (other : Foo) = {
    //if(other.isFoo) true else false //This is not allowed.
    // For example
    // val p = new Foo
    // val q = new Foo
    // println(p.checkIfFoo(p))
    // See the method which belongs to object p is using other object q as parameters.
    // With q, we cannot use isFoo

  }

  private def isFooPrivate = true //This can be used within the class

  def checkIfFooPrivate (other : Foo): Boolean = { //println(p.checkIfFooPrivate(p)) is fine
    if (other.isFooPrivate) true else false
  }

}

class Animal {
 private def breathe() = println("breathing ...") //Sub classes cannot access super class private methods
  protected def move() = println("depends ...")  //Sub classes can access super class protected methods
}

class Dog extends Animal {
  //override def breathe() = println("breathing ...") Sub classes cannot access super class private methods
  override def move(): Unit = println("I run fast")
}


package world {
  class Animal {
    protected def breathe() = println("breathing ...")
  }

  class Dog {
    val a = new Animal
    //a.breathe() //Cannot call a protected method within the ackage if this class is not a subclass of the class
  }
}

//To make a method available to the whole package, we need to use package level access

package worldWithPackagelevelAccess {
  class Animal {
    private[worldWithPackagelevelAccess] def breathe() = println("breathing ...")
    private def canSwim() = println("Swimming") //Cannot use this method
  }

  class Dog {
    val a = new Animal
    a.breathe()
  }
}

package com.acme.coolApp.model {
  class Foo1 {
    private[model] def doY {}
    private[coolApp] def doz {}
    private[acme] def doA {}
  }
}


package com.acme.coolApp {
  import com.acme.coolApp.model._
  class Bar {
    val a = new Foo1
    //doY{} cannot access because doY is in scope for only com.acme.coolApp.model package
    a.doz //Can acess because doz is available for all packages under coolApp
    a.doA  //Can acess because doA is available for all packages under acme
  }
}

//Default scope is public


object AccessRightsForMethods extends App
{
  val p = new Foo
  val q = new Foo
  println(p.checkIfFooPrivate(p)) //
}
