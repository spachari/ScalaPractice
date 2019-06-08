package com.programmingscala.examples.types.typeProjections

trait Logger {
  def log(message : String) : Unit
}

class ComponentLogger extends Logger {
   def log(message: String): Unit = println(s"message is ${message}")
}

//A Service trait that defines an abstract type alias for the Logger and declares a field for it.
trait Service {
  type log <: Logger
  val logger : log
}

/*
object Service {
  val logger = new ComponentLogger
}
*/


class ServiceLogger extends Service {
  type log = ComponentLogger
  override val logger : ComponentLogger = new ComponentLogger
}

object FixingTheIssueWithTypeProjections extends App {

  //val l1 : Service.Log = new ComponentLogger
  //Does nto work

  //val l2 : ServiceLogger.Log = new ComponentLogger

  //val l3 : Service#Logger = new ComponentLogger



  //Note: Using Service.Log and ServiceLogger.Log means that the compiler looks for an object named Service and
  //SeriveLogger, but their companion object does not exist.

  //That is what "class." means

  //These attempts Service.Log and ServiceLogger.Log dont type check
  //Although the Service.Log and ComponentLogger are both subtypes of Logger,
  //Service.Log is abstract, so we dont know if it will be a supertype of ComponentLogger
  //

  //To proove the above theory, comment out the object Service and see for yourself
  //val service = Service.logger

  val l4 : ServiceLogger#log = new ComponentLogger
  //The only one that works is this because it type checks statically
}
