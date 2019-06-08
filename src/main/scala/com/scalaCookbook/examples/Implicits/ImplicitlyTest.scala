package com.scalaCookbook.examples.Implicits

trait Show[T] { def show(t: T): String }
object Show {
  implicit def IntShow: Show[Int] = new Show[Int] { def show(i: Int) = i.toString }
  implicit def StringShow: Show[String] = new Show[String] { def show(s: String) = s }

  def ShoutyStringShow: Show[String] = new Show[String] { def show(s: String) = s.toUpperCase }
}

case class Person(name: String, age: Int)
object Person {
  implicit def PersonShow(implicit si: Show[Int], ss: Show[String]): Show[Person] = new Show[Person] {
    def show(p: Person) = "Person(name=" + ss.show(p.name) + ", age=" + si.show(p.age) + ")"
  }
}

object ImplicitlyTest extends App {

  //Simple explanation of implicit and implicitly

  def implicitly[T](implicit e: T): T = e
  //It is commonly used to check if an implicit value of type T is available and return it if such is the case.

  //Implicit is used to create a conversion
  implicit val a : String = "Srini" //define an implicit value of String

  println(implicitly[String]) //Search for an implicit value of type String and print it

  val p = Person("bob", 25)
  println(implicitly[Show[Person]].show(p))

  //THis will not work as Person does not have a show method
  //println(show(p))

  println(Person.PersonShow(si = implicitly, ss = Show.ShoutyStringShow).show(p))

}
