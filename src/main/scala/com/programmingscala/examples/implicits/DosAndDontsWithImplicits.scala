package com.programmingscala.examples.implicits

object DosAndDontsWithImplicits extends App {

  //Rules for implicits
  //1. Only the last argument list, including the only list for a single-list method, can have implicit arguments.

  implicit object StringType
  implicit object IntegerType
  //This will not work because implicit is the second argument in the list
  /*
  class Bad1 {
    def m(s : Int, implicit s : StringType.type ) = println(s)
  }
  */

  //THis will not work because of two implicits
  /*
  class bad2 {
    def m(s : Int)(implicit s1 : StringType.type )(implicit s2 : IntegerType.type ) = {
      println(s)
    }
  }
  */

  //2. The implicit keyword must appear first and only once in the argument list.
  // The list can’t have “nonimplicit” arguments followed by implicit arguments.

  //3. All the arguments are implicit when the list starts with the implicit keyword.

  class Good1 {
    def m(s : Int)(implicit s1 : StringType.type , b : Int) = {
      s + b
    }
  }

  class Good2 {
    def m2(implicit s : String, s1 : Int) = {
      s + s1
    }
  }


}
