abstract class IntQueue {
  def put (i : Int)
  def get() : Int
}

import scala.collection.mutable.ArrayBuffer

class BasicIntQueue extends IntQueue {
  private val buf = new ArrayBuffer[Int]

  override def put(i: Int): Unit = {buf += i }
  override def get() = buf.remove(0)
}

trait Doubling extends IntQueue {
  abstract override def put (x : Int ) = {super.put(2 * x) }
}

trait Incrementing extends IntQueue {
  abstract override def put (x : Int ) = {super.put(x + 1)}
}

trait Filtering extends IntQueue {
  abstract override def put (x : Int) = {
    if (x > 0)
      super.put(x)
  }
}

class MyQueue extends BasicIntQueue with Doubling

object BufferMain{
  def main(args: Array[String]): Unit = {
    val intBuffer = new BasicIntQueue

    intBuffer.put(10)
    intBuffer.put(20)

    println(intBuffer.get())
    println(intBuffer.get())

    val myQueue = new MyQueue
    myQueue.put(10)
    myQueue.put(20)

    println(myQueue.get())
    println(myQueue.get())

    //this is stackable modifications to the class. We are stacking the methods for BasicIntQueue
    val myIncrFilterQueue = (new BasicIntQueue with Incrementing with Filtering)

    myIncrFilterQueue.put(10)
    myIncrFilterQueue.put(20)
    myIncrFilterQueue.put(-1)

    println(myIncrFilterQueue.get())
    println(myIncrFilterQueue.get())

    val myIncrDoubleQueue = (new BasicIntQueue with Incrementing with Doubling)

    myIncrDoubleQueue.put(20)
    println(myIncrDoubleQueue.get())
  }
}

