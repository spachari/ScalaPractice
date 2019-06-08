package com.programmingscala.examples.patternmatching

sealed abstract class HttpMethod {
  def body : String
  def bodyLength = body.length
}

case class Connect(body : String) extends HttpMethod
case class Delete(body : String) extends HttpMethod
case class Get(body : String) extends HttpMethod
case class Head(body : String) extends HttpMethod
case class Options(body : String) extends HttpMethod
case class Post(body : String) extends HttpMethod
case class Put(body : String) extends HttpMethod
case class Trace(body : String) extends HttpMethod

//Two things to note
//1. If an abstract class has a no-argument method like
  //def body : String
  //it can be overridden by a val by passing it in the constructor
  //case class Connect(body : String) extends HttpMethod


//2. if You have a small class like this, avoid Enumerations and use this way. We can tell if the match is exhaustive
//by looking at the class

object PatternMatchingInSealedCaseClasses extends App {

  def method(httpMethod : HttpMethod) = httpMethod match {
    case c : Connect => println(s"connect : (length ${httpMethod.bodyLength}) ${c.body}")
    case c : Delete => println(s"connect : (length ${httpMethod.bodyLength}) ${c.body}")
    case c : Get => println(s"connect : (length ${httpMethod.bodyLength}) ${c.body}")
    case c : Head => println(s"connect : (length ${httpMethod.bodyLength}) ${c.body}")
    case c : Options => println(s"connect : (length ${httpMethod.bodyLength}) ${c.body}")
    case c : Post => println(s"connect : (length ${httpMethod.bodyLength}) ${c.body}")
    case c : Put => println(s"connect : (length ${httpMethod.bodyLength}) ${c.body}")
    case c : Trace => println(s"connect : (length ${httpMethod.bodyLength}) ${c.body}")
  }

  val seq = Seq(Connect("Connect ..."),
                Delete("Delete ... "),
                Get("Get ... "),
                Head("Head ... "),
                Options("Options ..."),
                Post("Post ... "),
                Put("Put ... "),
                Trace("Trace ..."))

  for (s <- seq) {
    method(s)
  }

}
