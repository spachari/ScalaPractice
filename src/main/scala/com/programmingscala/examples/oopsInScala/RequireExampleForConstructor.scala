package com.programmingscala.examples.oopsInScala

class ZipCode(zip : Int, extension : Option[Int] = None) {
  require(isValidZip(zip,extension), s"Not valid zip ${zip} and extension ${toString}")

  private def isValidZip(z : Int, extension : Option[Int]) : Boolean = {
    if (z > 0 && z < 9999) extension match {
      case Some(i) => 0 < i && i <= 9999 && isValidExtension(z, i)
      case None => isValidExtension(z, 0)
    }
    else false
  }

  private def isValidExtension(e : Int, f : Int) : Boolean = true

  override def toString: String = if (extension != None) s"${zip}-${extension.get}" else s"${zip}"
}

object ZipCode {
  def apply(zip : Int, extension : Option[Int] ) = {
    new ZipCode(zip, extension)
  }
}

object RequireExampleForConstructor extends App {

  val myZipCode = ZipCode(1234, Some(200))

  println(myZipCode)

  val myZipCode1 = try {
    ZipCode(12345, Some(12345))}
  catch {
    case e : IllegalArgumentException => s"Not valid zip $e"
  }

    println(myZipCode1)

}
