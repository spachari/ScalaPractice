class Student (var id : Int = 10000, var name : String = "class Default" , var age : Int) {

  def this(id : Int, name : String) {
    this(Student.id, Student.name, Student.age)
    println("Calling two argument constructor")
  }

  def this(id : Int) {
    this(id, Student.name)
    println("Calling one argument constructor")
  }

  def this() {
    this(Student.id, Student.name)
    println("Calling zero argument constructor")
  }

  override def toString: String = s"ID is $id and name is $name and age is $age"

}

object Student {
  val id : Int = 1
  val name : String = "Object default"
  val age : Int = 20
}






object auxillaryConstructorMain {
  def main(args: Array[String]): Unit = {
    println("new Student(1, \"Srinivas\", 20)")
    val s1 = new Student(1, "Srinivas", 20)
    println("================================================")
    println("new Student(2)")
    val s2 = new Student(2)
    println("================================================")
    println("new Student")
    val s3 = new Student

    println(s1)
    println(s2)
    println(s3)
  }
}
