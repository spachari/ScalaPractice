package com.programmingscala.examples.oopsInScala

class Name (value : String)

//Is internally converted to

class Names(s : String) {
  private var  _value : String = s //Invisible field protected by class

  def value : String = _value      //getter

  def value_=(newValue : String) : Unit = { //setter Ignore the syntax and do not ask why there is no : in between
    // "=" and "("  in value_=(newValue : String)
    _value = newValue
  }

}

//s String is not a field. In class Names(s : String)
//s is available to the entire body

//Note: Whether or not the constructor arguments are declared as fields with val or var, the arguments are visible in the entire
// class body. Hence they can be used by members of the type, such as methods. Compare with constructors as defined in Java and
// most other OO languages. Because the constructors themselves are methods, the arguments passed to them are not visible outside
// those methods. Hence, the arguments must be “saved” as fields, either public or hidden.

object WHatHappensInsideAVar extends App {

  val name = new Names("Srinivas")

  println(name.value)

  name.value_=("Sadhana")

  println(name.value)

  name.value = "Sadhiv"

  println(name.value)


}
