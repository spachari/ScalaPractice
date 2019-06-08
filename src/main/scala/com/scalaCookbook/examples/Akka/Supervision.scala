package com.scalaCookbook.examples.Akka

/*
import Checker.{BlackUser, CheckUser, WhiteUser}
import Recorder.NewUser
import Storage.AddUser
import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import akka.pattern.ask
import akka.util.Timeout


case class User(userName : String, email : String)

object Checker {
  sealed trait CheckMsg

  case class CheckUser(user : User) extends CheckMsg

  sealed trait CheckerResponse

  case class BlackUser(user : User) extends CheckerResponse
  case class WhiteUser(uesr : User) extends CheckerResponse

}

class Checker extends Actor {

  val blackList = List(
    User("Adam", "adam@gmail.com")
  )

  import Checker.CheckUser
  override def receive: Receive = {
    case CheckUser(user) if (user.userName == blackList.map(x => x.userName)) => {
      println(s"Checker: ${user} is in the blackList")
      sender() ! BlackUser(user)
    }
    case CheckUser(user) => {
      println(s"Checker: ${user} is in the whiteList")
      sender() ! WhiteUser(user)
    }
  }

}

object Storage {
  sealed trait StorageMsg

  case class AddUser(user : User) extends StorageMsg
}

class Storage extends Actor {

  var users = List.empty[User]

  override def receive: Receive = {
    case AddUser(user) => println(s"Storage ${user} added")
      users = user :: users
  }
}


class Recorder (checker: ActorRef, storage : ActorRef) extends Actor {
  import scala.concurrent.ExecutionContext.Implicits.global
  //case class NewUser(user : User)

  implicit val timeout = Timeout(5 seconds)

  def receive: Receive = {
    case NewUser(user) =>
      checker ? CheckUser(user) map {
        case WhiteUser(user) =>
          storage ! AddUser(user)
        case BlackUser(user) => println(s"Recorder: ${user} is in blacklist")
      }
  }
}


object Recorder {
  sealed trait RecordMsg

  case class NewUser(user : User) extends RecordMsg

  def props(checker : ActorRef, storage : ActorRef): Props = Props(new Recorder(checker, storage))
}


object TalkToActor extends App {

  val system = ActorSystem("talk-to-actor")

  val checker = system.actorOf(Props[Checker], "checker")

  val storage = system.actorOf(Props[Storage], "storage")

  val recorder = system.actorOf(Recorder.props(checker, storage),"recorder")

  recorder ! Recorder.NewUser(User("jon", "john@gmail.com"))

  Thread.sleep(100)

  system.terminate()

}
*/