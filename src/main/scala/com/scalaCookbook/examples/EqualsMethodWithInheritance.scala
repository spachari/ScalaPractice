package com.scalaCookbook.examples



class MyEmployee(name : String, age : Int, var role : String) extends MyPerson(name, age)
{
  override def canEquals(s: Any): Boolean = s.isInstanceOf[MyEmployee]

  override def equals(that: Any): Boolean = that match {
    case p : MyEmployee => canEquals(p) && this.hashCode() == that.hashCode()
    case _ => false
  }

  override def hashCode(): Int = {
    val ourHash = if (role == null) 0 else role.hashCode
    super.hashCode() + ourHash
  }

}

object EqualsMethodWithInheritance extends App {
  val eNimoy1 = new MyEmployee("Leonard Nimoy", 82, "Actor")
  val eNimoy2 = new MyEmployee("Leonard Nimoy", 82, "Actor")
  val pNimoy = new MyPerson("Leonard Nimoy", 82)
  val eShatner = new MyEmployee("William Shatner", 82, "Actor")

  println(eNimoy1 == eNimoy2)
  println(eNimoy1 == pNimoy)

}
