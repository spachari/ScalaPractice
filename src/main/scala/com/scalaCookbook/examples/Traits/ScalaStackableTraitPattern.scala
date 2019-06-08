package com.scalaCookbook.examples.Traits

object ScalaStackableTraitPattern extends App {
  //In this pattern, a trait can play one of three roles

  //1. The base - The core traits (or abstract class) defines an abstract interface that all cores and stackables extend

  //2. The Core - The core traits implement the abstract methods defined in the base trait and provide basic, core functionality.

  //3. The stackable - Each stackable overrides one or more of the abstract methods defined in the base trait using scala's abstract override modifiers
    // and provides some behaviour and at some point invokes the super implementation of the same method.

  //Example let's consider the IntQueue class(base)
  abstract class IntQueue {
    def get(): Int
    def put(x : Int)
  }

  //1. The base - A basic implementation of IntQueue (a "core" class), which uses an ArrayBuffer

  import scala.collection.mutable.ArrayBuffer
  class BasicIntQueue extends IntQueue {

    def printInLine(x : ArrayBuffer[Int]) = {
      x.map(x => print(x + " "))
      println()
    }

    private val buf = new ArrayBuffer[Int]

    override def get(): Int = {
      println("Calling the get method ... ")
      buf.remove(0)
    }

    override def put(x: Int): Unit = {
      println("Calling BasicIntQueue put method ... ") ;
      buf += x
      println("Elelemts in the queue are")
      printInLine(buf)
    }

  }

  //we can use BasicIntQueue like this
  println("traits as core ... ")
  val b = new BasicIntQueue
  b.put(10)
  b.put(20)

  println(b.get())
  println(b.get())

/*
 * abstract class IntQueue {
    def get(): Int
    def put(x : Int)
  }
 */
  
  //2. The Core - Now let's use a trait
  trait Doubling extends IntQueue {
    abstract override def put(x: Int): Unit = { super.put(2 * x) }
    //It will call the put method in the class that extends IntQueue (which is abstract and does not have any implementation) +
    // having concrete implementation of put method
  }

  //Notice that there are two funny things going on with Doubling
  //1. The first is that it declares a superclass, IntQueue. This declaration means that the trait can only be mixed into a class that also extends IntQueue.
  //2. The second funny thing is that the trait has a super call on a method declared abstract. Such calls are illegal for normal classes, because they will
  // fail at run time.
  //
  // For a trait it will definitely work. Since super calls are dynamically bound, the super call in
  // trait Doubling will work so long as the trait is mixed in with another trait
  //or class that gives a concrete definition to the method.

  //This arrangement is frequently needed with traits that implement stackable modifications. To tell the
  // compiler you are doing this on purpose, you must mark such methods as abstract override. This combination of modifiers is only allowed for members of
  // traits, not classes, and it means that the trait must be mixed into some class that has a concrete definition of the method in question.

  println("Doubling as stackable modification trait... ")
  class MyQueue extends BasicIntQueue with Doubling

  val queue = new MyQueue

  queue.put(10)
  queue.put(30)

  println(queue.get())

  val queue1 = new BasicIntQueue with Doubling
  queue1.put(10)

  println(queue1.get())

  println("Stackable modification traits when instantiating new ... ")
  trait Incrementing extends IntQueue {
    abstract override def put(x: Int): Unit =
      {
        println("In incrementing method .... ")
        super.put(x + 1)
      }
  }

  trait Filtering extends IntQueue {
    abstract override def put(x: Int): Unit =
      {
        println("In filtering method .... ")
        if (x > 0) super.put(x)
      }
  }


  //Given these modifications we can pick and choose which modification (functionality) we want to use for our class
  val queue2 = (new BasicIntQueue with Filtering with Incrementing)


  queue2.put(10)
  queue2.put(0)

  //Note the execution starts from right the left

  val queue3 = new BasicIntQueue with Incrementing with Filtering
  //The order of mixins is significant. (Once a trait is mixed into a class, you can alternatively call it a mixin.) Roughly speaking, traits further
  // to the right take effect first. When you call a method on a class with mixins, the method in the trait furthest to the right is called first. If that
  // method calls super, it invokes the method in the next trait to its left, and so on. In the previous example, Filtering's put is invoked first, so it
  // removes integers that were negative to begin with. Incrementing's put is invoked second, so it adds one to those integers that remain.

  queue3.put(10)
  queue3.put(0) // This will call filtering and then not call Incrementing and also not call the main method


}
