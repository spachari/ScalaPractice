package com.programmingscala.examples.types.higherkinded.types


//Simple type class pattern
trait Add[T] {
  def add(a : T, b : T) : T
}

object Add {
  implicit val addInt = new Add[Int]{ //Here you provide implementations of the trait
    override def add(a: Int, b: Int) = a + b
  }

  implicit val addTupleInts = new Add[(Int, Int)] {
    override def add(a: (Int, Int), b: (Int, Int)): (Int, Int) = (a._1 + b._1, b._1 + b._2)
  }
}

object SimpleTypeClassPattern extends App {

  //Let's try to use it
  def myreduce(v : Seq[Int]) = v.reduce((a, b) => a + b)

  def myReduce1[T ](v : Seq[T])(implicit ev : Add[T]) = { //Even though you cal only the trait and it's method Add[T].add ,
    v.reduce(ev.add(_,_))                      //it will bring in the corresponding object's methods you want
  }

  //Either or

  def myReduce2[T : Add](v : Seq[T]) = {
    v.reduce((a,b) => implicitly[Add[T]].add(a,b))
  }


  val vector = Vector(1,2,3,4,5)

  println(myreduce(vector))
  println(myReduce1(vector))
  println(myReduce1(vector))

  //To the point of Higher kinded types, we can do the following
  val vectorOfMaps : Vector[(Int, Int)] = Vector(1 -> 10, 2 -> 20, 3 -> 30)
  println(myReduce2(vectorOfMaps))

  val option = Vector(Some(10),Some(10))

  //println(myReduce1(option)) //It will not work for

}
