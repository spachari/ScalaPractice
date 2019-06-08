package com.programmingscala.examples.implicits

import scala.util.parsing.json.JSONObject

case class myJson(key : String, value : String)

object MakeJson {
  implicit class makeJsonForStringContext(val sc : StringContext) {
    def json(value : Any*) = {
      val keyRE = """^[\s{,]*(\S+):\s*""".r
      val test = sc.parts(1)
      val keys = sc.parts map {
        case keyRE(key) => key
        case str => str
      }
      println(s"Key is ${keys}" )

      val kvs = keys zip value
      println(s"kvs is ${kvs}")
      JSONObject(kvs.toMap)
    }
  }
}

object ImplicitJsonParser extends App {

  import MakeJson._

  val name = "Martin"
  val book = "Programming Scala"

  val output = json"{name: ${name},book: ${book}}"

  println(output)
  println(output.getClass)


  //Simple StringContext example

  val keyRE = """^[\s{,]*(\S+):\s*""".r
  val sc1 = StringContext("Srinivas","Pachari").parts(0)

  println(sc1)


}


