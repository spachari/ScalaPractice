package com.programmingscala.examples.oopsInScala

//The inheriting class's constructor should extend atleast one constructor from the primary class
//In this case, because we have default's Employee can inherit
//1. extends Person3(name : String, age : Option[Int], address : Option[Address1])
//2. extends Person3(name : String, age : Option[Int])
//3. extends Person3(name : String)

case class Person3(name : String, age : Option[Int] = None, address : Option[Address1] = None)

class Employee(name : String,
               age : Option[Int] = None,
               address : Option[Address1] = None,
               val title : String = "[Unknown]",
               val manager : Option[Employee] = None
              ) extends Person3(name : String, age : Option[Int], address : Option[Address1]) {
  override def toString: String = s"$name $address $title $manager"
}
//In Java, we would define constructor methods and call super in them to invoke the parent class initialization logic.
// In Scala, we implicitly invoke the parent class constructor through the ChildClass(…) extends ParentClass(…) syntax.


object InheritanceInScala extends App {

  val a1 = new Address1(21, "Buckfast Road", Some("Morden"))

  val a2 = new Address1(21, "Bombay Street", Some("Mumbai"))

  val person3 = Person3("Srinivas", Some(37), Some(a1))

  val srini = new Employee( "Srinivas", Some(37), Some(a1), "Developer")

  val torq = new Employee("Toqruil", Some(45), Some(a2), "Manager", Some(srini))

}
