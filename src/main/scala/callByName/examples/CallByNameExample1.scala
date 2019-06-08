package callByName.examples

import java.io.File

import scala.io.Source
import scala.util.control.NonFatal

object manage {
  def apply[R <: {def close() : Unit}, T](resource: => R)(func: R => T) = {
    var res: Option[R] = None

    try {
      res = Some(resource)
      func(res.get)
    }
    catch {
      case NonFatal(ex) => println("Cannot open file")
        throw ex
    }
    finally {
      if (res != None) {
        println(s"Closing resource...")
        res.get.close
      }
      res
    }
  }
}

object CallByNameExample1 {
  def main(args : Array[String]) = {
    val sizes = args map( arg => returnFileLength(arg))
    println(sizes.mkString(","))
  }

  def returnFileLength(s : String) = {
    manage(Source.fromFile(s)) { source =>
        val size = source.getLines.size
      if (size >= 200) {
          throw new Exception("Big file exception")
        }
      size
    }
  }

}


