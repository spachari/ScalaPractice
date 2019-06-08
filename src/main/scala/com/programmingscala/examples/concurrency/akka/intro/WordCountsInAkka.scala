package com.programmingscala.examples.concurrency.akka.intro

//The parent actor will load each line from the file and then delegate to a child actor the task of counting the words in
// that line. When the child is done, it will send a message back to the parent with the result. The parent will receive
// the messages with the word counts (for each line) and keep a counter for the total number of words in the entire file,
// which it will then return to its invoker upon completion.

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import akka.util.Timeout

import scala.concurrent.duration.FiniteDuration

case class ProcessStringMsg(line : String)
case class StringProcessedMsg(words : Integer)

//The child actor
class StringCounterActor extends Actor {
  def receive = {
    case ProcessStringMsg(line) => {
      val wordsInLine = line.split(" ").length
      sender ! StringProcessedMsg(wordsInLine)
    }
    case _ => println("Error: message not recognized")
  }
}

//This actor has a very simple task: consume ProcessStringMsg messages (containing a line of text), count
// the number of words on the specified line, and return the result to the sender via a StringProcessedMsg message.
// Note that we have implemented our class to use the ! (“tell”) method to send the StringProcessedMsg message (i.e.,
// to send the message and return immediately).

//The parent actor
case class StartFileProcessMsg()

class WordCounterActor(filename : String) extends Actor {

  private var running = false
  private var totalLines = 0
  private var linesProcessed = 0
  private var result = 0
  private var fileSender : Option[ActorRef] = None

  def receive= {
    case StartFileProcessMsg() => {
      if (running) {
        println("Warning: duplicate start message received")
      }
      else {
        running = true
        fileSender = Some(sender) //here we are sending the actor value as Option[ActorRef]
        //WordCounterActor stores a reference to the sender in the fileSender instance variable (note that this is an
        // Option[ActorRef] rather than an Option[Actor] - see line 9). This ActorRef is needed in order to later access and
        // respond to it when processing the final StringProcessedMsg (which is received from a StringCounterActor child, as
        // described below).

        scala.io.Source.fromFile(filename).getLines().foreach { line =>
          context.actorOf(Props[StringCounterActor]) ! ProcessStringMsg(line)
          totalLines += 1
        }
      }
    }

    case StringProcessedMsg(words) => {
      result += words
      linesProcessed += 1
      if (linesProcessed == totalLines) {
        fileSender.map(_ ! result)
      }
  }

      //Received from a child StringCounterActor when it completes processing the line assigned to it.
    //When received, the WordCounterActor increments the line counter for the file and, if all lines in the file have
    // been processed (i.e., when totalLines and linesProcessed are equal), it sends the final result to the original
    // fileSender (lines 28-31).

    case _ => println("message not recognized!")
  }
}



object WordCountsInAkka extends App {

  import akka.pattern.ask
  import scala.concurrent.ExecutionContext.Implicits.global

  val fileName = "/Users/spachari/IdeaProjects/untitled3/src/main/scala/com/programmingscala/examples/concurrency/akka/AkkaTheory.scala"
  val system = ActorSystem("Akka")
  val actor = system.actorOf(Props(new WordCounterActor(fileName)))


  implicit val timeout = Timeout(FiniteDuration(25L, "seconds"))

  val future = actor ? StartFileProcessMsg()

  future.map { result =>
    println("Total number of words " + result)
    system.terminate()
  }

}
