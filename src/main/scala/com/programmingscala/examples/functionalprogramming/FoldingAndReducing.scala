package com.programmingscala.examples.functionalprogramming

object FoldingAndReducing extends App {

  //The difference between folding and reducing is that fold uses an initial default value but reduce uses a value
  //from the list as an accumulator

  val list = List(1,2,3,4,5,6)

  println(list reduce (_ + _))

  println(list.fold (10)(_ + _))

  //Another good example of fold

  //The difference between foldLeft and foldRight is that the order of the accumulator and the listitem is also different
  val outputFoldRight = list.foldRight (List.empty[String])  {
    (x, l) => {
      println(("[" + l + "]") + x + " " + x.getClass + " " + l.getClass)
      ("[" + x + "]") :: l
    }
  }

  val outputFoldLeft = list.foldLeft (List.empty[String])  {
    (l, x) => {
      println(("[" + l + "]") + x + " " + x.getClass + " " + l.getClass)
      ("[" + x + "]") :: l
    }
  }




  //For fold input and output must be of the same type
  //because it can process its inputs in various orders and so the inputs and output must all have the same type.
  val listChar = List("a","b","c")
  val output1 = listChar.fold ("")  {
    (x, l) => {
      println(("[" + l + "]") + x + " " + x.getClass + " " + l.getClass)
      (x + l)
    }
  }

  println("printing outputs ... ")

  println(outputFoldRight)
  println(outputFoldLeft)

  //THe same style will work for this input
  val listofChar = List(List("a"),List("b"),List("c"))
  val output2 = listofChar.fold (List.empty[String])  {
    (x, l) => {
      println(("[" + l + "]") + x + " " + x.getClass + " " + l.getClass)
      ("[" + l + "]") :: x
    }
  }



  println(output1)
  println(output2)

  //When using reduce, an execption is thrown if the list is empty, we can use reduceOption

  val lists = List.empty[Int]
  val output3 = list.reduceOption((x, l) => x + l)
  val output4 = lists.reduceOption((x,l) => x + l)

  println(output3)
  println(output4)


  def getSum(list : List[Int]) = {
    list.reduceOption(_ + _)
  }

  println(getSum(list))

  println(getSum(List.empty[Int]))

  println(list.scan(2)(_ + _)) //2 is the seed value

}
