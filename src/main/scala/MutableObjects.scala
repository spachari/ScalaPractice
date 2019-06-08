class Account {
  var balance : Int = 0

  def deposit (amt : Int) : Int = {
    balance += amt
    balance
  }

  def withDrawal (amt : Int) : Option[Int] = {
    if (balance - amt <= 0)
      {
        println("Cannot get " + amt + " out of Balance " + balance)
        None
      }
    else
      {
        balance = balance - amt
        Some(balance)
      }
  }

  def getBalance (int : Option[Int]) = int match {
    case Some(x) => x
    case None => 0
  }
}

class Time {
  private[this] var hr : Int = _
  private[this] var min : Int = _
  private[this] var sec : Int = _

  def getHr = hr
  def setHr (x : Int) : Unit = {
    require(0 < x && x < 24)
    hr = x
  }

  def getMin = min
  def setMin (x : Int) : Unit = {
    require(0 < x && x < 60)
    min = x
  }

  def getSec = sec
  def setSec (x : Int) : Unit = {
    require(0 < x && x < 60)
    sec = x
  }

  override def toString: String = hr + ":" + min + ":" + sec
}

class VarTest {
  var h : Int = 10
}




class SlowAppendQueue[T] (list : List[T]) {
  def head = list.head
  def tail = new SlowAppendQueue(list.tail)
  def enqueue(x : T) = new SlowAppendQueue(list ::: List(x))
}

//Everything is reversed
class SlowHeadQueue[T] (list : List[T]) {
  def head = list.last
  def tail = new SlowHeadQueue[T](list.init)
  def enqueue(x : T) = new SlowHeadQueue[T](x :: list)
}






class Queue1[T] (leading : List[T], trailing : List[T]) {
  def mirror = if (leading.isEmpty)
    new Queue1(leading.reverse, Nil)
  else
    this

  def head = leading.head

}

trait Queue[T] {
  def head : T
  def tail : Queue[T]
  def enqueue(x : T) : Queue[T]
}

object Queue {

  def apply[T](xs : T*) : Queue[T] = new QueueImpl(xs.toList, Nil)

  private class QueueImpl[T] (private val leading : List[T], private val trailing : List[T]) extends Queue[T] {
    def mirror = if (leading.isEmpty)
      new QueueImpl(trailing.reverse, Nil)
    else
      this
    def head: T = mirror.leading.head
    def tail: QueueImpl[T] = {
      val q = mirror
      new QueueImpl[T](q.leading.tail, q.trailing)
    }
    def enqueue(x : T) = new QueueImpl[T](leading, x :: trailing)
  }
}

//Significance of this

class Cell [T](init: T) {
  private[this] var value : T = init
  def get = value
  def set (x: T) = { value = x }
}

object MutableObjects {
  def main(args: Array[String]): Unit = {
    val a = new Account
    a.deposit(100)
    val b = a.withDrawal(10)
    val output = a.getBalance(b)
    println(output)

    val t = new Time
    t.setHr(11)
    t.setMin(15)
    t.setSec(20)
    println(t)

    val test = new VarTest
    test.h = 100
    println(test.h)

    //Queue class
    val q = new SlowAppendQueue(List(1,2,3,4))
    val x = q.enqueue(5)
    println(x.toString)

    val z = Queue[Int](1,2,3)

    val z1 = new Queue1(List(1,2,3), List(1,2,3))

    val c = new Cell[Int](2)
    println(c.get)

    val l = List(1,2,3,4)
    for (i <- l)
      {
        println(i)
      }
    l.foreach(println)

  }
}
