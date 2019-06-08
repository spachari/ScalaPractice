package com.programmingscala.examples.concurrency.akka.intro

import akka.actor.Actor

class AkkaTheory {

  //What is Akka?

  //Akka is a toolkit and runtime for building highly concurrent, distributed, and fault tolerant applications on the JVM.
  // Akka is written in Scala, with language bindings provided for both Scala and Java.

  //Akka’s approach to handling concurrency is based on the Actor Model.
  // In an actor-based system, everything is an actor, in much the same way that everything is an object in object-oriented
  // design. A key difference, though – particularly relevant to our discussion – is that the Actor Model was specifically
  // designed and architected to serve as a concurrent model whereas the object-oriented model is not.

  //How does Akka simplyfy thread processing?
  //Akka creates a layer between the actors and the underlying system such that actors simply need to process messages.
  // All the complexity of creating and scheduling threads, receiving and dispatching messages, and handling race conditions
  // and synchronization, is relegated to the framework to handle transparently.

  /*
  Akka strictly adheres to the The Reactive Manifesto. Reactive applications aim at replacing traditional multithreaded
  applications with an architecture that satisfies one or more of the following requirements:

  Event-driven. Using Actors, one can write code that handles requests asynchronously and employs non-blocking operations
  exclusively.

  Scalable. In Akka, adding nodes without having to modify the code is possible, thanks both to message passing and location
  transparency.

  Resilient. Any application will encounter errors and fail at some point in time. Akka provides “supervision”
  (fault tolerance) strategies to facilitate a self-healing system.

  Responsive. Many of today’s high performance and rapid response applications need to give quick feedback
  to the user and therefore need to react to events in an extremely timely manner. Akka’s non-blocking, message-based
  strategy helps achieve this.

   */

  //What is an Actor in Akka?

  //It is nothing but an object that receivies a message and takes actions based on them.
  //It is decoupled from the source of the message and its only responsibility is to receive message and
  //identify the type of the message it has received and take action based on them.

  //Upon receiving a message an actor can do one or more of the following:

  //1. Execute some operations itself (such as performing calculations, persisting data, calling an external webserver and so on)

  //2. Forward the message, or a derived message to another actor

  //3. Instantiate a new Actor and forward the message to it

  //4. Just ignore the message if that is what it is supposed to do so.


  //To implement an Actor, it is necessary to extend the akka.actor.Actor trait and implement it's receive method.

  //An actor's receive method is invoked by Akka when a new message is received by that Actor. It's typical implementation consists of
  //pattern matching and identify the type of the message and take actions accordingly.




}


class MyActor extends Actor {

  def doSomething(x : String) = ???

    def receive = {
      case value : String => doSomething(value)
      case _ => println("unknown message received")
    }


}

//Note that pattern matching makes code easier to read and navigate and also makes it easier to notice which cases are being considered and
//how each are being handled


//The Actor System

//Taking a complex problem and relatively splitting them into smaller sub-problems is a sound problem solving technique in general
//This apporach tends to result in clean, modulariszed code that is easy to maintain and reduce redundancy, that is relatively
//easy to maintain.

//In an actor based system, use of this technique facilitates the logical organization of actors into a hierarchical structure called Actor System.
//The actor system provides the infrastructure through which Actors interact with one another.


//ActorRef

//In Akka, the only way to communicate to an actor is through an ActorRef.
// An ActorRef represents a reference to an actor that prevents other objects from directly accessing the actor's
//state and modfying the internals and specifically state.

//Messages can be sent to an Actor via an ActorRef through the folliwng protocols
//1. tell - sends the message and returns immedietely
//2. ask - sends the message and returns a Future - representing a possible value

//Each actor has a mailbox through which incoming messages are delivered. There are multiple implementations to choose from,
//the default is FIFO

//An actor contains many instance variables to maintain state while processing multiple messages.
//Akka ensures that each Actor has it's own light weight thread and messages are processed oen at a time.
//In this way each actor's state can be reliably maintained wihtout the developer needing to worry about race conditions or synchronization

//Each Actor is provided with the following useful information for performing it's tasks via the Actor API:

//sender : an ActorRef to the sender of the message currently being processed.

//context : information and methods relating to the context of within which the actor is running (includes, for example, an actorOf method
// for instantiating a new actor)

//supervisionStrategy : defines the supervision strategy to be used when recevering from errors.

//self : an ActorRef for the Actor itself

