package com.programmingscala.examples.implicits.implicitsAsExecutionContexts

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import com.typesafe.config.ConfigFactory



private object Start
object ShapesDrawingDriver {

  def main(args: Array[String]): Unit = {
    val system = ActorSystem("DrawingActorSystem", ConfigFactory.load())
    val drawer = system.actorOf(Props(new ShapesDrawingActor), "drawingActor")
    val driver = system.actorOf(Props(new ShapesDrawingDriver(drawer)), "startingdriver")
    driver ! Start
  }

}

class ShapesDrawingDriver(drawerActor : ActorRef) extends Actor {

  import Messages._

  override def receive = {
    case Start =>
      {
        drawerActor ! Circle(Point(0.0, 0.0),1.0)
        drawerActor ! Rectangle(Point(0.0,0.0), 2, 5)
        drawerActor ! 3.14159
        drawerActor ! Triangle(Point(0.0,0.0), Point(2.0,0.0), Point(1.0,2.0))
        drawerActor ! Exit
      }
    case Finished => {
      println("*** Terminating actor system ...")
      context.system.terminate()
    }
    case response : Response => {
      println(s"*** Response is ${response}")
    }
    case unexpected =>                                               9
      println("*** ShapesDrawingDriver: ERROR: Received an unexpected message = "
        + unexpected)
  }
}

