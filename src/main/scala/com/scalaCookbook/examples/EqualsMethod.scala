package com.scalaCookbook.examples

class MyPerson(val name : String, age: Int) {

  var this_name : String = _
  def canEquals(s : Any) = s.isInstanceOf[MyPerson]

  def setName (s : MyPerson) = { this_name = this.name }

  def getName = name

  override def equals(that : Any) =
    {
      //println(this.hashCode())
      //println(that.hashCode())
      that match {
        case that : MyPerson => that.canEquals(this) && this.hashCode() == that.hashCode() //hashcode is the same for different objects
        case _ => false
      }
    }

  override def hashCode(): Int = {
    val prime = 31
    var result = 1
    result = prime * result + age
    result = prime * result + (if (name == null) 0 else name.hashCode)
    return result
  }



  def nameEquals (that : MyPerson) = {
    println(this.name)
    println(that.name)
    that match {
      case that : MyPerson => this.name == that.name
    }
  }
}

object EqualsMethod extends App {
  val a = new MyPerson("Srinivas", 10)
  println(a.equals(a))

  val b = new MyPerson("Srinivas", 10)
  println(a.equals(b)) //because their hashcode is different

  println(a.getName == b.getName)
  println(a.nameEquals(b))

  val nimoy = new MyPerson("Leonard Nimoy", 82)
  val nimoy2 = new MyPerson("Leonard Nimoy", 82)
  val shatner = new MyPerson("William Shatner", 82)
  val ed = new MyPerson("Ed Chigliak", 20)

  println(nimoy == nimoy)
  println(nimoy == nimoy2)
  println(nimoy != shatner)

}
