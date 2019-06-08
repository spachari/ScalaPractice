package com.programmingscala.examples.types

class Parent(val value : Int) {
  override def toString: String = s"this.getClass.getName${value}"
}

class Child(value : Int) extends Parent(value)

object LowerBoundsExampleInSome extends App {

  //The default syntax of getOrElse is

  //sealed abstract class Option[+A] extends Product with Serializable {
  //  ...
  //  @inline final def getOrElse[B >: A](default: => B): B = {...}
  //  ...
  //}

  val opt1 : Option[Parent] = Option(new Child(10)) //This works because Option[+T]. T is covariant
  val p1 : Parent = opt1.getOrElse(new Parent(10))

  val opt2 : Option[Parent] = Option[Parent](null) //Option[X](null) always returns None
  val p2a : Parent = opt2.getOrElse(new Parent(10))
  val p2b : Parent = opt2.getOrElse(new Child(10))

  val opt3 : Option[Child] = Option[Child](null)
  val p3a : Parent = opt3.getOrElse(new Parent(10))
  val p3b : Parent = opt3.getOrElse(new Child(10))

  //The moment we get a null, the compiler has an expectation that what you might have tried to pass is Upto Parent.
  //All combinations return a Parent value, as shown, although sometimes it is actually a Child subclass instance.

  //What if Some is anything else other than mentioned above
  case class Opt[A](val default : A = null) {
    def getOrElse(value : A) : A = if (value == null)  default else value
  }

  val opt : Opt[Parent] = Opt(new Parent(10))

  val pa1 = opt.getOrElse(new Parent(0))

  //what happens when we have a null
  val optParentnull : Opt[Parent] = Opt[Parent](null)
  val pa2 = optParentnull.getOrElse(new Parent(0))
  //val

  //val optChildNull : Opt[Parent] = Opt[Child](null)
  //val ca2 = optChildNull.getOrElse(new Child(0))

  val a1 : Parent = Opt(new Parent(10)).getOrElse(new Parent(10))

  //we cannot even assign this

  //1. We cannot assign val something : Parent = Opt(new Child)
  //2. We cannot getOrElse a Parent from a child

  //The following two will explain

  //val optChildNull : Opt[Parent] = Opt[Child](null).getOrElse(new Parent(10))
  //val optChildNull : Parent = Opt(new Child(10)).getOrElse(new Parent(10))

}
