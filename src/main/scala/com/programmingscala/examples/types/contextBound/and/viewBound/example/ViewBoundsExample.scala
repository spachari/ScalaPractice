package com.programmingscala.examples.types.contextBound.and.viewBound.example




//View Bound - the implicit value for A : B had to be of type B[A]
//Context Bound - implicit function that converts an A to a B. We say that “B is a view onto A.” Also, contrast with a upper
// bound expression A <: B, which says that A is a subtype of B. A view bound is a looser requirement. It says that A must be
// convertable to B.
object Serialization {
  case class Writer (value : Any) {
    def serialized : String = s"-- $value --"
  }

  implicit def fromInt(i : Int) = Writer(i)
  implicit def fromDouble(d : Double) = Writer(d)
  implicit def fromString(s : String) = Writer(s)
}


object RemoteConnection extends App {

  import com.programmingscala.examples.types.contextBound.and.viewBound.example.Serialization.Writer

  def write [T <% Writer](t : T) = {
    println(t.serialized)
  }

  write(10)
  write("Srinivas")
  write(10.0)
  //write(10F) wont work

}
