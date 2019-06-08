package com.programmingscala.examples.types.typeProjections.hashoperatorinScala

class A {
  class B
  def f(b : B) = println("Got my B")
}

object UnderstandingInnerClassInScala extends App {

  val a1 = new A
  val a2 = new A

  //a1.f(new A.B)

  //When you declare a class inside another class in Scala, you are saying that each instance of that class has such a subclass.
  // In other words, there's no A.B class, but there are a1.B and a2.B classes

  //, and they are different classes. SO this will not work
  //a1.f(new a2.B)

  //THis will work. a1 can access it's own B
  a1.f(new a1.B)
  a2.f(new a2.B)

  //Now, # makes it possible for you to refer to such nested classes without restricting it to a particular instance.
  // In other words, there's no A.B, but there's A#B, which means a B nested class of any instance of A.

  class AA {
    class BA
    def f(b : BA) = println("Got my BA!")
    def g(b : AA#BA) = println("Got my cross object BA.") //# is used to mention the type of an inner class
    //def h(b : AA.BA) = println("Got my B") //there is no AA.BB
    //What you can do is (even this did not work)
    //val aa = new AA
    //def h(b : AA.BA) = println("Got my same instance BA")
  }

  val aa1 = new AA
  val aa2 = new AA

  aa1.g(new aa2.BA)
  aa2.g(new aa1.BA)

  //aa1.h(new aa1.aa.BA)
  //aa2.h(new aa2.aa.BA)

  //It is called as type members and it is used to access inner class

  class R {
    type A = Int
    var B : Int = 10
  }

  val r = null.asInstanceOf[R#A]
  println(r)


}
