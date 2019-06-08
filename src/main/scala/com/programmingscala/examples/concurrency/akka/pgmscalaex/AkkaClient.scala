package com.programmingscala.examples.concurrency.akka.pgmscalaex

/*
class AkkaClient {

  private var system : Option[ActorSystem] = None

  def main(args: Array[String]): Unit = {
    processArgs(args)
    val sys = ActorSystem("AkkaClient")
    system = Some(sys)

    val server = ServerActor.make(sys)
    val numberOfWorkers = sys.settings.config.getInt("server.number-workers")

    server ! Start(numberOfWorkers)
    processInput(server)
  }

  private def processArgs(args : Seq[String]) = args match {
    case Nil =>
    case("-h" | "--help") +: tail => exit(help, 0)
    case head :+ tail => exit(s"Unknown input $head!\n"+help, 1)
  }

  private def processInput(server : ActorRef) = {

  }



}
*/