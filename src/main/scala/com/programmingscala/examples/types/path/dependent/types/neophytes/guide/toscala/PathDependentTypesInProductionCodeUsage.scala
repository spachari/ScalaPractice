package com.programmingscala.examples.types.path.dependent.types.neophytes.guide.toscala

case class Person(name : String)
case class Student(name : String)

object AmazonDB {
  abstract class Key(name : String) {
    type Value

    override def toString: String = s"$name"
  }
}

class AmazonDB {

  import com.programmingscala.examples.types.path.dependent.types.neophytes.guide.toscala.AmazonDB.Key

  var data = scala.collection.mutable.Map[Key, Any]()
  //Note: You can only access inner class values via the instance i.e. key.Value and not Key.Value
  def get(key : Key) : Option[key.Value] = data.get(key).asInstanceOf[Option[key.Value]]
  def set(key : Key) (value : key.Value) = data.update(key,value)

  //Note: This will not work.
  //def set1(key : Key, value : key.Value) = data.update(key,value)
}

trait IntValue extends AmazonDB.Key {
  override type Value = Int
}

trait StringValue extends AmazonDB.Key {
  override type Value = String
}


trait PersonValue extends AmazonDB.Key {
  override type Value = Person
}

trait StudentValue extends AmazonDB.Key {
  override type Value = Student
}


object Keys {
  import com.programmingscala.examples.types.path.dependent.types.neophytes.guide.toscala.AmazonDB.Key

  val int = new Key("Int") with IntValue
  val string = new Key("String") with StringValue


}

object PathDependentTypesInProductionCodeUsage extends App {

  import com.programmingscala.examples.types.path.dependent.types.neophytes.guide.toscala.AmazonDB.Key

  val int = new Key("Int") with IntValue
  val string = new Key("String") with StringValue

  val amazonDB = new AmazonDB
  amazonDB.set(int)(2)
  amazonDB.set(string)("Srinivas")

  println(amazonDB.get(Keys.int))

  //Let's implement a key value store for Person and Student
  val person = new Key("person") with PersonValue
  val studnet = new Key("student") with StudentValue

  amazonDB.set(person)(new Person("Srinivas"))
  amazonDB.set(studnet)(new Student("Srinivas"))

  amazonDB.data.foreach{ case (x,y) => println("key is " + x + " value is " + y)}
  println(amazonDB.get(person))
  
}
