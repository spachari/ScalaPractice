package com.scalatypes

import scala.reflect.ClassTag

object ViewBounds extends App {

  //Let's have an implicit for String to Int
  implicit def stringToInt(s : String) = {
    s.toInt
  }

  //A view bound was a mechanism introduced in Scala to enable the use of some type A as if it were some type B.
  // The typical syntax is this: You specify a view bound with <%

  //Let's create a view bound in which A will be viewed as Int
  class Container[A <% Int] {
    def add123(x : A) = x + 123
  }

  val x = new Container[String].add123("123")
  println(x)

  val x1 = new Container[Int].add123(100)
  println(x1)

  //This will not work
  //val x2 = new Container[Float].add123(100.00)


  //Example
  //def f[A <% B](a: A) = a.bMethod
  //A should have an implicit conversion to B available, so that one can call B methods on an object of type A.

  //def f[A <% B](a: A) = a.bMethod
  //def f[A](a: A)(implicit ev: A => B) = a.bMethod


  //An example of how view bound is implemented
  //scala> def f[A <% Int](a: A) = a * 100
  //f: [A](a: A)(implicit evidence$1: A => Int)Int

  //A has implicit conversion to Int via stringToInt method
  //scala> f("100")
  //res0: Int = 10000

  //If you want this to work for double create another implicit def
  implicit def doubleToInt(f : Double) = {
    f.toInt
  }

  def g[A <% Int](a : A) = a * 100
  println(g(1.00))

  //In effect, for view bounds (for something to be viewed as Int), you need an implicit conversion and can use it with
  //<%


  //Context Bounds
  //While a view bound can be used with simple types (for example, A <% String),
  // a context bound requires a parameterized type, such as Ordered[A] above, but unlike String.

  //A context bound describes an implicit value, instead of view bound's implicit conversion. It is used to declare
  // that for some type A, there is an implicit value of type B[A] available. The syntax goes like this:

  //def f[A : B](a: A) = g(a) // where g requires an implicit value of type B[A]

  //A common usage of context bounds is when we create an array
  def f[A : ClassTag](n : Int) = {
    new Array[A](n)
  }

  val output = f[Int](1)

  output.foreach(println)
  println(output.getClass.getCanonicalName)

  def y[A : ClassTag](x : A) = Array(x)

  val outputArray = y[Int](1)

  outputArray.foreach(println)

  //How are they both implemented
  //View Bound
  //def f[A <% B](a: A) = a.bMethod
  //def f[A](a: A)(implicit ev: A => B) = a.bMethod

  //ContextBound
  //def g[A : B](a: A) = h(a)
  //def g[A](a: A)(implicit ev: B[A]) = h(a)
  //As you can see, for view Bounds, we need an implicit conversion (implicit ev: A => B),
  //whereas for context bounds, we need an implicit value B[A] (implicit ev: B[A])

  //Why do we need view Bounds, if we are to use ordering on an int
  //this will only work if we have an implicit conversion
  def contextOrder[A <% Ordered[A]](a : A, b : A) : A = if (a > b) a else b

  //Context Bound is used in a simple example in tabulate function
  def tabulate[T : ClassTag](len : Int, f : Int => T) = {
    val xs = new Array[T](len) //During runtime, you need to provide what type of array you want to create
    println("Array of size " + xs.length)
    for (i <- 0 until xs.length)
      {
        println("xs(i) = " + xs(i))
        println("f(i) = " + f(i))
        xs(i) = f(i)
      }
    xs
  }

  def toInt[T](x : Int) = x

  val result = tabulate(10, toInt)

  result.foreach(println)


  //Another good explanation of context Bound and view bound in scala can be told like this
  //In Scala a View Bound (A <% B) captures the concept of 'can be seen as' (whereas an upper bound <: captures the concept
  // of 'is a'). A context bound (A : C) says 'has a' about a type. You can read the examples about manifests as "T has a Manifest".
  // The example you linked to about Ordered vs Ordering illustrates the difference. A method

  def example[T <% Ordered[T]](param: T) = ???

  //T can be seen as Ordered, so this means we need to provide an Ordered

  def example[T : Ordering](param: T) = ???

  //T can be associated with Ordering. This means Ordering is already provided within Scala i.e. There is Ordering[T]
  //This is used only in a parameterized Type (Ordering[T])

  //Another simple example
  implicit def intToString(i : Int) = i.toString
  //intToString: (i: Int)String

  def useStringToInt[A <% String](x : A) = 1
  //useStringToInt: [A](x: A)(implicit evidence$1: A => String)Int


}
