package com.scala.FPS

//We are modelling state after each stroke
//Create a case class to model the existing state
case class GameState (strokes : List[Int])

object ManuallyHandlingState extends App {

  //Create a increment function that will take an existing state and an increment value and return a new state based on these values
  def incrementState(state : GameState, distance : Int) : GameState = {
    val newDistance = List(distance) ::: state.strokes
    GameState(newDistance)
  }

  val state = GameState(Nil)
  val state1 = incrementState(state, 15)
  val state2 = incrementState(state1, 30)
  val state3 = incrementState(state2, 0)

  println(s"State = ${state.strokes}")
  println(s"State1 = ${state1.strokes}")
  println(s"State2 = ${state2.strokes}")
  println(s"State3 = ${state3}")

  def push[A](xs : List[A], x : A) = x :: xs

  val s1 = Nil
  val s2 = push(s1, 10)
  val s3 = push(s2, 15)
  val s4 = push(s3, 30)

  println(s4)

  def pop[A](xs : List[A]) : (A, List[A]) = (xs.head, xs.tail)


  println(pop(s4))
  println(pop(s3))
  println(pop(s2))

  val (swing, s5) = pop(s4)
  println(s"Swing = ${swing}, state = ${s5}")
}
