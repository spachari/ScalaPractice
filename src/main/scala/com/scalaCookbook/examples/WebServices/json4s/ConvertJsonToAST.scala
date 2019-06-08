package com.scalaCookbook.examples.WebServices.json4s


//:require /Users/spachari/.m2/repository/org/json4s/json4s-core_2.11/3.2.11/json4s-core_2.11-3.2.11.jar
//:require /Users/spachari/.m2/repository/org/json4s/json4s-core_2.11/3.2.11/json4s-core_2.11-3.2.11-sources.jar
//:require /Users/spachari/.m2/repository/org/json4s/json4s-ast_2.11/3.2.11/json4s-ast_2.11-3.2.11.jar
//:require /Users/spachari/.m2/repository/org/json4s/json4s-ast_2.11/3.2.11/json4s-ast_2.11-3.2.11-sources.jar
//:require /Users/spachari/.m2/repository/org/json4s/json4s-jackson_2.11/3.2.11/json4s-jackson_2.11-3.2.11.jar
//:require /Users/spachari/.m2/repository/org/json4s/json4s-jackson_2.11/3.2.11/json4s-jackson_2.11-3.2.11-sources.jar
//:require /Users/spachari/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.7.8/jackson-databind-2.7.8.jar



import org.json4s._
import org.json4s.JsonDSL._ //The render in this one will work on scala objects
import org.json4s.native.JsonMethods._


case class Attribute_Metadata(
                               name : String,
                               `type` : String,
                               team : String,
                               createdBy : String,
                               lastLoadedAt : String,
                               lastLoadedBy : String,
                               isActive : Boolean,
                               createdAt : String,
                               updatedAt : String
                             )

//Converting a jsn value into native AST

object ConvertJsonToAST extends App {

  val json = """ { "numbers" : [1, 2, 3, 4] } """

  implicit val formats = DefaultFormats

  implicit val formats1 = DoubleJsonFormats

  val output = parse(json)

  println(output)
  println(output.children.map(x => x))


 case class ToyPrice(name : String, price : BigDecimal)

  val json1 = """{"name":"Toy","daddyName":"","price":35.35}"""

  val output1 = parse(json1, useBigDecimalForDouble = true)

val daddyName = output1 \ "daddyName"

  println("**** daddyName " + Some(daddyName.values.toString))


  println(output1 \ "daddyName")


  //Converting objects into json
  //Any seq produces JSON array.

  val json3 = List(1,2,3)
  println(compact(render(json3)))

  //Tuple2[String, A] produces field.
  val json4 = ("name" -> "Srinivas")
  println(compact(render(json4)))

  //~ operator produces object by combining fields.
  val json5 = ("name" -> "Srinivas") ~ ("age" -> 35)
  println(compact(render(json5)))

  //Any value can be optional. The field and value are completely removed when it doesn't have a value.
  val json6 = ("name" -> "Srinivas") ~ ("age" -> Some(35))
  println(compact(render(json6)))

  val json7 = ("name" -> "Srinivas") ~ ("age" -> (None: Option[Int]))
    println(compact(render(json7)))

  //What this means is let's say we have an object
  case class Person(name : String, age : Option[Int])
  val person = Person("Srinivas", None)

  val myJson = ("person" ->
    ("name" -> person.name) ~
      ("age" -> person.age))

  //Simple functor example
  def multiply(x : Option[Int]) : Int = {
    val output = x.getOrElse(0) * 10 //Here you are getting it from the
    output
  }


  case class Student (name : String, id : String, age : Int, url : String, average : Double)
  //Let's say we want to create a json with 3 items
  val studentJson1 = ("Student" ->
    ("name" -> "luca") ~
      ("id" -> "1befrd3") ~
      ("age" -> 26) ~
      ("url" -> "www.yahoo.com"))

  println(pretty(render(studentJson1)))

  //Let's do the same thing with an object
  val s = Student("Srinivas", "id1234sdf", 26, "www.yahoo.com", 100.5)
  var srinivas = ("Student" ->
    ("name" -> s.name) ~
      ("id" -> s.id) ~
      ("age" -> s.age) ~
      ("url" -> s.url))

  //If we have a string, we can use parse
  var stringToJson = parse("""{"name":"luca", "id": "1q2w3e4r5t", "age": 26, "url":"http://www.nosqlnocry.wordpress.com"}""")

  //Add items to json
  var srinivas1 = srinivas ~ ("school" -> "P.K.N Higher Secondary School")
  println(compact(render(srinivas1)))

  val transformJson = srinivas1.transformField {
    case JField("name", _) => ("NAME", JString("Srinivas Pachari"))
    case JField("age", JInt(age)) => ("age", age + 10)
  }

  println(compact(render(transformJson)))

  val removedJson = srinivas1.removeField {
    case JField("name", _) => true
    case _ => false
  }

  println(compact(render(removedJson)))

  //To retrieve a particular field
  println((transformJson \\ "age"))

  println(transformJson \ "age")

  println(stringToJson \ "name")

  val name = stringToJson \ "average"

  println(name.extractOpt[Double])

  val attrbute = """{"name":"test_attribute_1","type":"boolean","team":"HDE CAS","createdBy":"bob","lastLoadedAt":"2019-05-01T08:00:00.000Z","lastLoadedBy":"vedant","isActive":false,"createdAt":"2019-05-21T10:15:16.000Z","updatedAt":"2019-05-21T10:15:16.000Z"}"""

  println(parse(attrbute).extract[Attribute_Metadata])
}
