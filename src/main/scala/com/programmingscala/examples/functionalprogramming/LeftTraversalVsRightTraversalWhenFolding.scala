package com.programmingscala.examples.functionalprogramming

import com.programmingscala.examples.functionalprogramming.LeftTraversalVsRightTraversalWhenFolding.outputReduceRight

import scala.annotation.tailrec
import scala.math.BigInt

object LeftTraversalVsRightTraversalWhenFolding extends App {

  val facLeft = (accumulator : Int, item : Int) => accumulator + item

  val facRight = (item : Int, accumulator : Int) => item + accumulator

  val list = List(1,2,3,4,5)

  val outputFoldLeft = list.foldLeft(0)( facLeft )

  val outputFoldRight = list.foldRight(0)( facRight )

  println(outputFoldLeft)

  println(outputFoldRight)

  val accLeft = (accumulator : String, item : String) => {
    println(s"(${accumulator})-(${item})")
    s"(${accumulator})-(${item})"
  }

  val accRight = (accumulator : String, item : String) => {
    println(s"(${item})-(${accumulator})")
    s"(${item})-(${accumulator})"
  }

  val outputReduceLeft = list.map(_.toString) reduceLeft {
    println("Inside accLeft ... ")
    accLeft
  }

  val outputReduceRight = list.map(_.toString) reduceLeft {
    println("Inside accRight ... ")
    accRight
  }

  println(outputReduceLeft)


  println(outputReduceRight)

  //For each line in the reduceRight sequence, the outermost addition (1 + …) can’t be performed until all of the nested
  // additions finish, so the operation can’t be converted to a loop and it isn’t tail recursive.
  val outputReduceRight1 = list.map(_.toString).reduceRight(accLeft)

  println(outputReduceRight1)

  //On the other hand we can convert the reduceLeft to a tail recursive because (1)-(2) is processed and then the last call is
  //to item 3 and next time ((1)-(2))-(3) is processed and the call goes to 4

  //To further this, let's write our own reduceLeft function

  def traverseLeft[A,B](list : Seq[A])(f : A => B) : Seq[B] = {
    @tailrec
    def traverse(accum : Seq[B], list : Seq[A]): Seq[B] = list match {
      case Nil => accum
      case head :: tail => {
        println(s"${head} + ${tail}")
        traverse(f(head) +: accum, tail) //This is the last call
      }
    }

    traverse(Seq.empty[B], list)
  }

  val traverseLeftOutput =  traverseLeft(list)(i => i * 2)

  println(traverseLeftOutput)

  def traverseRight[A,B](list : Seq[A])(f : A => B) : Seq[B] = list match {
    case head :: tail => {
     println(s"for head ${head} = ${f(head)} + ${traverseRight(tail)(f)}")
      f(head) +: traverseRight(tail)(f)
    }
    case _ => Seq.empty[B]
  }

  val traverseRightOutput = traverseRight(list)(i => i * 2)

  println(traverseRightOutput)

  //Note;
  //1. Left traversal can do tail recursion whilst right cannot
  //2. Left traversal reverses the order so that means we need to do two traversals 1. calculate and 2. reverse
  //3. So if we are not worried about stackoverflow foldRight seems like the correct choice.
  //4. But the main advantage of right traversal is it's ability to be used in streams

  //Right traversals in streams
  //In an infinite stream, we cannot store all infinite streams in one go.
  //We might just want to process N elements at a time. By infinite stream, we might want to process Twitter stream
  //We can use stream for this as it is lazy. Most collections are strict or eager meaning they will try to store all
  //data in memory but a stream is lazy, in that it will take the head data only when it is needed
  //then wait for the tail data when the client asks for it

  //An example of a stream processing

  println("**** Stream processing ****")
  import scala.math.BigInt

  //val fib : Stream[BigInt] = BigInt(0) #:: BigInt(1) #:: fib.zip(fib.tail).map(x => x._2 + x._1)

  //To understand this pattern, do this

  //Defining a Stream
  val bigInts : Stream[BigInt] = BigInt(0) #:: BigInt(1) #:: Stream.empty

  //printing a stream
  val bigIntFromStream : Stream[BigInt] = BigInt(0) #:: BigInt(1) #:: bigIntFromStream.zip(bigIntFromStream.tail).map{x =>
    println(s"stream = ${bigIntFromStream} + stream.tail = ${bigIntFromStream.tail} + zipped value = ${bigIntFromStream.zip(bigIntFromStream.tail)}")
    println(s"Calculating value for ${x}, {x._1} = ${x._1}, {x._2} = ${x._2}")
    x._1 + x._2}

  bigIntFromStream take(7) foreach(x => print(s"${x} "))

  println("========================================")

  val fibs : Stream[BigInt] = BigInt(0) #:: BigInt(1) #:: fibs.zip(fibs.tail).map{x =>
    println(s"Calculating value for ${x}, {x._1} = ${x._1}, {x._2} = ${x._2}")
      x._2}

  fibs take(10) foreach(x => print(s"${x} "))


  println("========================================")

  var i = 0
  def fib:Stream[Int] = {
    i = i + 1
    println("new Stream : " + i)
    Stream.cons(1, Stream.cons(1, (fib zip fib.tail) map {case (x, y) => x + y}))
  }

  fib take(5) foreach(x => println(s"${x} "))


  //Stream tests
  val stream1 = BigInt(0) #:: BigInt(1) #:: BigInt(1) #:: BigInt(2) #:: BigInt(3) #:: BigInt(5) #:: Stream.empty

  val stream2 = BigInt(1) #:: BigInt(1) #:: BigInt(2) #:: BigInt(3) #:: BigInt(5) #:: Stream.empty

  stream1.zip(stream2).foreach(println)
}
