package com.scalaCookbook.examples.Implicits

import com.scalaCookbook.examples.Implicits.ImplicitlyTest.implicitly

trait Add[T] { def add (i : T) : Int }

object Add {
  implicit def Add10 : Add[Int] = new Add[Int] { def add(i : Int) = { i + 100}}
}

case class IntAdds (i : Int)

object IntAdds {
  implicit def intadds(implicit si : Add[Int]) : Add[Int] = {
    new Add[Int] {
      def add(j : Int) : Int = si.add(j)
      //override def add(i: Int) = ???
    }
  }
}

/*
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
*/

object ImplicitExample2 extends App {

  //val p = Person("bob", 25)
  //println(implicitly[Show[Person]].show(p))

  val i = IntAdds(10)
  println(implicitly[Add[Int]])

}
