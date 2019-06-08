package com.programmingscala.examples.implicits.implicitsAsExecutionContexts

import akka.actor.Actor
import com.programmingscala.examples.implicits.implicitsAsExecutionContexts.Messages.Response

object Messages {
  object Exit
  object Finished
  case class Response (message : String)
}

class ShapesDrawingActor extends Actor {

  import Messages._
  override def receive = {
    case shape : Shape => {
      shape.draw(str => println(s"spahesDrawingActor : ${str}"))
      sender ! Response(s"ShapesDrawingActor ${shape} drawn")
    }
    case Finished => {
      println("shapesDrawingActor finished")
      sender ! Finished
    }
    case unexpected => {
      val response = Response(s"Error: Response of unexpected message ${unexpected}")
      println(s"ShapesDrawingActor ${response}")
      sender ! response
    }
  }

}
