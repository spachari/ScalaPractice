package com.programmingscala.examples.concurrency.akka.pgmscalaex

import scala.util.Try

object Messages {

  sealed trait Request {
    val key : Long
  }

  case class Create(val key : Long, value : String) extends Request
  case class Update(val key: Long, value : String) extends Request
  case class Read(val key : Long) extends Request
  case class Delete(val key : Long) extends Request

  case class Response(result : Try[String])
  case class Crash(whichOne : Int)
  case class Dump(whichOne : Int)
  case object DumpAll

}
