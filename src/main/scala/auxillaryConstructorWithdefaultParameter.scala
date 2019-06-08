class FamilyMember (var id : Int, var name : String,var age : Int) {

  def this(name : String, age : Int) {
    this(FamilyMember.DEFAULTFID, name, age)
  }

  def this(name : String) {
    this(FamilyMember.DEFAULTFID, name, FamilyMember.DEFAULTAGE)
  }



  override def toString: String = s"His name is $name and his age is $age"
}

object FamilyMember {
  val DEFAULTFID = 1000
  val DEFAULTAGE = 0
}

object auxillaryConstructorWithdefaultParameter {
  def main(args: Array[String]): Unit = {
    val p = new FamilyMember(1, "Srinivas", 30)
    println(p)

    val e = new FamilyMember("Sadhana", 5)
    println(e)

    val f = new FamilyMember("Sadhiv")
    println(f)
  }
}
